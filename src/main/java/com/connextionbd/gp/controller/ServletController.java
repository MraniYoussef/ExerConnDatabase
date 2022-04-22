package com.connextionbd.gp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connextionbd.gp.entities.ProduitModel;
import com.connextionbd.gp.dao.ProduitDao;
import com.connextionbd.gp.dao.impl.ProduitDaoImpl;


@WebServlet(name="servl", urlPatterns={"*.get"})
public class ServletController extends HttpServlet {
	
	ProduitDao dao;
	ProduitModel model;
	@Override
	public void init() throws ServletException {
		
		dao = new ProduitDaoImpl();
		model = new ProduitModel();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/produits.get")) {
			List<ProduitModel> produits = dao.afficher();
			model.setListProduits(produits);
			model.setKeyword("");
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);

		}
		else if(path.equals("/chercher.get")) {
			String keyword = request.getParameter("keyword");
			
			List<ProduitModel> produitsAChercher = dao.afficherProduits("%"+keyword+"%");
			model.setListProduits(produitsAChercher);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/ajouter.get")) {
			request.setAttribute("produit", new ProduitModel());
			request.getRequestDispatcher("ajouterProduit.jsp").forward(request, response);

		}
		else if(path.equals("/saveProduit.get") && (request.getMethod().equals("POST"))){
			String code = request.getParameter("code");
			String designation = request.getParameter("designation");
			ProduitModel produit = new ProduitModel();
			produit.setCode(code);
			produit.setDesignation(designation);
			dao.ajouterProduit(produit);
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);

	}
		else if(path.equals("/supprimer.get")) {
			String code = request.getParameter("code");
			System.out.println("heeeeere"+code);
			dao.supprimerProduit(code);
			response.sendRedirect("produits.get");
		}
		else if(path.equals("/modifier.get")) {
			String code = request.getParameter("code");
			ProduitModel produitAModifier = new ProduitModel();
			produitAModifier = dao.chercherProduitParCode(code);
			request.setAttribute("produit", produitAModifier);
			request.getRequestDispatcher("editProduit.jsp").forward(request, response);
		}
		else if(path.equals("/modifierProduit.get") && (request.getMethod().equals("POST"))){
			String code = request.getParameter("code");
			String designation = request.getParameter("designation");
			ProduitModel productAModifier = new ProduitModel();
			productAModifier.setCode(code);
			productAModifier.setDesignation(designation);
			
			dao.modifierProduit(productAModifier);
			request.setAttribute("produit", productAModifier);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);

	}

		else {
			response.sendError(response.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

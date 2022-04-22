package com.connextionbd.gp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.connextionbd.gp.entities.ProduitModel;
import com.connextionbd.gp.dao.ProduitDao;
import com.connextionbd.gp.dao.singleton.SingletonConnection;

public class ProduitDaoImpl implements ProduitDao {

	@Override
	public ProduitModel ajouterProduit(ProduitModel produit) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
			("INSERT INTO PRODUITS (CODE, DESIGNATION) VALUES(?,?) ");
			ps.setString(1, produit.getCode());
			ps.setString(2, produit.getDesignation());
			ps.executeUpdate();
			
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return produit;
	}

	@Override
	public List<ProduitModel> afficherProduits(String keyword) {
		List<ProduitModel> produits = new ArrayList<ProduitModel>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ? ");
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProduitModel produit = new ProduitModel();
				produit.setCode(rs.getString("CODE"));
				produit.setDesignation(rs.getString("DESIGNATION"));
				
				produits.add(produit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	

	@Override
	public ProduitModel modifierProduit(ProduitModel produit) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
			("UPDATE PRODUITS SET CODE=?, DESIGNATION=? WHERE CODE=? ");
			ps.setString(1, produit.getCode());
			ps.setString(2, produit.getDesignation());
			ps.setString(3, produit.getCode());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return produit;
	}

	@Override
	public void supprimerProduit(String codeProduit) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
			(" DELETE FROM PRODUITS WHERE CODE=? ");
			ps.setString(1, codeProduit);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

	@Override
	public ProduitModel chercherProduitParCode(String code) {
		ProduitModel produitToGet = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUITS WHERE CODE=? ");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				produitToGet = new ProduitModel();
				produitToGet.setCode(rs.getString("CODE"));
				produitToGet.setDesignation(rs.getString("DESIGNATION"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produitToGet;
	}

	@Override
	public List<ProduitModel> afficher() {
		List<ProduitModel> produits = new ArrayList<ProduitModel>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUITS ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProduitModel produit = new ProduitModel();
				produit.setCode(rs.getString("CODE"));
				produit.setDesignation(rs.getString("DESIGNATION"));
				
				produits.add(produit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	

	
}

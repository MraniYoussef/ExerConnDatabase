package com.connextionbd.gp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.connextionbd.gp.dao.impl.ProduitDaoImpl;
import com.connextionbd.gp.entities.ProduitModel;

class TestProduit {
	ProduitDaoImpl dao;
	@BeforeEach
	
	public void init() {
		dao = new ProduitDaoImpl();
	}
	@Test void 
	testModifierProduit() throws SQLException {
		ProduitModel produitAModifier = dao.chercherProduitParCode("10000A");
		produitAModifier.setDesignation("Smartphone SSS");
		dao.modifierProduit(produitAModifier);
		}
	@Test void
	testSupprimerProduit() {
		dao.supprimerProduit("  40000C"); 
		}
	@Test
	void testAfficher() throws SQLException {
		for(ProduitModel p : dao.afficher()) {
			System.out.println(p.toString());
		}
	}
	@Test 
	void testChercherProduitParCode() throws SQLException { 
		ProduitModel produit = dao.chercherProduitParCode("10000A");
		System.out.println(produit.getDesignation());
	}
	@Test
	void testAjouterProduit() throws SQLException {
		ProduitModel produitAAjouter = new ProduitModel("50000D","Maison");
		dao.ajouterProduit(produitAAjouter);
 }
	@Test void
	testAfficherProduits() throws SQLException { 
		List<ProduitModel> produits = new ArrayList<ProduitModel>();
		produits = dao.afficherProduits("%"+"S"+"%");
		for(ProduitModel p : produits) {
		System.out.println("eee"+ p.toString());
		}
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}

package com.connextionbd.gp.dao;

import java.util.List;

import com.connextionbd.gp.entities.ProduitModel;;


public interface ProduitDao {
	public ProduitModel ajouterProduit(ProduitModel product);
	public List<ProduitModel> afficherProduits(String keyword);
	public List<ProduitModel> afficher();
	public ProduitModel chercherProduitParCode(String code);
	public ProduitModel modifierProduit(ProduitModel produit);
	public void supprimerProduit(String codeProduit);

}

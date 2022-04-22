package com.connextionbd.gp.entities;

import java.util.ArrayList;
import java.util.List;

public class ProduitModel {
	
	private String code;
	private String designation;
	private String keyword;
	private List<ProduitModel> listProduits = new ArrayList<>();
	public ProduitModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProduitModel(String code, String designation) {
		super();
		this.code = code;
		this.designation = designation;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<ProduitModel> getListProduits() {
		return listProduits;
	}
	public void setListProduits(List<ProduitModel> listProduits) {
		this.listProduits = listProduits;
	}
	@Override
	public String toString() {
		return "ProduitModel [code=" + code + ", designation=" + designation +  "]";
	}
	

}

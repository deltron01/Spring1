package services;

import java.util.List;

import dao.Produit;
import dao.ProduitDAO;

public class ProduitImpMetier implements ProduitMetier {
	
    private ProduitDAO dao;
	
	public void setDao(ProduitDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addProduit(Produit p) {
	    dao.addProduit(p);
	}

	@Override
	public void deleteProduit(Long id) {
		dao.deleteProduit(id);
	}

	@Override
	public List<Produit> getAllProduits() {
		return dao.getAllProduits();
	}
	
	@Override
	public Produit getProduitById(Long id) {
		return 	dao.getProduitByID(id);	
	}

}

package dao;

import java.util.List;

public interface ProduitDAO {
	
	public void addProduit(Produit p);
	public void deleteProduit( Long id );
    public Produit getProduitByID(Long id);
    public List<Produit> getAllProduits();
    public void updateProduit(Produit p);
}

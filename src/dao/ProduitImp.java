package dao;

import java.util.ArrayList;
import java.util.List;

public class ProduitImp implements ProduitDAO {

	private List<Produit> produits = new ArrayList<Produit>();
	
	public void init(){
		System.out.println(" initiate the bean produitIMp Maatalla $");
		addProduit(new Produit("PC","ASUS",7500.0));
		addProduit(new Produit("PSP","SONY",2600.0));
		addProduit(new Produit("TV","SAMSUNG",4000.0));
		addProduit(new Produit("AUTOMOBILE","WOLKSWAGEN",355000.0));
	}
	@Override
	public void addProduit(Produit p) {
		p.setIdP(new Long(produits.size()+1));
		produits.add(p);
	}

	@Override
	public void deleteProduit(Long id) {
		for( Produit p:produits){
			if(p.getIdP().equals(id)){
				produits.remove(p);
				break;
			}
		}
		
	}

	@Override
	public Produit getProduitByID(Long id) {
		Produit prod = null;
		for( Produit p:produits){
			if(p.getIdP().equals(id)){
				prod = p;
				break;
			}
		}
		return prod;
	}

	@Override
	public List<Produit> getAllProduits() {
		
		return produits;
	}

	@Override
	public void updateProduit(Produit p) {
	
		
	}
	

}

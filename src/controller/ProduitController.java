package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.RequestParam;

import dao.Produit;
import services.ProduitMetier;

@Controller
public class ProduitController {
    @Autowired  
	ProduitMetier services; /* services est une interface mais elle s'est affecté l'objet 
    ProduitImpMetier (spring-beans) et ceci grâce à Autowired */
    
	@RequestMapping(value="/index")
	public String pageIndex(Model model){
		// traitements....
		
		model.addAttribute("listeproduit", services.getAllProduits());		
		return "produits";
		// ça donne  /Prefix/produit.jsp  ( jsp = suffixe, ici )
	}
	
	@RequestMapping(value="/search")
	public String pageSearch(Model model,@RequestParam Long id) /* id représente exactement le id qui figure 
	dans l'attribut name de la balise qui est dans form */
	{
		// traitements....
		List<Produit> L = new ArrayList<Produit>();				
		L.add(services.getProduitById(id));		
		model.addAttribute("listeproduit", L);
		model.addAttribute("researched", id);
		return "produits";
		// ça donne  /Prefix/produit.jsp  ( jsp = suffixe, ici )
	}
	// Ajouter un produit
	/* @RequestParam String nom,
	   @RequestParam String description
	   @RequestParam Double price
	 */
	@RequestMapping(value="/add")
	public String addp(Model model, Produit p)
	{		
		// traitements....
		//Produit p = new Produit(nom, description, price);
		services.addProduit(p);				
		model.addAttribute("listeproduit", services.getAllProduits());		
		return "produits";
		// ça donne  /Prefix/produit.jsp  ( jsp = suffixe, ici )
	}
	// Supprimer un produit
	@RequestMapping(value="/delete")
	public String loschen(Model model,@RequestParam Long id)
	{		
		// traitements....
		
		services.deleteProduit(id);			
		model.addAttribute("listeproduit", services.getAllProduits());
		return "produits";
		// ça donne  /Prefix/produit.jsp  ( jsp = suffixe, ici )
	}
	
	
}

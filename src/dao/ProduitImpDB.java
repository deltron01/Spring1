package dao;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class ProduitImpDB implements ProduitDAO {

	public void init(){
		System.out.println(" initiate the bean produitIMp Maatalla $");
		addProduit(new Produit("PC","ASUS",7500.0));
		addProduit(new Produit("PSP","SONY",2600.0));
		addProduit(new Produit("TV","SAMSUNG",4000.0));
		addProduit(new Produit("AUTOMOBILE","WOLKSWAGEN",355000.0));
	}
	@Override
	public void addProduit(Produit p) {
		Session session;		
		try {         
			   session = HibernateUtil.getSessionFactory().getCurrentSession();  
		} catch (org.hibernate.HibernateException exp) {  
			   session = HibernateUtil.getSessionFactory().openSession();     
		} 		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();

	}

	@Override
	public void deleteProduit(Long id) {
		Session session;		
		try {         
			   session = HibernateUtil.getSessionFactory().getCurrentSession();  
		} catch (org.hibernate.HibernateException exp) {  
			   session = HibernateUtil.getSessionFactory().openSession();     
		} 		
		session.beginTransaction();
		Produit p = (Produit) session.load(Produit.class, id);
		session.delete(p);
		session.getTransaction().commit();

	}

	@Override
	public Produit getProduitByID(Long id) {
		Session session;		
		try {         
			   session = HibernateUtil.getSessionFactory().getCurrentSession();  
		} catch (org.hibernate.HibernateException exp) {  
			   session = HibernateUtil.getSessionFactory().openSession();     
		} 		
		session.beginTransaction();
		Produit p = (Produit) session.load(Produit.class, id);
		return p;
	}

	@Override
	public List<Produit> getAllProduits() {
		Session session;		
		try {         
			   session = HibernateUtil.getSessionFactory().getCurrentSession();  
		} catch (org.hibernate.HibernateException exp) {  
			   session = HibernateUtil.getSessionFactory().openSession();     
		} 		
		session.beginTransaction();
		return  session.createQuery("FROM Produit").list();
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub

	}

}

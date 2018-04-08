import java.sql.Date;
import java.util.List;

import Model.Departement;
import Model.Article;
import Model.Chercheur;
import Model.Equipe;
import Persistence.AbstractPersistence;

public class Main {

	public static void main(String[] args) {
		
		AbstractPersistence<Departement> o = 
				new AbstractPersistence<Departement>(Departement.class);
		o.setUp();
		o.ouvrirSession();// U1
		
		AbstractPersistence<Article> o2 = 
				new AbstractPersistence<Article>(Article.class);
		o2.setUp();
		o2.ouvrirSession();// U1
		
		AbstractPersistence<Chercheur> o3 = 
				new AbstractPersistence<Chercheur>(Chercheur.class);
		o3.setUp();
		o3.ouvrirSession();// U1
		
		AbstractPersistence<Equipe> o4 = 
				new AbstractPersistence<Equipe>(Equipe.class);
		o4.setUp();
		o4.ouvrirSession();// U1
		
		try {
			
			Departement c = o.read("Informatique");
			// #1
			System.out.println("Afficher le département Informatique\n");
			System.out.println(c.getNom() + ", " + c.getDateCreation() + ", " + c.getAdresse() + ", " + c.getTelephone());
			
			// #2
			

			List<Article> articles = o2.read();
			
			System.out.println("\nAfficher tous les auteurs\n");
			for(Article a: articles) {
				System.out.println(String.valueOf(a.getAuteur().getMatricule()) + ", " + a.getAuteur().getPrenom() + ", " + a.getAuteur().getNom() +  "\n");
			}
			
			
			// #3
			System.out.println("\nAfficher tous les auteurs avec publications\n");
			for(Article a: articles) {
				System.out.println(String.valueOf(a.getAuteur().getMatricule()) + ", " + a.getAuteur().getPrenom() + ", " 
						+ String.copyValueOf(a.getCoauteur()) + ", " + a.getSoumisLe() + ", " + a.getDepartement().getNom() + "\n");
			}
			
			// #3
			System.out.println("\nAfficher l’auteur et ses publications dont son identifiant est M22556\n");
			
			char[] id = { 'M', '2', '2', '5', '5', '6' };
			Chercheur chercheur = o3.read(id);
			System.out.println(String.valueOf(chercheur.getMatricule()) + ", " + chercheur.getPrenom() + ", " + chercheur.getNom() + "\n");
			
			List<Article> articles2 = o2.query("where auteur='" + String.valueOf(chercheur.getMatricule()) + "'");
			for(Article a: articles2) {
			System.out.println(String.valueOf(a.getAuteur().getMatricule()) + ", " + a.getAuteur().getPrenom() + ", " 
				+ String.copyValueOf(a.getCoauteur()) + ", " + a.getSoumisLe() + ", " + a.getDepartement().getNom() + "\n");
			}
			
			// #5
			System.out.println("\nSupprimer l’article qui a été publié par le département Mathématique\n");
				
//			Boolean success = o2.delete("where departement='Mathematiques'");
//			System.out.println("SUCCESS?" + Boolean.toString(success));
			
			// #6
			System.out.println("\nSupprimer l’auteur qui a publié un article le 16-05-2007\n");
							
//			List<Article> articles3 = o2.query("where soumisLe='2007-05-16 00:00:00.000000'");
//			Boolean success1 = o2.delete("where soumisLe='2007-05-16 00:00:00.000000'");
//			Boolean success2 = o3.delete("where matricule='" + String.valueOf(articles3.get(0).getAuteur().getMatricule()) + "'");
//			System.out.println("SUCCESS?" + Boolean.toString(success1) + Boolean.toString(success2));
			
			//# 7
//			System.out.println("\nModifier l’adresse du département Physique qui a déménagé au Quebec\n");
//			Departement d1 = o.read("Physique");
//			d1.setAdresse("Quebec");
//			System.out.println("ADRESSE" + d1.getAdresse());
//			o.update(d1);
			
			// #8
			System.out.println("\nModifier la position des chercheurs qui sont tous en postdoc maintenant et qui appartiennent au département Mathématique.\n");
			List<Chercheur> chercheurs = o3.read();
			
			for (Chercheur c2: chercheurs) {
				if (c2.getEquipe().getDepartement().getNom().equals("Mathematiques")) {
					c2.setPosition("postdoc");
					o3.update(c2);
				}
					
			}
			
			// #9
			System.out.println("\nAjouter le nouveau département de Medecine qui a été crée le premier mars 2018 et qui est basé à Gaspésie.\n");
			
			Departement dep = new Departement("Medecine", new Date(1519858800), "Gaspesie", "");
			o.add(dep);
			
			// #9
			System.out.println("\nAjouter une nouvelle équipe « Pédiatre » qui appartient au département de médecine\n");
			
			Equipe eq = new Equipe("Pediatre", new Date(1519862400), dep, "Loïc", 0);
			o4.add(eq);
			
			o.fermerSession();
			o.close();
			
			o2.fermerSession();
			o2.close();
			
			o3.fermerSession();
			o3.close();
			
			o4.fermerSession();
			o4.close();
			
		} catch (Exception e) {
			o.fermerSession();
			o.close();
			
			o2.fermerSession();
			o2.close();
			
			o3.fermerSession();
			o3.close();
			
			o4.fermerSession();
			o4.close();
			
			System.out.println(e.getMessage());
		}

		
		
		
//		c.setDiscnt(12);
//		o.update(c);
//
//		for (Commande cm : c.getCommandes()) {
//			System.out.println(cm.getQty());
//		}
//
//		o.fermerSession();
//
//		o.ouvrirSession(); // U2
//		c = o.read("c001");
//		System.out.println(c.getNom());
//		o.fermerSession();
//
//		o.ouvrirSession(); // U2
//		List<Client> cls = o.read();
//		for (Client client : cls) {
//			System.out.println(client.getNom());
//		}
//
//
//		o.fermerSession();
//
//
//
//
//
//		o.close();
//



	}

}

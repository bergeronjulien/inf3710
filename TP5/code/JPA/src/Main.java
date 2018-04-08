import java.sql.Date;
import java.util.List;

import Model.Article;
import Model.Chercheur;
import Model.Departement;
import Model.Equipe;
import Persistence.PAbstract;

public class Main {

	public static void main(String[] args) {
		PAbstract<Chercheur> c = new PAbstract<Chercheur>(Chercheur.class);
		c.setUp();
		
		PAbstract<Departement> d = new PAbstract<Departement>(Departement.class);
		d.setUp();
		
		PAbstract<Article> a = new PAbstract<Article>(Article.class);
		a.setUp();
		
		PAbstract<Equipe> e = new PAbstract<Equipe>(Equipe.class);
		e.setUp();
		
		// #1 
		System.out.println("\nAfficher le département Informatique.\n");
		Departement dep = d.read("Informatique");
		System.out.println(dep);
		
		// #2 
		System.out.println("\nAfficher tous les auteurs\n");
		List<Article> articles = a.read();
		
		for (Article article : articles) {
			System.out.println(article.getAuteur());
		}
		
		// #3
		System.out.println("\nAfficher tous les auteurs avec publications\n");
		List<Article> articles2 = a.read();
		
		for (Article article : articles2) {
			System.out.println(article + " & " + article.getAuteur());
		}
		
		// #4
		System.out.println("\nAfficher l’auteur et ses publications dont son identifiant est M22556\n");
		Chercheur chercheur = c.read("M22556");
		System.out.println(chercheur);
		
		List<Article> articles3 = a.query("where auteur='" + chercheur.getMatricule() + "'");
		for(Article art : articles3) {
			System.out.println(art);
		}
		
		// #5
//		System.out.println("\n\nSupprimer l’article qui a été publié par le département Mathématique\n");
						
//		a.delete("where departement='Mathematiques'");
					
		// #6
//		System.out.println("\nSupprimer l’auteur qui a publié un article le 16-05-2007\n");
//									
//		Article articles4 = (Article) a.queryOne("where soumisLe='2007-05-16 00:00:00.000000'");
//		a.delete("where soumisLe='2007-05-16 00:00:00.000000'");
//		c.delete("where matricule='" + articles4.getAuteur().getMatricule() + "'");
					
		//# 7
//		System.out.println("\nModifier l’adresse du département Physique qui a déménagé au Quebec\n");
//		
//		Departement d1 = d.read("Physique");
//		d1.setAdresse("Quebec");
//		System.out.println("ADRESSE" + d1.getAdresse());
//		d.update(d1);
					
		// #8
//		System.out.println("\nModifier la position des chercheurs qui sont tous en postdoc maintenant et qui appartiennent au département Mathématique.\n");
//		List<Chercheur> chercheurs = c.read();
//					
//		for (Chercheur c2: chercheurs) {
//			if (c2.getEquipe().getDepartement().getNom().equals("Mathematiques")) {
//				c2.setPosition("postdoc");
//				c.update(c2);
//			}			
//		}
					
		// #9
		System.out.println("\nAjouter le nouveau département de Medecine qui a été crée le premier mars 2018 et qui est basé à Gaspésie.\n");
					
		Departement dep2 = new Departement();
		dep2.setNom("Medecine");
		dep2.setDateCreation(new Date(1519858800));
		dep2.setAdresse("Gaspesie");
		d.add(dep2);
					
		// #10
		System.out.println("\nAjouter une nouvelle équipe « Pédiatre » qui appartient au département de médecine\n");
					
		Equipe eq = new Equipe();
		eq.setNom("Pediatre");
		eq.setDateCreation(new Date(1519862400));
		eq.setDepartement(dep2);
		eq.setResponsable("Loïc");
		e.add(eq);
		
		c.close();
		d.close();
		a.close();
		e.close();
	}
}

package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Customers;

public class Main {
	public static void main(String[] args) {
		// Se connecter à la base de données
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:postgresql://192.168.242.130:5432/tp5", 
					"postgres", 
					"inf3710");

			Statement stmt = connexion.createStatement();
			
			System.out.println("- AFFICHER DEPARTEMENT INFORMATIQUE" + '\n');
			ResultSet depInfo = stmt.executeQuery("select * from departement where nom = 'Informatique'");
			while (depInfo.next()) {
				System.out.print(depInfo.getString("nom")+", ");
				System.out.print(depInfo.getDate("dateCreation")+", ");
				System.out.print(depInfo.getString("adresse")+", ");
				System.out.println(depInfo.getString("telephone"));
			}
			
			System.out.println('\n' + "- AFFICHER AUTEURS" + '\n');
			ResultSet auteurs = stmt.executeQuery("select distinct * from article, chercheur where auteur = matricule");
			while (auteurs.next()) {
				System.out.print(auteurs.getString("auteur")+'\t'+'\t');
				System.out.print(auteurs.getString("prenom")+'\t'+'\t');
				System.out.println(auteurs.getString("nom"));
			}
			
			System.out.println('\n' + "- AFFICHER AUTEURS AVEC PUBLICATIONS" + '\n');
			ResultSet auteursPublications = stmt.executeQuery("select * from article, chercheur where auteur = matricule");
			while (auteursPublications.next()) {
				System.out.print(auteursPublications.getString("auteur")+'\t'+'\t');
				System.out.print(auteursPublications.getString("prenom")+'\t'+'\t');
				System.out.print(auteursPublications.getString("coauteur")+'\t'+'\t');
				System.out.print(auteursPublications.getDate("soumisle")+",  ");
				System.out.println(auteursPublications.getString("departement"));
			}
			
			System.out.println('\n' + "- AFFICHER PUBLICATION DE M22556" + '\n');
			ResultSet auteurM22556 = stmt.executeQuery("select * from article, chercheur where auteur = 'M22556' and auteur = matricule");
			while (auteurM22556.next()) {
				System.out.print(auteurM22556.getString("auteur")+'\t'+'\t');
				System.out.print(auteurM22556.getString("prenom")+'\t'+'\t');
				System.out.print(auteurM22556.getString("coauteur")+'\t'+'\t');
				System.out.print(auteurM22556.getDate("soumisle")+",  ");
				System.out.println(auteurM22556.getString("departement"));
			}
			
			System.out.println('\n' + "- SUPPRESSION" + '\n');
//			stmt.executeQuery("DELETE from article where departement = 'Mathematiques'");
			
			System.out.println('\n' + "- SUPPRESSION AUTEUR" + '\n');
//			stmt.executeQuery("delete from article where soumisLe = '2007-05-16'");
//			suppressionAuteur = stmt.executeQuery("DELETE from chercheur where matricule = 'M48543'");

			System.out.println('\n' + "- MAJ ADRESSE" + '\n');
//			stmt.executeQuery("UPDATE departement SET adresse = 'Quebec' where nom = 'Physique'");
			
			System.out.println('\n' + "- MAJ POSITION et Mathematique" + '\n');
//			stmt.executeQuery("UPDATE chercheur SET position = 'postdoc' where equipe = (select nom from equipe where departement = 'Mathematiques')");
			
			System.out.println('\n' + "- Creation dep. Med" + '\n');
//			stmt.executeQuery("INSERT INTO Departement VALUES ('Medecine', TO_DATE('01-03-2018','DD:MM:YYYY'), 'Gaspesie')");
			
			System.out.println('\n' + "- Creation equipe Pediatre" + '\n');
//			stmt.executeQuery("INSERT INTO Equipe VALUES ('Pediatre', TO_DATE('01-03-2018','DD:MM:YYYY'), 'Medecine')");

			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

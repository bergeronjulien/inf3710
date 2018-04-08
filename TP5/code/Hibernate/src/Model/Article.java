package Model;

import java.sql.Date;

public class Article implements java.io.Serializable {
	private Chercheur auteur;
	private char[] coauteur;
	private Date soumisLe;
	private Departement departement;
	
	public Article() {};
	 
	public Article(Chercheur auteur, char[] coauteur, Date soumisLe, Departement departement) {
		this.setAuteur(auteur);
		this.setCoauteur(coauteur);
		this.setSoumisLe(soumisLe);
		this.setDepartement(departement);
	}
	
	public Chercheur getAuteur() {
		return auteur;
	}
	
	public void setAuteur(Chercheur auteur) {
		this.auteur = auteur;
	}
	
	public char[] getCoauteur() {
		return coauteur;
	}
	
	public void setCoauteur(char[] coauteur) {
		this.coauteur = coauteur;
	}
	
	public Date getSoumisLe() {
		return soumisLe;
	}
	
	public void setSoumisLe(Date soumisLe) {
		this.soumisLe = soumisLe;
	}
	
	public Departement getDepartement() {
		return departement;
	}
	
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}


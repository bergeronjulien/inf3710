package Model;

import java.sql.Date;

public class Article {
	private Chercheur auteur;
	private Chercheur coauteur;
	private Date soumisLe;
	private Departement departement;
	
	public Article() {};
	 
	public Article(Chercheur auteur, Chercheur coauteur, Date soumisLe, Departement departement) {
		this.setAuteur(coauteur);
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
	
	public Chercheur getCoauteur() {
		return coauteur;
	}
	
	public void setCoauteur(Chercheur coauteur) {
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


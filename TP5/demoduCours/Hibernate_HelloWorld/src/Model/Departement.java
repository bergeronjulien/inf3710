package Model;

import java.sql.Date;

public class Departement {
	
	private String nom;
	private Date dateCreation;
	private String adresse;
	private String telephone;
	
	public Departement() {};
	
	public Departement(String nom, Date dateCreation, String adresse, String telephone) {
		this.setNom(nom);
		this.setDateCreation(dateCreation);
		this.setAdresse(adresse);
		this.setTelephone(telephone);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}

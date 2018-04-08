package Model;

import java.sql.Date;

public class Equipe {
	
	private String nom;
	private Date dateCreation;
	private Departement departement;
	private String responsable;
	private int nbrProjets;
	
	public Equipe() {};
	
	public Equipe(String nom, Date dateCreation, Departement departement, String responsable, int nbrProjets) {
		this.setNom(nom);
		this.setDateCreation(dateCreation);
		this.setDepartement(departement);
		this.setResponsable(responsable);
		this.setNbrProjets(nbrProjets);
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


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public int getNbrProjets() {
		return nbrProjets;
	}

	public void setNbrProjets(int nbrProjets) {
		this.nbrProjets = nbrProjets;
	}

	public String toString() {
		return this.nom;
	}
}

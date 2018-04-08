package Model;

import java.io.Serializable;
import java.sql.Date;

public class ArticlePK implements Serializable {
	private Chercheur auteur;
	private Date soumisLe;
	private Departement departement;
	
	public ArticlePK() {};

    public ArticlePK(Chercheur auteur, Date soumisLe, Departement departement) {
    	this.setAuteur(auteur);
		this.setSoumisLe(soumisLe);
		this.setDepartement(departement);
    }
    // equals, hashCode
    

	public Chercheur getAuteur() {
		return auteur;
	}
	
	public void setAuteur(Chercheur auteur) {
		this.auteur = auteur;
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


package Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.Order;

@Entity
@Table(name="article")
public class Article implements java.io.Serializable {

	@Id
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="auteur")
	private Chercheur auteur;
	
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="departement")
	private Chercheur coauteur;
	
	@Id
	@Column(name="soumisLe")
	private Date soumisLe;
	
	@Id
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="departement")
	private Departement departement;
	
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

	@Override
	public String toString() {
		return String.valueOf(auteur.getMatricule()) + "," + String.valueOf(coauteur.getMatricule()) + "," + soumisLe + "," + departement.getNom();
	}
}

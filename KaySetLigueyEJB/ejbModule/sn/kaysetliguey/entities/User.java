package sn.kaysetliguey.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=150)
	private String pNom;
	@Column(length=150)
	private String nom;
	@Column
	private String email;
	@Column
	private String mdp;
	@Column
	private String profil;
	

	@OneToMany(mappedBy="user")
	private List<Job> job = new ArrayList<Job>();
	
	
//	@OneToMany(mappedBy="user")
//	private List<Employeur> employeur = new ArrayList<Employeur>();
	
//	@OneToMany(mappedBy="user")
//	private List<Demandeur> demandeur = new ArrayList<Demandeur>();
	
	public User() {
		super();
	}
	public User(int id, String pNom, String nom, String email, String mdp, String profil) {
		super();
		this.id = id;
		this.pNom = pNom;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.profil = profil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpNom() {
		return pNom;
	}
	public void setpNom(String pNom) {
		this.pNom = pNom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	
//	public List<Employeur> getEmployeur() {
//		return employeur;
//	}
//	public void setEmployeur(List<Employeur> employeur) {
//		this.employeur = employeur;
//	}
//	public List<Demandeur> getDemandeur() {
//		return demandeur;
//	}
//	public void setDemandeur(List<Demandeur> demandeur) {
//		this.demandeur = demandeur;
//	}
	
	
}

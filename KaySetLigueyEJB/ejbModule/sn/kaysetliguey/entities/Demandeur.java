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
public class Demandeur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String pnom;
	@Column
	private String nom;
	@Column
	private String sexe;
	@Column
	private String age;
	@Column
	private String email;
	
	@OneToMany(mappedBy="demandeur")
	private List<Cv> cv = new ArrayList<Cv>();
	
//	@ManyToOne
//	private User user = new User();
	
	
	public Demandeur() {
		super();
	}
	public Demandeur(int id, String pnom, String nom, String sexe, String username, String mdp, String email, String age) {
		super();
		this.id = id;
		this.pnom = pnom;
		this.nom = nom;
		this.sexe = sexe;
		this.email = email;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnom() {
		return pnom;
	}
	public void setPnom(String pnom) {
		this.pnom = pnom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public List<Cv> getCv() {
		return cv;
	}
	public void setCv(List<Cv> cv) {
		this.cv = cv;
	}
	
	

}

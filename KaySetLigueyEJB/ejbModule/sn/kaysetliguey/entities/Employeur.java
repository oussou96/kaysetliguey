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
public class Employeur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nEmp;
	@Column
	private String adresse;
	@Column
	private String email;
	@Column
	private String siteweb;
	
	
//	@ManyToOne
//	private User user = new User();
//	
//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}


	public Employeur() {
		super();
	}
	
	
	public Employeur(int id, String nEmp, String adresse, String email, String siteweb) {
		super();
		this.id = id;
		this.nEmp = nEmp;
		this.adresse = adresse;
		this.email = email;
		this.siteweb = siteweb;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getnEmp() {
		return nEmp;
	}


	public void setnEmp(String nEmp) {
		this.nEmp = nEmp;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSiteweb() {
		return siteweb;
	}


	public void setSiteweb(String siteweb) {
		this.siteweb = siteweb;
	}



	
	
	
	
}

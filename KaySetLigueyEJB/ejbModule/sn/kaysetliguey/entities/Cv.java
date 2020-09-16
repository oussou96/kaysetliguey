package sn.kaysetliguey.entities;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cv implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column
	private String telPro;
	@Column
	private String nivEtude;
	@Column
	private String expPro;
	@ManyToOne	
	private  Demandeur demandeur = new Demandeur ();
	
	public Cv() {
		super();
	}
	public Cv(int id, String telPro, String nivEtude, String expPro, Demandeur demandeur) {
		super();
		this.id = id;
		this.telPro = telPro;
		this.nivEtude = nivEtude;
		this.expPro = expPro;
		this.demandeur = demandeur;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelPro() {
		return telPro;
	}
	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}
	public String getNivEtude() {
		return nivEtude;
	}
	public void setNivEtude(String nivEtude) {
		this.nivEtude = nivEtude;
	}
	public String getExpPro() {
		return expPro;
	}
	public void setExpPro(String expPro) {
		this.expPro = expPro;
	}
	public Demandeur getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}
	
	
}

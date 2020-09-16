package sn.kaysetliguey.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity


public class Job implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column
	private String nomJob;
	@Column
	private double salaire;
	@Column
	private String job_desc;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateAnnonce;
	@Column(length=50)
	private String lieu;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateLimit;
	@ManyToOne
	private  Domaine domaine = new Domaine ();
	@ManyToOne
	private  User user = new User();	
	

	public Job() {
		super();
	}


	public Job(int id, String nomJob, double salaire, String job_desc, Date dateAnnonce, String lieu, Date dateLimit,
			Domaine domaine, User user) {
		super();
		this.id = id;
		this.nomJob = nomJob;
		this.salaire = salaire;
		this.job_desc = job_desc;
		this.dateAnnonce = dateAnnonce;
		this.lieu = lieu;
		this.dateLimit = dateLimit;
		this.domaine = domaine;
		this.user = user;
		
	}






	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomJob() {
		return nomJob;
	}


	public void setNomJob(String nomJob) {
		this.nomJob = nomJob;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	public String getJob_desc() {
		return job_desc;
	}


	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}


	public Date getDateAnnonce() {
		return dateAnnonce;
	}


	public void setDateAnnonce(Date dateAnnonce) {
		this.dateAnnonce = dateAnnonce;
	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public Date getDateLimit() {
		return dateLimit;
	}


	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}


	public Domaine getDomaine() {
		return domaine;
	}


	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
	
	
}

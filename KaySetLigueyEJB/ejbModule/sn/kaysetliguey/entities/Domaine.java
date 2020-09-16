package sn.kaysetliguey.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Domaine implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column
	private String intituleDomaine;
	
	@OneToMany(mappedBy="domaine")
	private List<Job> job = new ArrayList<Job>();

	public Domaine() {
		super();
	}

	public Domaine(int id, String intituleDomaine, List<Job> job) {
		super();
		this.id = id;
		this.intituleDomaine = intituleDomaine;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntituleDomaine() {
		return intituleDomaine;
	}

	public void setIntituleDomaine(String intituleDomaine) {
		this.intituleDomaine = intituleDomaine;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}
	

}

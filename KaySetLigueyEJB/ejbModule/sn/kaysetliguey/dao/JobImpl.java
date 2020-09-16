package sn.kaysetliguey.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.resteasy.annotations.Query;

import sn.kaysetliguey.entities.Domaine;
import sn.kaysetliguey.entities.Job;

@Stateless
public class JobImpl implements IJob{
	@PersistenceContext(unitName="KaySetLigueyEJB")
	private EntityManager em;
	@Override
	public int add(Job job) {
		
		try {
			em.persist(job);
			return 1;
		}catch (Exception ex) {
			return 0 ;
		}
	}

	@Override
	public int Update(Job job) {
		try {
			em.merge(job);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Job.class, id));
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	
	public List<Job> getAll() {
		try {
			return em.createQuery("SELECT b FROM Job b").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Job get(int id) {
		return em.find(Job.class, id);
	}
}



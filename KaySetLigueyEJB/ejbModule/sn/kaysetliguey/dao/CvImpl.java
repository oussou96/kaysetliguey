package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.kaysetliguey.entities.Cv;
import sn.kaysetliguey.entities.Demandeur;
import org.jboss.resteasy.annotations.Query;

@Stateless

public class CvImpl implements ICv {
	@PersistenceContext(unitName="KaySetLigueyEJB")
	private EntityManager em;
	@Override
	public int add(Cv cv) {
		try {
			em.persist(cv);
			return 1;
		}catch (Exception ex) {
			return 0 ;
		}
	}

	@Override
	public int Update(Cv cv) {
		try {
			em.merge(cv);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Cv.class, id));
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Cv> getAll() {
		try {
			return em.createQuery("SELECT cv FROM Cv cv").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Cv get(int id) {
		return em.find(Cv.class, id);
	}

}

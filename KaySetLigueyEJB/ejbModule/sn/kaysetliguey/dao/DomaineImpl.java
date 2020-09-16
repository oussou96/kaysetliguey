package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.kaysetliguey.entities.Domaine;
import sn.kaysetliguey.entities.Job;

@Stateless
public class DomaineImpl implements IDomaine {
	@PersistenceContext(unitName="KaySetLigueyEJB")
	private EntityManager em;
	@Override
public int add(Domaine domaine) {
		
		try {
			em.persist(domaine);
			return 1;
		}catch (Exception ex) {
			return 0 ;
		}
	}

	@Override
	public int Update(Domaine domaine) {
		try {
			em.merge(domaine);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Domaine.class, id));
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Domaine> getAll() {
		try {
			return em.createQuery("SELECT d FROM Domaine d").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Domaine get(int id) {
		return em.find(Domaine.class, id);
	}

}

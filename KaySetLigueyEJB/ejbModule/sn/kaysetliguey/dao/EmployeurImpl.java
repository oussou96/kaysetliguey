package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.Employeur;

@Stateless
public class EmployeurImpl implements IEmployeur {
	@PersistenceContext(unitName="KaySetLigueyEJB")
	private EntityManager em;
	@Override
	public int add(Employeur employeur) {
		try {
			em.persist(employeur);
			return 1;
		}catch (Exception ex) {
			return 0 ;
		}
	}

	@Override
	public int Update(Employeur employeur) {
		try {
			em.merge(employeur);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Employeur.class, id));
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Employeur> getAll() {
		try {
			return em.createQuery("SELECT emp FROM Employeur emp").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Employeur get(int id) {
		return em.find(Employeur.class, id);
	}

}

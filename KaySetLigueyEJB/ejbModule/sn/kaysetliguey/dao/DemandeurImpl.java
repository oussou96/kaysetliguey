package sn.kaysetliguey.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.Domaine;

@Stateless
public class DemandeurImpl implements IDemandeur {
	@PersistenceContext(unitName="KaySetLigueyEJB")
	private EntityManager em;
	@Override
	public int add(Demandeur demandeur) {
		try {
			em.persist(demandeur);
			return 1;
		}catch (Exception ex) {
			return 0 ;
		}
	}

	@Override
	public int Update(Demandeur demandeur) {
		try {
			em.merge(demandeur);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Demandeur.class, id));
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Demandeur> getAll() {
		try {
			return em.createQuery("SELECT dmd FROM Demandeur dmd").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Demandeur get(int id) {
		return em.find(Demandeur.class, id);
	}

}

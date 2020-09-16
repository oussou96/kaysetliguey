package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import sn.kaysetliguey.entities.User;

@Stateless
public class UserImpl implements IUser {
	@PersistenceContext(unitName="KaySetLigueyEJB")
	private EntityManager em;
	@Override
	public User getLogin(String email, String mdp) {
		try {
			return (User) em.createQuery("SELECT u FROM User u WHERE u.email=:em  AND u.mdp=:pwd")
					.setParameter("em", email)
					.setParameter("pwd", mdp)
					.getSingleResult();
					
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public int add(User user) {
		try {
			em.persist(user);
			return 1;
		}catch (Exception ex) {
			return 0 ;
		}
	}
	
	public int Update(User user) {
		try {
			em.merge(user);
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	
	public int delete(int id) {
		try {
			em.remove(em.find(User.class, id));
			return 1;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	
	public List<User> getAll() {
		try {
			return em.createQuery("SELECT u FROM User u").getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public User get(int id) {
		return em.find(User.class, id);
	}
	

}

package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Local;


import sn.kaysetliguey.entities.Employeur;

@Local
public interface IEmployeur {
	
	public int add(Employeur employeur);
	public int Update(Employeur employeur);
	public int delete(int id);
	public List<Employeur> getAll();
	public Employeur get(int id);

}

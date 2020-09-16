package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Local;

import sn.kaysetliguey.entities.Job;
import sn.kaysetliguey.entities.Domaine;

@Local

public interface IDomaine {
	public int add(Domaine domaine);
	public int Update(Domaine domaine);
	public int delete(int id);
	public List<Domaine> getAll();
	public Domaine get(int id);
}

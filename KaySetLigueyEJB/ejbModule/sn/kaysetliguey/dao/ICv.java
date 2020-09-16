package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Local;

import sn.kaysetliguey.entities.Cv;


@Local

public interface ICv {

	public int add(Cv cv);
	public int Update(Cv cv);
	public int delete(int id);
	public List<Cv> getAll();
	public Cv get(int id);
}

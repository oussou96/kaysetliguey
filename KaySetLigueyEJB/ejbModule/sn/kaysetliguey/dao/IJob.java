package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Local;

import sn.kaysetliguey.entities.Domaine;
import sn.kaysetliguey.entities.Job;

@Local
public interface IJob {
	public int add(Job job);
	public int Update(Job job);
	public int delete(int id);
	public List<Job> getAll();
	public Job get(int id);
}

package sn.kaysetliguey.dao;

import java.util.List;

import javax.ejb.Local;

import sn.kaysetliguey.entities.Demandeur;
import sn.kaysetliguey.entities.Cv;

@Local
public interface IDemandeur {

	public int add(Demandeur demandeur);
	public int Update(Demandeur demandeur);
	public int delete(int id);
	public List<Demandeur> getAll();
	public Demandeur get(int id);
}

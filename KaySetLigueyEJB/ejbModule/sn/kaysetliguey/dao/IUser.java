package sn.kaysetliguey.dao;
import java.util.List;

import javax.ejb.Local;


import sn.kaysetliguey.entities.User;

@Local
public interface IUser {

	public User getLogin(String email, String mdp);
	public int add(User user);
	public int Update(User user);
	public int delete(int id);
	public List<User> getAll();
	public User get(int id);
}

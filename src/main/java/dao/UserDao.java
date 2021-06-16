package dao;

import java.util.List;

import model.User;

public interface UserDao {
	void insert(User user) throws Exception;

	void delete(int id) throws Exception;
	
	void update(User user);
	
	User get(int id) throws Exception;
	
	List<User> listUser(String name);
	
	User getByname(String name);
}

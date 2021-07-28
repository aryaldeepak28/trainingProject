package com.training.dao;

import java.util.List;
import com.training.model.User;

public interface UserDAO {

	List<User> findAll();
	boolean addUser(User user);
	User getUserById(int i);
	User getUserByEmail(String email);
	boolean deleteUser(int i);
	boolean updateUser(User user);
	
}
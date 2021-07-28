package com.training.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dao.UserDAO;
import com.training.dao.UserDAOImpl;
import com.training.model.User;

@RestController
@RequestMapping("/api")
public class UserRestController {
	UserDAO dao= new UserDAOImpl();
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> users=dao.findAll();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") int id){
		User user=dao.getUserById(id);
		if(user!=null)
			return user;
		else
			{
			System.out.println("No Details Available");
			return null;
			}
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody Map<String, Object> payload){
		User user = new User();
		System.out.println(payload);
		user.setName((String)payload.get("name"));
		user.setEmail((String)payload.get("email"));
		user.setPhone_no((String)payload.get("phone_no"));
		user.setAddress((String)payload.get("address"));
		user.setPassword((String)payload.get("password"));
		System.out.println(user.toString());
		
		if(dao.addUser(user))
			System.out.println("User added Successfully");
		else
			System.out.println("User adding failed");
		user = dao.getUserByEmail(user.getEmail());
		return user;
	}
	
	@DeleteMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		dao.deleteUser(id);
		return ("User with ID:"+id+" is deleted succesfully");
		
	}
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		dao.updateUser(user);
		return user;
	}
	
}

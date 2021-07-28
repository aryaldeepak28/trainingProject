package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.training.model.User;
import com.training.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	Connection conn = DBUtil.getConnection();

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from users";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone=rs.getString("phone_no");
				String photo=rs.getString("upload_photo");
				Date reg_date=rs.getDate("reg_date");
				String address = rs.getString("address");
				User user = new User(id, name, password, email, address, reg_date, phone, photo);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addUser(User user) {

		String query = "insert into users(name,phone_no,email,address,password,upload_photo)"
				+ "values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone_no());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getUpload_photo());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public User getUserById(int id) {
		String sql = "select * from users where user_id=?";
		User user = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int ID = rs.getInt("user_id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone=rs.getString("phone_no");
				String photo=rs.getString("upload_photo");
				Date reg_date=rs.getDate("reg_date");
				String address = rs.getString("address");
				user = new User(ID, name, password, email, address, reg_date, phone, photo);
				
			}
			System.out.println("inside getUserByID function");
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserByEmail(String email) {
		String sql = "select * from users where email=?";
		User user = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int ID = rs.getInt("user_id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String emailId = rs.getString("email");
				String phone=rs.getString("phone_no");
				String photo=rs.getString("upload_photo");
				Date reg_date=rs.getDate("reg_date");
				String address = rs.getString("address");
				user = new User(ID, name, password, emailId, address, reg_date, phone, photo);
				
			}
			System.out.println("inside getUserByEmail function");
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteUser(int id) {
		String query = "delete from users where user_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		String query = "update users set name=? where user_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setInt(2,user.getUser_id());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
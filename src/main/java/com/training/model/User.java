package com.training.model;

import java.util.Date;

public class User {

	private int user_id;
    private String name;
    private String phone_no;
    private String email;
    private String address;
    private Date reg_date;
    private String password;
    private String upload_photo;
	
	public User() {
		super();
	}

	public User(int user_id,String name,String phone_no,String email,String address,Date reg_date,String password,String upload_photo) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.setPassword(password);
		this.setEmail(email);
		this.setAddress(address);
		this.phone_no= phone_no;
		this.upload_photo=upload_photo;
		this.setReg_date(reg_date);
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUpload_photo() {
		return upload_photo;
	}

	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getUser_id()+ "-" + this.getName() + "-" + this.getEmail() + "-" +
				this.getPassword() +"-"+ this.getPhone_no()+ " - " +
				this.getReg_date() +"-"+ this.getUpload_photo();
	}
}
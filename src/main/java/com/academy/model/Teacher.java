package com.academy.model;

public class Teacher {

	private int id;
	private String fname;
	private String lname;
	private String age;
	
	public Teacher(int id, String fname, String lname, String age) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	public Teacher(String fname, String lname, String age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}

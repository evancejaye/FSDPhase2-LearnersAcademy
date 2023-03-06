package com.academy.model;

public class Classs {
	
	private int id;
	private int section;
	private int teacher;
	private int subject;
	private String time;
	
	public Classs() {}
	
	public Classs(int id, int section, int teacher, int subject, String time) {
		super();
		this.id = id;
		this.section = section;
		this.teacher = teacher;
		this.subject = subject;
		this.time = time;
	}
	
	public Classs(int section, int teacher, int subject, String time) {
		super();
		this.section = section;
		this.teacher = teacher;
		this.subject = subject;
		this.time = time;
	}
	
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getTeacher() {
		return teacher;
	}
	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}
	public int getSubject() {
		return subject;
	}
	public void setSubject(int subject) {
		this.subject = subject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	

}
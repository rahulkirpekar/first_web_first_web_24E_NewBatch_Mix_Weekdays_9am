package com.royal.bean;

public class Student 
{
	private int id;
	private String fullname;
	private int age;
	
	public Student() 
	{
	}
	public Student(int id, String fullname, int age) 
	{
		this.id = id;
		this.fullname = fullname;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

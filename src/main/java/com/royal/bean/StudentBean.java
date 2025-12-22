package com.royal.bean;

public class StudentBean 
{
	private Integer id;
	private String fullname;
	private Integer age;
	private String  course ;
	private String  gender ;
	private String  hobbies[];
	private String  dob    ;
	private String  email  ;
	private String  mobile ;
	private String  address;

	public StudentBean() 
	{
	}
	
	public StudentBean(Integer id, String fullname, Integer age, String course, String gender, String[] hobbies,
			String dob, String email, String mobile, String address) {
		this.id = id;
		this.fullname = fullname;
		this.age = age;
		this.course = course;
		this.gender = gender;
		this.hobbies = hobbies;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isHobbySelected(String h) 
	{
		if(hobbies == null) 
		{
			return false;
		}
		for(int i = 0 ;  i < hobbies.length;i++) 
		{
			if(hobbies[i].equals(h)) 
			{
				return true;
			}
		}
		return false;
	}
}

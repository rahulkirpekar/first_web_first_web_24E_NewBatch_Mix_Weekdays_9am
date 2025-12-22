package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao 
{
	public int insertStudent(StudentBean sbean) 
	{
		String hobby[] = sbean.getHobbies();
		String hobbies = "";
		for (int i = 0; i < hobby.length; i++) 
		{
			if(i < hobby.length-1) 
			{
				hobbies = hobbies.concat(hobby[i]+",");
			}else 
			{
				hobbies = hobbies.concat(hobby[i]);
			}
		}
		System.out.println("hobbies : " + hobbies);
		
		String insertQuery = "INSERT INTO students(fullname,age,course,gender,hobbies,dob,email,mobile,address) VALUES('"+sbean.getFullname()+"',"+sbean.getAge()+",'"+sbean.getCourse()+"','"+sbean.getGender()+"','"+hobbies+"','"+sbean.getDob()+"','"+sbean.getEmail()+"','"+sbean.getMobile()+"','"+sbean.getAddress()+"')";
	
		System.out.println("insertQuery : " + insertQuery);
		
		Connection conn = DBConnection.getConnection();
		
		Statement stmt = null;
		int rowsAffected = 0;
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rowsAffected = stmt.executeUpdate(insertQuery);
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("Db not Connected : " + conn);
		}
		return rowsAffected;
	}
	public void getStudentByid(int id) 
	{

	}
	public void updateStudent(StudentBean sbean,int id) 
	{

	}
	public void deleteStudent(int id) 
	{

	}
	public ArrayList<StudentBean> getAllRecords() 
	{
		String selectQuery = "SELECT * FROM students";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		ResultSet rs = null;
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(selectQuery);
				StudentBean s  = null;
				while(rs.next()) 
				{
					int id = rs.getInt(1);
					String fullname = rs.getString(2);
					int age = rs.getInt(3);
					String course = rs.getString(4);
					String gender = rs.getString(5);
					
					String h = rs.getString(6);
					String hobbies[] = h.split(",");
					
					String dob = rs.getString(7);
					String email = rs.getString(8);
					String mobile = rs.getString(9);
					String address = rs.getString(10);
					
					s  = new StudentBean(id, fullname, age, course, gender, hobbies, dob, email, mobile, address);
					list.add(s);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not Connected : " + conn);
		}
		return list;
	}
	public static void main(String[] args) 
	{
		StudentDao dao = new StudentDao();
		
		System.out.println("dao.getAllRecords().size() : " + dao.getAllRecords().size());
		
	}
}

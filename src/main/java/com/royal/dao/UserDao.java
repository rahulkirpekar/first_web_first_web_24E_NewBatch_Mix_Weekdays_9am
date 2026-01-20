package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.royal.util.DBConnection;

public class UserDao 
{
	public boolean authenticateUser(String userName,String password) 
	{
		String selectQuery = "SELECT * from user WHERE email='"+userName+"' AND password ='"+password+"'";
		
		Connection conn = 	DBConnection.getConnection();
		Statement stmt = null;
		
		ResultSet rs = null;
		
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rs = stmt.executeQuery(selectQuery);
				
				if(rs.next()) 
				{
					return true;
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("UserDao--Db not connected");
		}
		return false;
	}
	public static void main(String[] args) 
	{
		UserDao userDao = new UserDao();
		
		boolean isAvailable = userDao.authenticateUser("rahul@gmail.com", "1b3");
		
		if (isAvailable) 
		{
			System.out.println("User Record Available : " + isAvailable);
		} else 
		{
			System.out.println("User Record not Available : " + isAvailable);
		}
	}
}

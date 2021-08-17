package com.practice.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one?useSSL=false&serverTimezone=UTC";
		String userID = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: "+jdbcURL);
			Connection myCon = DriverManager.getConnection(jdbcURL,userID,pass);
			System.out.println("Connection Successful");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

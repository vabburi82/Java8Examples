package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbCreateOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root"); 
			System.out.println("Connected Successfully........!");
			Statement stmt=con.createStatement();  
			String sql = ("CREATE TABLE student_details(ID long,Name VARCHAR(255) NOT NULL,Email varchar(255) NOT NULL)");
			stmt.executeUpdate(sql); 
			System.out.println("Table Created Successfully....!");
			con.close();  
			}catch(Exception e){ 
				System.out.println(e);
				}
	}

}

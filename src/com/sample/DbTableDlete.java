package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbTableDlete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root"); 
			System.out.println("Connected Successfully........!");
			Statement stmt=con.createStatement();  
			String sql = ("DROP TABLE mydatabase.student_details");
			stmt.executeUpdate(sql); 
			System.out.println("Table dropped Successfully....!");
			con.close();  
			}catch(Exception e){ 
				System.out.println(e);
				}
	}

}

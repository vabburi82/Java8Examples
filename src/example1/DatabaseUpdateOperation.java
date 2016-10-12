package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUpdateOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root"); 
			System.out.println("Connected Successfully........!");
			Statement stmt=con.createStatement();  
			String sql = ("UPDATE user_data SET PersonName='Ramu' where PersonName='xyz' ");
			stmt.executeUpdate(sql); 
			System.out.println("Updated Successfully....!");
			con.close();  
			}catch(Exception e){ 
				System.out.println(e);
				}
	}

}

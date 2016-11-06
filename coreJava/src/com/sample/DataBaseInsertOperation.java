package com.sample;

import java.sql.*;


public class DataBaseInsertOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root"); 
			System.out.println("Connected Successfully........!");
			Statement stmt=con.createStatement();  
			String sql = "insert into user_data(PersonName,Email,Phone,Fb_ID,Twitter_ID,ID)"+
					       "values('abc','xyz',123456,'my_name','my_twitter','10')";
			stmt.executeUpdate(sql); 
			System.out.println("Inserted Successfully....!");
			con.close();  
			}catch(Exception e){ 
				System.out.println(e);
				}
	}

}

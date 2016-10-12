package com.sample;

import java.sql.*;

public class DbRetriveOperation {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root"); 
			System.out.println("Connected Successfully........!");
		   }
		catch(Exception e)
		   { 
				System.out.println(e);
		   }
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user_data;");  
			while(rs.next()) { 
			System.out.print("Name:"+rs.getString(1)+"\t"); 
			System.out.print("Eamil:"+rs.getString(2)+"\t"); 
			System.out.print("Phone:"+rs.getInt(3)+"\t"); 
			System.out.println(" ");
			
			}
			con.close();
	}

}

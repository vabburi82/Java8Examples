package com.sample;

import java.sql.*;

public class MySqlCon { 
		public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root"); 
		System.out.println("Connected Successfully........!");
		/*Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from user_data;");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)); */
		con.close();  
		}catch(Exception e){ 
			System.out.println(e);
			}
		}
		}
	



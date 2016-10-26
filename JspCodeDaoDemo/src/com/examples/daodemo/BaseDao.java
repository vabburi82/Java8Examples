package com.examples.daodemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	String url = "jdbc:mysql://localhost:3306/empdb";
	String username = "root";
	String passwd = "root";
    public Connection openConnection() throws ClassNotFoundException, SQLException {
    	Connection con;
    	Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, passwd);
        return con;
    	 }
}

package example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionMySQL {
public static void main(String[] args)throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root","root");
    
    Statement input = (Statement) con.createStatement();
    String insert = "INSERT INTO customer(name,C_ID,address,email)"+ "VALUES ('anil',2010,'Ohio','aakumar2010@gmail.com')";
    input.executeUpdate(insert);

}

}
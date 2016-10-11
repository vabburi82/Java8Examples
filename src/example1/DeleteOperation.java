package example1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteOperation {
public static void main(String[] args)throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root","root");
    
    Statement input = (Statement) con.createStatement();
    String drop = ("drop table anil.student_data"); 
    input.executeUpdate(drop);
    System.out.println("Table Deleted");
    con.close();

}

}
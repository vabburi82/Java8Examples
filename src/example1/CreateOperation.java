package example1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateOperation {
public static void main(String[] args)throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root","root");
    
    Statement input = (Statement) con.createStatement();
    String create = ("Create table student_data (StudentName varchar(100), StudentId LONG NOT NULL)"); 
    input.executeUpdate(create);
    System.out.println("created table");
    con.close();

}

}
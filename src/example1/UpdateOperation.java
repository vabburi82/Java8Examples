package example1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateOperation {
public static void main(String[] args)throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root","root");
    
    Statement input = (Statement) con.createStatement();
    String update = ("UPDATE Persons SET FullName='AnilKumar', City='CA'  WHERE FullName='CHANDRA' ");
    input.executeUpdate(update);

}

}
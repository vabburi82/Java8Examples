package example1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PersonMySQL {
public static void main(String[] args)throws Exception{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root","root");
    
    Statement input = (Statement) con.createStatement();
    String insert = "INSERT INTO Persons(PersonID,FullName,email,phone,City,ZipCode)  VALUES (2010,'anil','a@gmail.com',123,'Ohio',123)";
    input.executeUpdate(insert);

}

}

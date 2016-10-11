package example1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateFile {
	
public static Connection getConnection() throws Exception {
    String driver = "org.gjt.mm.mysql.Driver";
    String url = "jdbc:mysql://localhost:3306/anil";
    String username = "root";
    String password = "root";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static void main(String[] args)throws Exception {
	  String UserName = null,UserEmail = null;
    //String id = "001";
    //String fileName = "C:/myfile.txt";
    
    FileInputStream fis = null;
    PreparedStatement pstmt = null;
    Connection conn = null;
    try {
      conn = getConnection();
      conn.setAutoCommit(false);
      File file = new File("C:/myfile.txt");
      fis = new FileInputStream(file);
      pstmt = conn.prepareStatement("INSERT INTO User_Details (UserName,UserEmail,UserPhone) values (?, ?, ?)");
      pstmt.setString(1, UserName);
      pstmt.setString(2, UserEmail);
      pstmt.setAsciiStream(3, fis, (int) file.length());
      pstmt.executeUpdate();
      conn.commit();
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    } finally {
      pstmt.close();
      fis.close();
      conn.close();
    }
  }
}
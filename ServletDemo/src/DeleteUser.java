

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("DeleteUser");
		Map<String,String[]> parametermap=request.getParameterMap();
		String ID = parametermap.get("ID")[0].toString();
		System.out.println(ID);
		try {
 			Connection con = null;
 			con = openConnection();
 			handleDelete(out, ID, con);
 			out.print("<br>"+"Delete success");
 			printAllUsersTable(out, con);
 
 			
 			//printEditUserdetailsLink(out,rs);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
	private void handleDelete(PrintWriter out, String ID, Connection con) throws SQLException {
		 ResultSet rs = loadUser(ID, con);
		 rs.next();
		 
		 		deleteUser(ID, con);
		 
		 		printUserDeleteStatus(out, rs.getString(2), rs.getString(3), rs.getString(4));
		 	}
 
	private int deleteUser(String ID, Connection con) throws SQLException {
 		String qry = "Delete FROM empdb.userdata where ID=?";
 		PreparedStatement ps = con.prepareStatement(qry);
 		ps.setString(1, ID);
 		int deletedRowCount = ps.executeUpdate();
 		return deletedRowCount;
 	}
 
 	private ResultSet loadUser(String ID, Connection con) throws SQLException {
 		String qry = "SELECT * FROM empdb.userdata where ID=?";
 		PreparedStatement ps = con.prepareStatement(qry);
 		ps.setString(1, ID);
 		ResultSet rs = ps.executeQuery();
 		return rs;
 	}
  	private Connection openConnection() throws ClassNotFoundException, SQLException {
 		Connection con;
 		Class.forName("com.mysql.jdbc.Driver");
 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
 		System.out.println("connection success");
 		return con;
 	}
  	private void printUserDeleteStatus(PrintWriter out, String Name, String Email, String Phone) {
 		out.append("<p align=center><b>User Deleted success: </b></p>");
 		out.append("</br> Name :" + Name);
 		out.append("&nbsp;&nbsp;&nbsp; Email: " + Email);
 		out.append("&nbsp;&nbsp;&nbsp; Phone :" + Phone);
 	}
  	private ResultSet loadAllUsers(Connection con) throws SQLException {
 		String qry = "SELECT * FROM empdb.userdata";
 		Statement stmt = con.createStatement();
 		ResultSet rs = stmt.executeQuery(qry);
 		return rs;
 	}
  	
  	private void printAllUsersTable(PrintWriter out, Connection con) throws SQLException {
 		ResultSet rs = loadAllUsers(con);
 		ResultSetMetaData rsmd = rs.getMetaData();
 		int colCount = rsmd.getColumnCount();
 
 		out.append("<p align='center'><table border=2>");
 		out.append("<tr>");
 		for (int i = 0; i < colCount; i++) {
 			out.append("<th>" + rsmd.getColumnLabel(i + 1) + "</th>");
 		}
 		out.append("</tr>");
 		while (rs.next()) {
 			out.append("<tr>");
 			String userName = rs.getString(1);
 			for (int i = 1; i <= colCount; i++) {
 				out.append("<td>" + rs.getString(i) + "</td>");
 			}
 
 			createEditbutton(out, userName);
 			createDeletebutton(out, userName);
 
 			out.append("</tr>");
 		}
 		out.print("</table></p>");
 	}
  	private void createDeletebutton(PrintWriter out, String ID) {
 		out.append(
 				"<td>" + "<form action='./DeleteUser' method=post>" + "<input type='hidden' name='userID' value='"
 						+ ID + "'/>" 
 						+ "<input type=submit value='Delete'/>" + "</form>" + "</td>");
 	}
 
 	private void createEditbutton(PrintWriter out, String ID) {
 		out.append("<td>" + "<form action='./EditUser' method=post>"
 				+ "<input type='hidden' name='ID' value='" + ID + "'/>" + "<input type=submit value='Edit' />"
 				+ "</form>" + "</td>");
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

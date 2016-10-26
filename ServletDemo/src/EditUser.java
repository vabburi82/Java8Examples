

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		    response.setContentType("text/html");
		 	PrintWriter out = response.getWriter();
		 	out.println("Edit user");
			Map<String, String[]> parameterMap = request.getParameterMap();
	 		String ID = parameterMap.get("ID")[0].toString();
	 		//out.println(ID);
	 		try {
	 			Connection con = null;
	 			con = openConnection();
	 			
	 			ResultSet rs = loadUser(ID, con);
	 			
	 			rs.next();
	 			
	 			out.append("<p align=center>Update User: </p>");
	 			out.append("</br>" );
	 			out.append("<form name='Per' action='./UpdateUser' method='post'>"
	 					+ "<table>"
	 					+ "<tbody>"
	 					+ "<tr><td>Name: </td>"
	 					+ "<td><input type='text' name='Name' value='"+ rs.getString(2)+"' />"
	 					+ "</tr><tr><td>Email: </td>"
	 					+ "<td><input type='text' name='Email' value='"+ rs.getString(3)+"' />"
	 					+ "</tr>"
	 					+ "<tr><td>Phone: </td>"
	 					+ "<td><input type='text' name='Phone' value='"+ rs.getString(4)+"' />"
	 					+ "</tr><tr><td>&nbsp;</td>"
	 					+ "<td>"
	 					+ "<input type='hidden' name='action' value='update'/>"
	 					+ "<input type='hidden'name='ID' value='"+rs.getInt(1)+"'/>"
	 					/*+ "<input type='hidden'name='name' value='"+rs.getInt(2)+"'/>"
	 					+ "<input type='hidden'name='email' value='"+rs.getInt(3)+"'/>"
	 					+ "<input type='hidden'name='phone' value='"+rs.getInt(4)+"'/>"*/
	 					+ "<input type='submit' value='update'/>"
	 					+ "</tr></tbody>"
	 					+ "</table>");
	 
	 			
	 			//printEditUserdetailsLink(out,rs);
	 			
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 	}
	 
	 
	  	private ResultSet loadUser(String ID,Connection con) throws SQLException {
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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

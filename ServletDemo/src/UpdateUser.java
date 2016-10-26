

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con = null;
		out.println("UPDATE USER");
		java.util.Map<String, String[]> parametermap= request.getParameterMap();
		//String ID=parametermap.get("ID")[0].toString();
		String ID=parametermap.get("ID")[0].toString();
		String Name=parametermap.get("Name")[0].toString();
		String Email=parametermap.get("Email")[0].toString();
		String Phone=parametermap.get("Phone")[0].toString();
		out.println(ID);
		out.println(Email);
		out.println(Phone);
		
		try {
 			
 			con = openConnection();
			//String sql="UPDATE EMPDB.USERDATA WHERE ID="+ ID +" ";
 		    //System.out.println(ID);
 			updateUser(ID,Name,Email,Phone,con);
 			out.append("<br>"+" update success");
 			String qry = "SELECT * FROM empdb.userdata";
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(qry);
            out.append("<P ALIGN='center'><TABLE BORDER=1>");
        	 ResultSetMetaData rsmd = rs.getMetaData();
        	 int columnCount = rsmd.getColumnCount();
        	 // table header
        	 out.println("<TR>");
        	 for (int i = 1; i <=columnCount; i++) {
        	   out.append("<TH>" + rsmd.getColumnLabel(i));
        	   }
        	   out.println("<td align='center'><b>Edit/Delete</b></td></TH>");
        	
        	 out.println("</TR>");
        	 // the data
        	 while (rs.next()) {
        	  out.println("<TR>");
        	  for (int i = 1; i <=columnCount; i++) {
        	    out.println("<TD>" + rs.getString(i) + "</TD>");
        	    }
        	  out.append("<td>");
        	  out.print("<form name='edit' method='get' action='./EditUser'>"
        			  		    +"<input type='hidden' name='ID' value='"+ rs.getInt(1) +"'>"
        			  		    +"<input type='submit' value='Edit'>"
        			  		    +"</form>");
        	  out.print("<form name='delete' method='get' action='./DeleteUser'>"
        			  		    +"<input type='hidden' name='ID' value='"+ rs.getInt(1) +"'>"
        			  		    +"<input type='submit' value='Delete'>"
        			  		    +"</form>");
        	  out.println("</td>");
        	  out.println("</TR>");
        	  }
        	 out.println("</TABLE></P>");
        	 con.close();
 			
 		} 
		catch (Exception e) {
 			e.printStackTrace();
 		}
	}
	private void updateUser(String ID, String name,String email,String phone,Connection con)
 			throws SQLException {
 		PreparedStatement ps;
 		String sql = "update empdb.userdata set name = ?, email = ?, phone = ? where ID ="+ ID +" ";
 		ps = con.prepareStatement(sql);
 		ps.setString(1, name);
 		ps.setString(2, email);
 		ps.setString(3, phone);
 		ps.executeUpdate();
 		System.out.println("user update!!!!!!!!!");
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

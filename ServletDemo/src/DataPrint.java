

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class DataPrint
 */
@WebServlet("/DataPrint")
public class DataPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataPrint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/empdb";
		String username="root";
		String passwd="root";
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection(url,username,passwd);
        	out.println("Connected Successfully........!");
        	
        	String qry = "SELECT * FROM empdb.userdata";
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(qry);
            out.println("<P ALIGN='center'><TABLE BORDER=1>");
        	 ResultSetMetaData rsmd = rs.getMetaData();
        	 int columnCount = rsmd.getColumnCount();
        	 // table header
        	 out.println("<TR>");
        	 for (int i = 1; i <=columnCount; i++) {
        	   out.println("<TH>" + rsmd.getColumnLabel(i));
        	   }
        	   out.println("<td align='center'><b>Edit/Delete</b></td></TH>");
        	
        	 out.println("</TR>");
        	 // the data
        	 while (rs.next()) {
        	  out.println("<TR>");
        	  for (int i = 1; i <=columnCount; i++) {
        	    out.println("<TD>" + rs.getString(i) + "</TD>");
        	    }
        	  out.println("<td>");
        	  out.println("<form name='edit' method='get' action='./EditUser'>"
        			  		    +"<input type='hidden' name='ID' value='"+ rs.getInt(1) +"'>"
        			  		    +"<input type='submit' value='Edit'>"
        			  		    +"</form>");
        	  out.println("<form name='delete' method='get' action='./DeleteUser'>"
        			  		    +"<input type='hidden' name='ID' value='"+ rs.getInt(1) +"'>"
        			  		    +"<input type='submit' value='Delete'>"
        			  		    +"</form>");
        	  out.println("</td>");
        	  out.println("</TR>");
        	  }
        	 out.println("</TABLE></P>");
        	 con.close();
        }
        catch(SQLException | ClassNotFoundException e){
        	e.printStackTrace();
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

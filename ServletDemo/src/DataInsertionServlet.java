import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataInsertionServlet
 */
@WebServlet("/DataInsertionServlet")
public class DataInsertionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataInsertionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;
		String email;
		String phone;
		String url="jdbc:mysql://localhost:3306/empdb";
		String username="root";
		String passwd="root";
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Map<String, String[]> parametermap=request.getParameterMap();
		name=parametermap.get("name")[0].toString();
		email=parametermap.get("email")[0].toString();
		phone=parametermap.get("phone")[0].toString();
		/*name=request.getParameter("name");
		email=request.getParameter("email");
		phone=request.getParameter("phone");*/
		out.println("<p>Name:"+name+"</p>");
		out.println("<p>Email:"+email+"</p>");
		out.println("<p>Phone:"+phone+"</p>");
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection(url,username,passwd);
        	//out.println("Connected Successfully........!"+"<br>");
        	String qry = "insert into userdata(name,email,phone)values(?,?,?)";
        	java.sql.PreparedStatement ps=con.prepareStatement(qry);
        	ps.setString(1, name);
        	ps.setString(2, email);
        	ps.setString(3, phone);
        	int count=ps.executeUpdate();
        	if(count>0){
        		out.println("<p ALIGN='center'><marquee><i>Thank you for registering with us...!</i></marquee></p>");
        	}
        	else
        	{
        		out.println("<b>Try again...</b>");
        	}
        	
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

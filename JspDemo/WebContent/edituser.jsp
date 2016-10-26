<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit jsp</title>
</head>
<body background="./wallpaper.jpg">
<h3>Edit Your details</h3>
<% 
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
	 			out.append("<form name='Per' action='./updateuser.jsp' method='post'>"
	 					+ "<table>"
	 					+ "<tbody>"
	 					+ "<tr><td>Name: </td>"
	 					+ "<td><input type='text' name='name' value='"+ rs.getString(2)+"' />"
	 					+ "</tr><tr><td>Email: </td>"
	 					+ "<td><input type='text' name='email' value='"+ rs.getString(3)+"' />"
	 					+ "</tr>"
	 					+ "<tr><td>Phone: </td>"
	 					+ "<td><input type='text' name='phone' value='"+ rs.getString(4)+"' />"
	 					+ "</tr><tr><td>&nbsp;</td>"
	 					+ "<td>"
	 					+ "<input type='hidden' name='action' value='update'/>"
	 					+ "<input type='hidden'name='ID' value='"+rs.getInt(1)+"'/>"
	 					+ "<input type='submit' value='update'/>"
	 					+ "</tr></tbody>"
	 					+ "</table>");
	 
	 			
	 			//printEditUserdetailsLink(out,rs);
	 			
	 		}
	 		catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		%>
	 <%!
	  	private ResultSet loadUser(String ID,Connection con) throws SQLException {
	 	String qry = "SELECT * FROM empdb.jspdata where ID=?";
	 	PreparedStatement ps = con.prepareStatement(qry);
	 	ps.setString(1, ID);
	 	ResultSet rs = ps.executeQuery();
	 	return rs; 
	      } %>
	  	<%! 
	  	private Connection openConnection() throws ClassNotFoundException, SQLException {
	 		Connection con;
	 		Class.forName("com.mysql.jdbc.Driver");
	 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
	 		System.out.println("connection success");
	 		return con;
	 	} %>

</body>
</html>
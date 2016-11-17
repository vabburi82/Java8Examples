<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@page import="java.lang.Object"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete jsp</title>
</head>
<body background="./wallpaper.jpg">
<%
Map<String,String[]> parametermap=request.getParameterMap();
		String ID = parametermap.get("ID")[0].toString();
		System.out.println(ID);
		%>
		<%
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
 	%>
 	<%! 
	private void handleDelete(JspWriter out, String ID, Connection con) throws SQLException, IOException {
		 ResultSet rs = loadUser(ID, con);
		 rs.next();
		 
		 		deleteUser(ID, con);
		 
		 		printUserDeleteStatus(out, rs.getString(2), rs.getString(3), rs.getString(4));
		 	}
 	%>
 	<%!
	private int deleteUser(String ID, Connection con) throws SQLException {
 		String qry = "Delete FROM empdb.jspdata where ID=?";
 		PreparedStatement ps = con.prepareStatement(qry);
 		ps.setString(1, ID);
 		int deletedRowCount = ps.executeUpdate();
 		return deletedRowCount;
 	}
 	%>
 	<%!
 	private ResultSet loadUser(String ID, Connection con) throws SQLException {
 		String qry = "SELECT * FROM empdb.jspdata where ID=?";
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
 	
  	private void printUserDeleteStatus(JspWriter out, String Name, String Email, String Phone) throws IOException{
 		out.append("<p align=center><b>User Deleted success: </b></p>");
 		out.append("</br> Name :" + Name);
 		out.append("&nbsp;&nbsp;&nbsp; Email: " + Email);
 		out.append("&nbsp;&nbsp;&nbsp; Phone :" + Phone);
 	}
 	
  	private ResultSet loadAllUsers(Connection con) throws SQLException {
 		String qry = "SELECT * FROM empdb.jspdata";
 		Statement stmt = con.createStatement();
 		ResultSet rs = stmt.executeQuery(qry);
 		return rs;
 	}
 	
 	 	
  	private void printAllUsersTable(JspWriter out, Connection con) throws SQLException,IOException {
 		ResultSet rs = loadAllUsers(con);
 		ResultSetMetaData rsmd = rs.getMetaData();
 		int colCount = rsmd.getColumnCount();
 
 		out.append("<p align='center'><table align='center' border=2>");
 		out.append("<tr>");
 		for (int i = 1; i <= colCount; i++) {
 			out.append("<th>" + rsmd.getColumnLabel(i) + "</th>");
 		}
 		out.append("<th>"+"edit"+"</th>");
 		out.append("<th>"+"delete"+"</th>");
 		out.append("</tr>");
 		while (rs.next()) {
 			out.append("<tr>");
 			String id = rs.getString(1);
 			for (int i = 1; i <= colCount; i++) {
 				out.append("<td>" + rs.getString(i) + "</td>");
 			}
 
 			createEditbutton(out, id);
 			
 			createDeletebutton(out, id);
 
 			out.append("</tr>");
 		}
 		out.print("</table></p>");
 	}
 
  	private void createDeletebutton(JspWriter out, String ID) throws IOException{
 		out.println(
 				"<td>" + "<form action='./deleteuser.jsp' method=post>" + "<input type='hidden' name='ID' value='"
 						+ ID + "'/>" 
 						+ "<input type=submit value='Delete'/>" + "</form>" + "</td>");
 	}
 	
 	
 	private void createEditbutton(JspWriter out, String ID) throws IOException{
 		out.println("<td>" + "<form action='./edituser.jsp' method=post>"
 				+ "<input type='hidden' name='ID' value='" + ID + "'/>" + "<input type=submit value='Edit' />"
 				+ "</form>" + "</td>");
 	}
 	%>
</body>
</html>
<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dataprintjsp</title>
</head>
<body background="./wallpaper.jpg">
<p align="center">
<a align='center' href="./customerform.jsp">Add new Customer</a></p>
	<h3 style="color: blue;">
		<p align='center'>Customer list</p>
	</h3>
	<%
String url="jdbc:mysql://localhost:3306/empdb";
String username="root";
String passwd="root";%>
	<%
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection(url,username,passwd);
        	//out.println("Connected Successfully........!"+"<br>");
        	String qry = "SELECT * FROM empdb.jspdata";
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(qry);
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	%>
	<table align='center' border=1>
		<tr>
			<%
				for (int i = 1; i <= columnCount; i++) {
			%>
			<th><%=rsmd.getColumnLabel(i)%></th>
			<%
				}
			%>
			<th>edit/delete</th>
		</tr>
		<!-- the data -->
		<%
			while (rs.next()) {
		%>
		<tr>
			<%
				for (int i = 1; i <= columnCount; i++) {
			%>
			<td><%=rs.getString(i)%></td>
			<%
				}
			%>
			<td style='white-space: nowrap;'><nobr>
					<table >
						<tr>
							<td>
								<form name='edit' method='get' action='./edituser.jsp'>
									<input type='hidden' name='ID' value='<%=rs.getInt(1)%>' /> <input
										type='submit' value='Edit' />
								</form>
							</td>
							<td>
								<form name='delete' method='get' action='./deleteuser.jsp'>
									<input type='hidden' name='ID' value='<%=rs.getInt(1)%>' /> <input
										type='submit' value='Delete' />
								</form>
							</td>
						</tr>
					</table>
				</nobr></td>
		</tr>
		<%
			}
		%>
	</table>

	<%
		con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	
</body>
</html>
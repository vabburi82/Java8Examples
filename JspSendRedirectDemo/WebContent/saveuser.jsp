<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>database jsp</title>
</head>
<body background="./wallpaper.jpg">
	<h3 align="center"
		style="color: purple; background-color: buttonshadow;">Your
		details</h3>
	<%
		Map<String, String[]> parametermap = request.getParameterMap();
		String id = parametermap.get("id")[0].toString();
		String name = parametermap.get("name")[0].toString();
		String email = parametermap.get("email")[0].toString();
		String phone = parametermap.get("phone")[0].toString();
	%>
	<table align='center' border="1" bordercolor="blue">
		<tr>
			<td><b>ID</b></td>
			<td><%=id%><br></td>
		</tr>
		<tr>
			<td><b>Name</b></td>
			<td><%=name%><br></td>
		</tr>
		<tr>
			<td><b>Email</b></td>
			<td><%=email%><br></td>
		</tr>
		<tr>
			<td><b>Phone</b></td>
			<td><%=phone%><br></td>
		</tr>
	</table>

	<%
		String url = "jdbc:mysql://localhost:3306/empdb";
		String username = "root";
		String passwd = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, passwd);
			String qry = "insert into jspdata(id,name,email,phone)values(?,?,?,?)";
			java.sql.PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, phone);
			int count = ps.executeUpdate();
			if (count > 0) {
	%>
	<p align='center' style='color: white; background-color: grey;'>
		<i><marquee behavior='alternate'>Thank you for
				registering...!</marquee></i>
		<%
			} else {
		%>
		<b>Try again...</b>
		<%
			}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			}
		%>
	<p align='center'>
	    <form method="get" action="./dataprint.jsp">
              <input type="hidden" name='id' value='<%=id %>' />
              <input type="hidden" name='name' value='<%=name %>' />
              <input type="hidden" name='email' value='<%=email%>' />
              <input type="hidden" name='phone' value='<%=phone%>' />
              <input type="submit" name='submit' value='<jsp:forward page="dataprint.jsp"></jsp:forward>' />
        </form>
	</p>
</body>
</html>
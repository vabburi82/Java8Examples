<%@page import="com.examples.daodemo.Customer"%>
<%@page import="com.examples.daodemo.UserDao"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listjsp</title>
</head>
<body background="./wallpaper.jpg">
	<p align="center">
		<a href="./customerform.jsp">Add new Customer</a>
	</p>
	<h3 style="color: blue;">
		<p align='center'>Customer list</p>
	</h3>
  <table align="center" border="1">
   <%
		Customer savedUser = (Customer) request.getAttribute("savedUser");
		if (null != savedUser) {
	%>
	
	<tr>
		<td>id</td>
		<td>name</td>
		<td>email</td>
		<td>phone</td>
		</tr>
		<tr>
			<td><%=savedUser.getId()%></td>
		<td><%=savedUser.getName()%></td>
		<td><%=savedUser.getEmail()%></td>
		<td><%=savedUser.getPhone()%></td>
		</tr>
         
		<%
			}
		%>
	      <tr>
			<td><b>ID</b></td>
			<td><b>NAME</b></td>
			<td><b>EMAIL</b></td>
			<td><b>PHONE</b></td>
			<td style="color: blue;"><b>EDIT/DELETE</b></td>
			<%
				UserDao userDao = new UserDao();
				userDao.openConnection();
				List<Customer> allUsers = userDao.listAllUsers();
				for (Customer user : allUsers) {
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getPhone()%></td>
				<td style='white-space: nowrap;'><nobr>
						<table>
							<tr>
								<td>
									<form name='edit' method='get' action='./edituser.jsp'>
										<input type='hidden' name='id' value='<%=user.getId()%>' /> <input
											type='submit' value='Edit' />
									</form>
								</td>
								<td bgcolor='red'>
									<form name='delete' method='get' action='./deleteuser.jsp'>
										<input type='hidden' name='id' value='<%=user.getId()%>' /> <input
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
	</table>

</body>
</html>
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
		Map<String, String[]> parametermap = request.getParameterMap();
		//String ID=parametermap.get("ID")[0].toString();
		String ID = parametermap.get("ID")[0].toString();
		String Name = parametermap.get("name")[0].toString();
		String Email = parametermap.get("email")[0].toString();
		String Phone = parametermap.get("phone")[0].toString();
		out.println(ID);
		out.println(Name);
		out.println(Email);
		out.println(Phone);

		try {
			Connection con = null;
			con = openConnection();
			updateUser(ID, Name, Email, Phone, con);
			out.append("<br>" + " update success");
			String qry = "SELECT * FROM empdb.jspdata";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			// table header
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
			<th>Edit/Delete</th>
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

	<%!private void updateUser(String ID, String Name, String Email, String Phone, Connection con) throws SQLException {
		PreparedStatement ps;
		String sql = "update empdb.jspdata set name = ?, email = ?, phone = ? where ID =" + ID + " ";
		ps = con.prepareStatement(sql);
		ps.setString(1, Name);
		ps.setString(2, Email);
		ps.setString(3, Phone);
		ps.executeUpdate();
		System.out.println("user update!!!!!!!!!");
	}

	private Connection openConnection() throws ClassNotFoundException, SQLException {
		Connection con;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		System.out.println("connection success");
		return con;
	}%>
</body>
</html>
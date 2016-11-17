<%@page import="com.examples.daodemo.UserDao"%>
<%@page import="com.examples.daodemo.Customer"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update page</title>
</head>
<body background="./wallpaper.jpg">
	<%
		Map<String, String[]> parametermap = request.getParameterMap();
		String id = parametermap.get("id")[0].toString();
		String name = parametermap.get("name")[0].toString();
		String email = parametermap.get("email")[0].toString();
		String phone = (String)parametermap.get("phone")[0].toString();
		System.out.println(id);
		out.println(name);
		out.println(email);
		out.println(phone);

		try {
			
			UserDao userDao=new UserDao();
			Customer count=userDao.updateUser(id, name, email, phone);
		    } 
		catch (Exception e) {
			e.printStackTrace();
		    }
	%>
	<jsp:forward page="./dataprint.jsp"></jsp:forward>
</body>
</html>
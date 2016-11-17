<%@page import="com.examples.daodemo.UserDao"%>
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
<p align="center">
<a href="./customerform.jsp">Add new Customer</a></p>
<%
Map<String,String[]> parametermap=request.getParameterMap();
		String id = parametermap.get("id")[0].toString();
		System.out.println(id);
		try {
			 UserDao userDao=new UserDao();
			 int count=userDao.deleteUser(id);
 			} 
		     catch (Exception e) {
 			e.printStackTrace();
 		}
 	%>
 <jsp:forward page="./dataprint.jsp"></jsp:forward>
</body>
</html>
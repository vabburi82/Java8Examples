<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>print jsp</title>
</head>
<body background="./wallpaper.jpg">
<h3>Your details</h3>
<%
Map<String,String[]> parametermap=request.getParameterMap();
String name=parametermap.get("name")[0].toString();
String email=parametermap.get("email")[0].toString();
String phone=parametermap.get("phone")[0].toString();
%>
<b>Name:</b> <%=name%><br>
<b>Email:</b> <%=email%><br>
<b>Phone:</b> <%=phone%><br>
</body>
</html>
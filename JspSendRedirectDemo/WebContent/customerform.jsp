<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer jsp</title>
</head>
<body background="./wallpaper.jpg">
<h3>Register</h3>
<form name='form' method='get' action="./saveuser.jsp">
<table align='center' padding: 5px;">
<tbody>
<tr>
<td>ID :</td>
<td><input type="text" name="id" />
</tr>
<tr>
<td>Name :</td>
<td><input type="text" name="name" placeholder="Enter your name" />
</tr>
<tr>
<td>Email :</td>
<td><input type="text" name="email" placeholder="Enter your email" />
<tr>
<tr>
<td>Phone :</td>
<td><input type="text" name="phone" placeholder="Enter your phone" />
</tr>
<tr>
<td>&nbsp;</td>
<td><input type="submit" value="Submit" />
</tr>
</tbody>
</table>

</form>
</body>
</html>
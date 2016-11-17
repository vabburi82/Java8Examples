<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index page</title>
</head>
<body>
<div align="center">
<h1>Hello World From Struts2</h1>
	<s:form action="save" method="post">
	<s:textfield name="customer.name" key="name" />
	<s:textfield name="customer.email" key="email" />
	<s:textfield name="customer.phone" key="phone" />
	<s:submit key="label.add.customer" align="center" />
	</s:form>
	</div>
</body>
</html>
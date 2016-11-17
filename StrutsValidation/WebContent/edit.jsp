<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit</title>
<s:head/>
</head>
<body>
	<div align="center">
		<h3>edit user</h3>
		<s:form namespace="/" method="post">
			<s:textfield name="customer.name" label="Name" />
			<s:textfield name="customer.email" label="Email" />
			<s:textfield name="customer.phone" label="Phone" />
			<s:hidden name="oldName" value="%{customer.name}" />
			<s:submit style="background-color:orange;" action="updateCustomer" align="center" key="label.update.customer" />

		</s:form>
	</div>
</body>
</html>
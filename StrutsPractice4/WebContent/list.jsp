<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list</title>
</head>
<body> <p align="center">
<a href="./index.jsp">Add new customer</a></p>
	<h3 align="center" style="color: blue;">Customer list</h3>

	<table align="center" border='1' bordercolor="blue">
		<tr>
			<td>NAME</td>
			<td>EMAIL</td>
			<td>PHONE</td>
			<td>EDIT/DELETE</td>
		</tr>
		<s:iterator value="custlist">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="phone" /></td>
				<td nowrap="nowrap">
						<table>
							<tr>
								<td>
								<s:form namespace="/">
								<s:hidden value="%{name}" name="customer.name"></s:hidden>
								<s:hidden value="%{email}" name="customer.email"></s:hidden>
								<s:hidden value="%{phone}" name="customer.phone"></s:hidden>
								<s:submit  style="background-color:green;"  action="editCustomer" value="Edit Cutomer"></s:submit>
								</s:form>
								</td>
							</tr>
							<tr>
								<td>
								<s:form namespace="/">
								<s:hidden value="%{name}" name="customer.name"></s:hidden>
								<s:submit style="background-color:red;" action="deleteCustomer" value="Delete Cutomer"></s:submit>
								</s:form>
								</td>
							</tr>
							
						</table>
					</td>
			</tr>

		</s:iterator>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PHBook || View Contact</title>
</head>
<body>
<%@ include file="navmenu.jsp" %>
<br>
<h3 align="center">List Off All contact</h3>
<table class= "table table-dark table-hover">
<thead>
	<tr>
		<th>Name</th>
		<th>Contact</th>
		<th>DOB</th>
		<th>Edit/Delete</th>
	</tr>
</thead>
<tbody>
 <c:forEach var="contact" items="${requestScope.contactList}">
	<tr>
		<td>${contact.name}</td>
		<td>${contact.contact}</td>
		<td>${contact.dob}</td>
		<td>
			<a href="edit-contact?id=${contact.id}">Edit</a> /
			<a href="#?id=${contact.id}">Delete</a>
		</td>
	</tr>
	</c:forEach>


</tbody>
</table>
</body>
</html>
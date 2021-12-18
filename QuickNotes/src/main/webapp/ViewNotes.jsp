<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your || Notes</title>
</head>
<body>
<%@ include file="bootstrap.jsp" %>
<div align="right">
	<c:forEach var="details" items="${requestScope.user}">
		<ul>
			<li>User : ${details.name}</li>
		</ul>
	</c:forEach>
	<a href="home.jsp?code=121">Logout</a>
</div>
<br>
<form action="save-notes">
<c:forEach var="details" items="${requestScope.user}">
		<input type="hidden" name="id" value="${details.id}">
	</c:forEach>
	Note Title : <input type="text" name="title"><br>
	<br>
	Note Discription : <input type="text" name="dis"><br><br>
	<button type="submit">Save</button><br>
</form>
<hr>
<table class= "table table-dark table-hover">
<thead>
	<tr>
		<th>Title</th>
		<th>Discription</th>
		<th>Edit / Delete</th>
	</tr>
</thead>
<tbody>
 <c:forEach var="contact" items="${requestScope.contactList}">
	<tr>
		<td>${contact.tital}</td>
		<td>${contact.dis}</td>
		<td>
					<a href="edit-contact?id=${contact.sr}">Edit</a> /
					<a href="delete-contact?id=${contact.sr}">Delete</a>
				</td>
	</tr>
	</c:forEach>


</tbody>
</table>
</body>
</html>
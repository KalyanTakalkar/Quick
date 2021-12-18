<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PHBook || Edit Contact</title>
</head>
<body>
<%@ include file="navmenu.jsp" %>
<div align="center"></div>
<h3> Edit Contact Details</h3>
<form action="update-contact-details" method="get">
	<input type="hidden"> name="id" value=${requestScope.contact.id}> 
	Name : <input type="text"> name="name" value=${requestScope.contact.name}> <br></br>
	Contact : <input type="text"> name="contact" value=${requestScope.contact.contact}>
	DOB : <input type="date"> name="dob" value=${requestScope.contact.dob}> <br></br>
	
 <button type= "Submit"> Update Contact</button>
 </form>
</body>
</html>
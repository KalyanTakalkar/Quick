<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PHBook || NewContact</title>
</head>
<body>
<%@ include file="navmenu.jsp" %>
<div align="center">
	<c:choose>
		<c:when test="${requestScope.result eq 'true' }">
			<div class="alert alert-success">
			Contact Created Successfully
			
			</div>
		</c:when>
		<c:when test="${requestScope.result eq 'false' }">
			<div class="alert alert-danger">
			Contact Created UnSuccessfully
			
			</div>
		</c:when>
	</c:choose>

<h3>Add New Contact Details</h3><br>
 <form action="create-new-contact" method="get">
 Enter Name : <input type="text" name ="name"> <br></br> 
 Enter contact : <input type="text" name ="contact"> <br></br> 
 Enter dob : <input type="text" name ="dob"> <br></br> 
 <button type= "Submit"> Create Contact</button>
 </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Books</title>

  <link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
    <div class="container"> 
    <h1>All My Books</h1>
    
    <table>
    	<tbody>
    		<tr>
    			<th>Title:</th>
    			<th>Description:</th>
    			<th>Language:</th>
    			<th># of Pages:</th>
    			<th>Actions</th>
  
    		</tr>
    		<c:forEach var= "i" items= "${book}">
    		<tr>
    			<td> <a href="/books/${i.id}"> ${i.title}</a></td>
    			<td><i><c:out value="${i.description}"></c:out></i></td>
    			<td> <c:out value="${i.language}"></c:out></td>
    			<td> <c:out value="${i.numberOfPages}"></c:out></td>
    			<td><a href="/books/${i.id}/edit">Edit</a></td>
    			<td><a href="/books/${i.id}">View</a></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
   
       <button><a href="/books/new">Add a New Book</a></button>
    </div> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
  <h1>Student Confirmation</h1>
  <div>The student is confirmed: ${student.firstName} ${student.lastName}</div>
  <div>Country: ${student.country}</div>
  <div>Favorite Language: ${student.favoriteLanguage}</div>
  <div>
    <p>Operating System:</p>
    <ul>
      <c:forEach var="os" items="${student.operatingSystems}">
        <li>${os}</li>
      </c:forEach>
    </ul>
  </div>
</body>
</html>

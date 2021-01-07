<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Home Page</title>
</head>
<body>
  <h1>Demo Home Page</h1>
  <hr />
  <h2>Welcome to Demo Corporation Web Application</h2>
  <div>
    <a href="<c:url value='/logout' />">Log Out</a>
  </div>
</body>
</html>

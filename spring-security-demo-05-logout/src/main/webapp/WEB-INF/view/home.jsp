<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
      <input type="submit" value="Log Out" />
    </form:form>
  </div>
</body>
</html>

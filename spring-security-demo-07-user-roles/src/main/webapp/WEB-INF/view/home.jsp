<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Home Page</title>
</head>
<body>
  <h2>Demo Home Page</h2>
  <hr />
  <p>Welcome to Demo Corporation Web Application</p>
  <hr />
  <p>
    User: <security:authentication property="principal.username"/>
  </p>
  <p>
    Roles(s): <security:authentication property="principal.authorities"/>
  </p>
  <div>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
      <input type="submit" value="Log Out" />
    </form:form>
  </div>
</body>
</html>

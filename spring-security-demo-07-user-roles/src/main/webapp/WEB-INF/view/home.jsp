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
  <security:authorize access="hasRole('MANAGER')">
    <hr />
    <p>
      <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Manager peeps)
    </p>
  </security:authorize>
  <security:authorize access="hasRole('ADMIN')">
    <hr />
    <p>
      <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for Admin peeps)
    </p>
  </security:authorize>
  <hr />
  <div>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
      <input type="submit" value="Log Out" />
    </form:form>
  </div>
</body>
</html>

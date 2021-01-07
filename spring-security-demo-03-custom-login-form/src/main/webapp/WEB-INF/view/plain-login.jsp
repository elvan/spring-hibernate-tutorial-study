<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>
<style>
.failed {
  color: red;
}
</style>
</head>
<body>
  <h3>Custom Login Page</h3>
  <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
    method="post">
    <c:if test="${param.error != null}">
      <em class="failed">Sorry. You entered invalid username/password</em>
    </c:if>
    <p>
      Username: <input type="text" name="username">
    </p>
    <p>
      Password: <input type="password" name="password">
    </p>
    <p>
      <input type="submit" value="Login" />
    </p>
  </form:form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring REST Demo</title>
</head>
<body>
  <h1>Spring REST Demo</h1>
  <hr />
  <p>
    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>
  </p>
  <p>
    <a href="${pageContext.request.contextPath}/api/students">Students</a>
  </p>

</body>
</html>

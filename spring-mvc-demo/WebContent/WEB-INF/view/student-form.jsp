<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
  <h1>Student Form</h1>
  <form:form action="processForm" modelAttribute="student">
    <p>
      <label>First Name:</label>
      <form:input path="firstName" />
    </p>
    <p>
      <label>Last Name:</label>
      <form:input path="lastName" />
    </p>
    <p>
      <label>Country:</label>
      <form:select path="country">
        <form:options items="${student.countryOptions}" />
      </form:select>
    </p>
    <p>
      <input type="submit" value="Submit" />
    </p>
  </form:form>
</body>
</html>

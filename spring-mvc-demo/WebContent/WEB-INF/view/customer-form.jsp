<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<style type="text/css">
.error {
  color: red;
}
</style>
</head>
<body>
  <h1>Customer Form</h1>
  <div>
    <p>
      <em>Fill out the form. Asterisk (*) means required</em>
    </p>
    <form:form action="processForm" modelAttribute="customer">
      <p>
        <label>First name:</label>
        <form:input path="firstName" />
      </p>
      <p>
        <label>Last name (*):</label>
        <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
      </p>
      <p>
        <label>Free passes:</label>
        <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error" />
      <p>
      <p>
        <label>Postal Code:</label>
        <form:input path="postalCode" />
        <form:errors path="postalCode" cssClass="error" />
      </p>
      <p>
        <label>Course Code:</label>
        <form:input path="courseCode" value="TOP" />
        <form:errors path="courseCode" cssClass="error" />
      </p>
      <p>
        <input type="submit" value="Submit" />
      </p>
    </form:form>
  </div>
</body>
</html>

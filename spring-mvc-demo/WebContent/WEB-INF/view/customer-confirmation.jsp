<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
  <h1>Customer Confirmation</h1>
  <p>The customer is confirmed: ${customer.firstName} ${customer.lastName}</p>
  <p>Free passes: ${customer.freePasses}</p>
  <p>Postal Code: ${customer.postalCode}</p>
  <p>Course Code: ${customer.courseCode}</p>
</body>
</html>

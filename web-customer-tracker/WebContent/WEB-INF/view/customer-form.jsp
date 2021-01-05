<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
<link rel="stylesheet" type="text/css"
  href="<c:url value='/resources/css/style.css' />">
<link rel="stylesheet" type="text/css"
  href="<c:url value='/resources/css/add-customer-style.css' />">
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>CRM - Customer Relationship Manager</h2>
    </div>
    <div id="container">
      <h3>Save Customer</h3>
      <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />
        <table>
          <tbody>
            <tr>
              <td><label>First Name:</label>
              <td><form:input path="firstName" /></td>
            </tr>
            <tr>
              <td><label>Last Name:</label>
              <td><form:input path="lastName" /></td>
            </tr>
            <tr>
              <td><label>Email:</label>
              <td><form:input path="email" type="email" /></td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" value="Submit" class="save" /></td>
            </tr>
          </tbody>
        </table>
      </form:form>
      <div>
        <a href="<c:url value='/customer/list' />">Back to List</a>
      </div>
    </div>
  </div>

</body>
</html>

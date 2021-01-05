<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link rel="stylesheet" type="text/css"
  href="<c:url value='/resources/css/style.css' />">
</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>CRM - Customer Relationship Manager</h2>
    </div>
  </div>
  <div id="container">
    <div id="content">
      <input type="button" value="Add Customer" class="add-button"
        onclick="window.location.href='showFormForAdd'; return false;" />
      <table>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Action</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
          <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${customer.id}" />
          </c:url>
          <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td><a href="${updateLink}">Update</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>
</html>

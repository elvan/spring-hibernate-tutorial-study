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
    <div>
      <label>First Name:</label>
      <form:input path="firstName" />
    </div>
    <div>
      <label>Last Name:</label>
      <form:input path="lastName" />
    </div>
    <div>
      <label>Country:</label>
      <form:select path="country">
        <form:options items="${student.countryOptions}" />
      </form:select>
    </div>
    <div>
      <label>Favorite Language:</label>
      <div>
        <form:radiobutton path="favoriteLanguage" value="Java" id="java" />
        <label for="java">Java</label>
      </div>
      <div>
        <form:radiobutton path="favoriteLanguage" value="TypeScript"
          id="typescript" />
        <label for="typescript">TypeScript</label>
      </div>
      <div>
        <form:radiobutton path="favoriteLanguage" value="JavaScript"
          id="javascript" />
        <label for="javascript">JavaScript</label>
      </div>
      <div>
        <form:radiobutton path="favoriteLanguage" value="C#" id="csharp" />
        <label for="csharp">C#</label>
      </div>
    </div>
    <div>
      <input type="submit" value="Submit" />
    </div>
  </form:form>
</body>
</html>

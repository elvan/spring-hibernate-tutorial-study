<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Reference Bootstrap files -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
  integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
  crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
  integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ"
  crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
  src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
  integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
  crossorigin="anonymous"></script>
<style>
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 480px;
  padding: 15px;
  margin: 0 auto;
}
</style>
</head>
<body>
  <div class="container">
    <div id="loginbox" style="margin-top: 50px;" class="form-signin">
      <div class="panel panel-info">
        <div class="panel-heading">
          <div class="panel-title">Sign In</div>
        </div>
        <div style="padding-top: 30px" class="panel-body">
          <!-- Login Form -->
          <form:form
            action="${pageContext.request.contextPath}/authenticateTheUser"
            method="POST" class="form-horizontal">
            <!-- Place for messages: error, alert etc ... -->
            <div class="form-group">
              <div class="col-xs-15">
                <div>
                  <c:if test="${param.error != null}">
                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                      Invalid username and password.
                    </div>
                  </c:if>
                  <c:if test="${param.logout != null}">
                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                      You have been logged out.
                    </div>
                  </c:if>
                </div>
              </div>
            </div>
            <!-- User name -->
            <div style="margin-bottom: 25px" class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
              <input type="text" name="username" placeholder="username" class="form-control">
            </div>
            <!-- Password -->
            <div style="margin-bottom: 25px" class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" name="password" placeholder="password" class="form-control">
            </div>
            <!-- Login/Submit Button -->
            <div style="margin-top: 10px" class="form-group">
              <div class="col-sm-6 controls">
                <button type="submit" class="btn btn-success">Login</button>
              </div>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>

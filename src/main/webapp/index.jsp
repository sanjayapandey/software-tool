<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login | Software Requirement Tool</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/font-awesome.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/ionicons.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/erp.min.css"/>'>
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b>S/W Requirement</b>Tool
  </div>
  <div class="login-box-body">
    <p class="login-box-msg"><strong>Sign In</strong></p>

    <form action="dashboard" method="post">	
      <div class="form-group has-feedback">
        <input type="text" name="username" class="form-control" placeholder="User Name">
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-4">
          <button type="submit" name="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
        </div>
<!-- 	<div class="col-xs-8"> -->
<!-- 		<a href="signup.html" class="btn btn-block btn-flat"> Create new account </a> -->
<!--         </div> -->
      </div>
    </form>
  </div>
</div>
</body>
</html>
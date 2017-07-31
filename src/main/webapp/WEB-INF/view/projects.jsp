<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
		<title>Welcome</title>
 <!-- Bootstrap Core CSS -->
 <link rel="stylesheet"
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>'>

    <!-- MetisMenu CSS -->
    <link rel="stylesheet"
	href='<c:url value="/resources/vendor/metisMenu/metisMenu.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/sb-admin-2.css"/>'>
    <!-- Custom CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/vendor/morrisjs/morris.css"/>'>
    <!-- Morris Charts CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/css/font-awesome.min.css"/>'>
    <!-- Custom Fonts -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
    <div id="wrapper">
    <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
             <jsp:include page="header.jsp"/>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="/softwaretool/dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Projects</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Quality Attributes<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">AVAILABILITY</a>
                                </li>
                                <li>
                                    <a href="morris.html">SECURITY</a>
                                </li>
                                <li>
                                    <a href="morris.html">PERFORMANCE</a>
                                </li>
                                <li>
                                    <a href="morris.html">MODIFIABILITY</a>
                                </li>
                                <li>
                                    <a href="morris.html">TESTABILITY</a>
                                </li>
                                <li>
                                    <a href="morris.html">USABILITY</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
            
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Settings<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">Panels and Wells</a>
                                </li>
                                <li>
                                    <a href="buttons.html">Buttons</a>
                                </li>
                                <li>
                                    <a href="notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="typography.html">Typography</a>
                                </li>
                                <li>
                                    <a href="icons.html"> Icons</a>
                                </li>
                                <li>
                                    <a href="grid.html">Grid</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                     
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Projects
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
					                    <div class="row">
											<div class="col-lg-9">
												
											</div>
											<div class="col-lg-3">
												<a href="/softwaretool/project/create-step-1" class="btn btn-primary">Create New Project</a>
											</div>
									    </div>
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Project Description </th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${projects}" var="project">
                                            		<tr>
	                                                    <td width="10%">${project.id }</td>
	                                                    <td width="60%"><strong>Name: </strong>${project.name} <br> <strong>Description: </strong> ${project.description}</td>
	                                                    <td width="10%">Running</td>
	                                                    <td width="20%"> 
	                                                    <a href="/softwaretool/project/view/${project.id}" class="btn btn-default">View</a>
	                                                    <a href="/softwaretool/project/edit/${project.id}" class="btn btn-default">Edit</a>
                                                	</tr>
                                            	</c:forEach>
                                               
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.col-lg-4 (nested) -->
                     
                                <!-- /.col-lg-8 (nested) -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
                <!-- /.col-lg-8 -->
               
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <jsp:include page="footer.jsp"/>
</body>

</html>
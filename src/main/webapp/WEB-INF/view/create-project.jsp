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
<!-- Bootstrap Date-Picker Plugin -->
</head>
	<script type="text/javascript">
		function showNFR(){
			$("#nfr").show();
			$("#fr").hide();
			$("#sc").hide();
		}
		function showFR(){
			$("#fr").show();
			$("#nfr").hide();
			$("#sc").hide();
		}
		function showSC(){
			$("#sc").show();
			$("#fr").hide();
			$("#nfr").hide();
		}
	</script>
<body>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Software Requirement Tool</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Project 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Project 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Project 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Project 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Project</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#" onclick="showNFR();"><i class="fa fa-edit fa-fw"></i> Non-Functional Requirement</a>
                        </li>
                        <li>
                            <a href="#" onclick="showFR();"><i class="fa fa-edit fa-fw" onclick="showFR(fr);"></i> Functional Requirement</a>
                        </li>
			<li>
                            <a href="#" onclick="showSC();"><i class="fa fa-edit fa-fw" onclick="return showSC();"></i> System Constrain</a>
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
                    <h4 class="page-header">Create Project</h4>
                    <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                        <div class="form-group">
                                        	<textarea class="form-control" rows="1"  placeholder="Name of Project"></textarea>
                                        </div>
                                        <div class="row">
                                			<div class="col-lg-6">
		                                        <div class="form-group">
		                                            <label>Start Date</label>
		                                            <input class="form-control date" id="start" name="start" placeholder="MM/DD/YYY" type="text"/>
		                                        </div>
		                                     </div>
                                			<div class="col-lg-6">
		                                        <div class="form-group">
		                                            <label>End Date</label>
		                                            <input class="form-control date" id="end" name="end" placeholder="MM/DD/YYY" type="text"/>
		                                        </div>
		                                     </div>
		                                </div>
                                  	</form>
                                  </div>
                     </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row" id="nfr">
                <div class="col-lg-12">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Non-functional Requirement
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                        <div class="form-group">
                                            <label>Quality Attribute</label>
                                            <select class="form-control">
                                                <option>AVAILABILITY</option>
                                                <option>SECURITY</option>
                                                <option>PERFORMANCE</option>
                                                <option>MODIFIABILITY</option>
                                                <option>TESTABILITY</option>
                                                <option>USABILITY</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Source</label>
                                            <select class="form-control">
                                                <option>Internal to system</option>
                                                <option>External to system</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Stimulus</label>
                                            <select class="form-control">
                                                <option>Crash</option>
                                                <option>Omission</option>
                                                <option>Timing</option>
                                                <option>No response</option>
                                                <option>Incorrect response</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Environment</label>
                                            <select class="form-control">
                                                <option>Normal operation</option>
                                                <option>Startup</option>
                                                <option>Shutdown</option>
                                                <option>Repair mode</option>
                                                <option>Degraded (failsafe) mode</option>
                                                <option>Overloaded operation</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Response</label>
                                            <select class="form-control">
                                                <option>Prevent the failure</option>
                                                <option>Log the failure</option>
                                                <option>Notify users / operators</option>
                                                <option>Disable source of failure</option>
                                                <option>Temporarily unavailable</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Measure</label>
                                            <select class="form-control">
                                                <option>Time interval available</option>
                                                <option>Availability %</option>
                                                <option>Detection time</option>
                                                <option>Repair time</option>
                                                <option>Degraded mode time interval</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Attach file</label>
                                            <input type="file">
                                        </div>
                                        <div class="form-group">
                                            <label>Description if/any</label>
                                            <textarea class="form-control" rows="2"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Save</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
										<button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                             <div class="col-lg-4 pull-right">
                             	<div class="panel panel-default">
		                        <div class="panel-heading">
		                           List of NFR
		                        </div>
		                        <!-- /.panel-heading -->
		                        <div class="panel-body">
		                            <div class="list-group">
		                                <a href="#" class="list-group-item">
		                                    AVAILABILITY
		                                </a>
		                                <a href="#" class="list-group-item">
		                                    SECURITY
		                                </a>
		                            </div>
		                            <!-- /.list-group -->
<!-- 		                            <a href="#" class="btn btn-default btn-block">View All NFR</a> -->
		                        </div>
		                        <!-- /.panel-body -->
		                    </div>
		                    <!-- /.panel -->
                            </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        <div class="row" id="fr" style="display: none;">
                <div class="col-lg-12">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Functional Requirement
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                    	<div class="form-group">
                                            <label>Name of Requirement</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Description</label>
                                            <textarea class="form-control" rows="3"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>References</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Prerequisites</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Relation to Non functional requirement</label>
                                            <select class="form-control">
                                                <option>AVAILABILITY</option>
                                                <option>SECURITY</option>
                                                <option>PERFORMANCE</option>
                                                <option>MODIFIABILITY</option>
                                                <option>TESTABILITY</option>
                                                <option>USABILITY</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Relation to Functional requirement</label>
                                            <select class="form-control">
                                                <option>FR-01</option>
                                                <option>FR-02</option>
                                                <option>FR-03</option>
                                                <option>FR-04</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Type of requirement</label>
                                            <select class="form-control">
                                                <option>Functional</option>
                                                <option>User Interface</option>
                                                <option>Other</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Attach file</label>
                                            <input type="file">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Save</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
										<button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-4 pull-right">
                             	<div class="panel panel-default">
		                        <div class="panel-heading">
		                           List of FR
		                        </div>
		                        <!-- /.panel-heading -->
		                        <div class="panel-body">
		                            <div class="list-group">
		                                <a href="#" class="list-group-item">
		                                    FR-001
		                                </a>
		                                <a href="#" class="list-group-item">
		                                    FR-002
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    FR-003
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    FR-004
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    FR-005
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    FR-006
		                                </a>
		                            </div>
		                            <!-- /.list-group -->
<!-- 		                            <a href="#" class="btn btn-default btn-block">View All NFR</a> -->
		                        </div>
		                        <!-- /.panel-body -->
		                    </div>
		                    <!-- /.panel -->
                            </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row" id="sc" style="display: none;">
                <div class="col-lg-12">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            System Constrain
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                    	<div class="form-group">
                                            <label>Software Requirement</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Hardware Requirement</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Network Requirement</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Any other requirement</label>
                                            <textarea class="form-control" rows="1"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Attach file</label>
                                            <input type="file">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Save</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
										<button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-4 pull-right">
                             	<div class="panel panel-default">
		                        <div class="panel-heading">
		                           List of SC
		                        </div>
		                        <!-- /.panel-heading -->
		                        <div class="panel-body">
		                            <div class="list-group">
		                                <a href="#" class="list-group-item">
		                                    SC-001
		                                </a>
		                                <a href="#" class="list-group-item">
		                                    SC-002
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    SC-003
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    SC-004
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    SC-005
		                                </a>
		                                 <a href="#" class="list-group-item">
		                                    SC-006
		                                </a>
		                            </div>
		                            <!-- /.list-group -->
<!-- 		                            <a href="#" class="btn btn-default btn-block">View All NFR</a> -->
		                        </div>
		                        <!-- /.panel-body -->
		                    </div>
		                    <!-- /.panel -->
                            </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script type="text/javascript" src='<c:url value="/resources/vendor/jquery/jquery.min.js"/>'></script>
    <!-- Bootstrap Core JavaScript -->
	<script type="text/javascript" src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>'></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src=""></script>
	<script type="text/javascript" src='<c:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>'></script>
    <!-- Custom Theme JavaScript -->
    <script type="text/javascript" src='<c:url value="/resources/js/sb-admin-2.js"/>'></script>

</body>

</html>
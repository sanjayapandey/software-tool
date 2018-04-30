<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<link rel="stylesheet"
	href='<c:url value="/resources/css/jquery.sweet-modal.min.css"/>'>
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
	<style>
a {
    text-decoration: none;
    display: inline-block;
    padding: 8px 16px;
}

a:hover {
    background-color: #ddd;
    color: black;
}

.previous {
    background-color: #f1f1f1;
    color: black;
}

.next {
    background-color: #4CAF50;
    color: white;
}

.round {
    border-radius: 50%;
}
</style>
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
                    <h4 class="page-header">Cost Calculation of Project  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="/softwaretool/cost-estimate/${project.id}" class="btn previous">&laquo;   Previous</a></h4>
                    <div class="row">
                    			<div class="col-lg-12">
                    			<div class="row">
                    				<label>Project Name: </label>${project.name}<hr>
                     </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row" id="nfr">
                <div class="col-lg-10">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Functional Point
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6"  style="font-size: 18px;color: mediumblue;">
                                   Total Functional Point: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${fp}" />
                                   
                                </div>
                                 <div class="col-lg-6">
	                                <strong>Final functional point = UFP * CAF</strong><br>
									<i>where, &nbsp &nbsp&nbsp UFP: Unadjusted function point<br>
									&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp CAF: Complexity adjustment factor </i>
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
            <!-- /.row -->
            <!-- /.row -->
            <div class="row" id="nfr">
                <div class="col-lg-10">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Effort
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6" style="font-size: 18px;color: mediumblue;">
                                   Total Effort : <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${effort}" />
                                   PM
                                </div>
                                <div class="col-lg-6">
                               	<strong> Effort = Total_Functional_Point(FP)/Productivity</strong><br>
                               	<i> Assumption: productivity = 10 <br>
                               	PM = person-months
                               	</i>
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
            <!-- /.row -->
            <!-- /.row -->
            <div class="row" id="nfr">
                <div class="col-lg-10">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Cost
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6" style="font-size: 18px;color: mediumblue;">
                                   Total Cost : $ <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalCost}" />
                                 </div>
                                 <div class="col-lg-6">
                               	<strong> Total cost = Effort * average_cost_per_fp</strong><br>
                               	<i> Assumption: average_cost_per_fp = 1000</i>
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
            <!-- /.row -->
             <!-- /.row -->
            <div class="row" id="nfr">
                <div class="col-lg-10">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            Size (LOC)
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6" style="font-size: 18px;color: mediumblue;">
                                   Size(Line of Code): <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${size}" />
                                </div>
                                <div class="col-lg-6">
                               	<strong> Size(LOC) = functional Point* effort</strong><br>
                               	
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                </div>
                <!-- /.col-lg-12 -->
            	<!-- /.row -->
	            <div class="row" id="nfr">
	                <div class="col-lg-10">
	                    <div class="panel panel-green">
	                        <div class="panel-heading">
	                            Duration
	                        </div>
	                        <div class="panel-body">
	                            <div class="row">
	                                <div class="col-lg-6" style="font-size: 18px;color: mediumblue;">
	                                  Duration: ${duration} months
	                                 </div>
	                                 <div class="col-lg-6">
		                               		<strong> Duration = Effort / number of staff </strong><br>
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
	            <!-- /.row -->
        </div>
     </div>
    </div>
     <script type="text/javascript">
		function deleteProject(id){
			$.sweetModal.confirm('Delete the project?', 'Are you sure you want to delete this project?', function() {
				$.ajax({
				    url : '/softwaretool/project/delete/'+id,
				    type : 'PUT',
				    success : function(data) {  
					    if(data=="success"){    
					    	$.sweetModal('Project is deactivated! you can activate later!!'); 
				    		window.location.href = '/softwaretool/project/list'; 
					    }else{
					    	$.sweetModal("error, try again!");	
							
						 }
				    },
				    error : function(request,error){
				        console.log("Request: "+JSON.stringify(request));
				    }
				});
			}, function() {
				//$.sweetModal('You declined. That\'s okay!');
			});
		}
   </script>
    <jsp:include page="footer.jsp"/>

</body>

</html>
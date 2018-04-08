<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import="com.und.softwaretool.service.RelationOfRequirementService" %>
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
<body>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
           <jsp:include page="header.jsp"/>
            <!-- /.navbar-top-links -->
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
                    <h4 class="page-header">View Project</h4>
                    
                    <div class="row">
                    			<div class="col-lg-4 pull-right">
                    			<a href="/softwaretool/project/edit/${project.id}" class="btn btn-primary">Edit Project</a>
                    			 <a class="btn btn-danger" onclick="return deleteProject(${project.id})">Delete Project</a>
                    			<br>
                    			</div>
                                <div class="col-lg-6">
                                    <form>
                                        <div class="form-group">
                                        	<textarea class="form-control" rows="1">${project.name}</textarea>
                                        </div>
                                        <div class="row">
                                			<div class="col-lg-6">
		                                        <div class="form-group">
		                                            <label>Start Date</label>
		                                            <fmt:formatDate value="${project.startDate}" var="startDate" pattern="MM/dd/yyyy" />
		                                            <input class="form-control date" id="start" name="start"  type="text" value="${startDate}"/>
		                                        </div>
		                                     </div>
                                			<div class="col-lg-6">
		                                        <div class="form-group">
		                                            <label>End Date</label>
		                                            <fmt:formatDate value="${project.endDate}" var="endDate" pattern="MM/dd/yyyy" />
		                                            <input class="form-control date" id="end" name="end" type="text" value="${endDate}"/>
		                                        </div>
		                                     </div>
		                                     <div class="col-lg-12">
		                                        <div class="form-group">
		                                            <label>Description</label>
		                                            <textarea class="form-control" rows="2">${project.description}</textarea>
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
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Namae</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${nonFunctionalReqs}" var="nonFunctionalReq">
                                            		<tr>
	                                                    <td width="10%">${nonFunctionalReq.key }</td>
	                                                     <td ><a href="/softwaretool/project/non-functional-req/${nonFunctionalReq.id}" >${nonFunctionalReq.qualityAttribute}</a><br>
	                                                     	<c:forEach items="${functionalReqs}" var="functionalReq">
	                                                   			<c:if test="${ nonFunctionalReq.id eq functionalReq.nonFunctionalReq.id}">
	                                                   				<span class="label label-info"><c:out value="${functionalReq.key}"/></span>
	                                                   			</c:if>
	                                                    	</c:forEach>
	                                                </tr>
				                            	</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
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
            <div class="row" id="nfr">
                <div class="col-lg-12">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                           Functional Requirement
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Name</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${functionalReqs}" var="functionalReq">
                                            		<tr>
	                                                    <td width="10%">${functionalReq.key }</td>
	                                                    <c:set var="funReqId" value="${functionalReq.id }"/>
	                                                     <td>${functionalReq.name}<br>
	                                                     <c:set var="nonFunctionalReq" value="${functionalReq.nonFunctionalReq}"/> 
	                                                     <c:if test="${not empty nonFunctionalReq}"> 
	                                                     	<span class="label label-primary">${functionalReq.nonFunctionalReq.qualityAttribute}</span><br>
	                                                      </c:if>
	                                                      
	                                                  	<c:forEach var="entry" items="${mapOfRelatedFR}">
	                                                  		<c:if test="${entry.key eq functionalReq.id}">
	                                                  			<span class="label label-info"><c:out value="${entry.value}"/></span>
	                                                  		</c:if>
														</c:forEach>
	                                                     </td>
	                                                </tr>
				                            	</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
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
            <div class="row" id="nfr">
                <div class="col-lg-12">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                           System Constrain
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Namae</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${systemConstrains}" var="systemConstrain">
                                            		<tr>
	                                                    <td width="10%">${systemConstrain.key }</td>
	                                                     <td ><strong>Software Requirement: </strong>${systemConstrain.softwareRequirement}<br>
	                                                     	  <strong>Hardware Requirement: </strong>${systemConstrain.hardwareRequirement}<br>
	                                                     	  <strong>Network Requirement: </strong>${systemConstrain.networkRequirement}<br>
	                                                     	  <strong>Other Requirement: </strong>${systemConstrain.otherRequirement}
	                                                     </td>
	                                                </tr>
				                            	</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
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
    <!-- /#wrapper -->
<jsp:include page="footer.jsp"/>]
</body>

</html>
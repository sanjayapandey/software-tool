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
                    <h4 class="page-header">Cost Estimation</h4>
                    <div class="row">
                    			<div class="col-lg-12">
                    			<div class="row">
                    				<label>Project Name: </label>${project.name}<hr>
                    			</row>
                    			</div>
                                <div class="col-lg-6">
                                   
                                        <div class="row">
                                        	<label>CFP Calculation Table</label>
                                			<table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Complexity</th>
                                                    <th>Low</th>
                                                    <th>Average</th>
                                                    <th>High</th>
                                                    <th>Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
<%--                                             	<c:forEach items="${cfp}" var="cfp"> --%>
                                            		<tr>
	                                                    <td width="60%">External Inputs</td>
	                                                    <td width="10%">2</td>
	                                                    <td width="10%">4</td>
	                                                    <td width="10%">1</td>
	                                                    <td width="10%">7</td>
	                                                
                                                	</tr>
                                                	<tr>
	                                                    <td width="60%">External Outputs</td>
	                                                    <td width="10%">2</td>
	                                                    <td width="10%">4</td>
	                                                    <td width="10%">1</td>
	                                                    <td width="10%">7</td>
	                                                
                                                	</tr>
                                                	
<%--                                             	</c:forEach> --%>
                                               
                                            </tbody>
                                        </table>
		                                </div>
		                                
                                        <a href="/softwaretool/dashboard" class="btn btn-primary">Back to Dashboard</a>
                                  </div>
                     </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
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
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
                    <h4 class="page-header">Cost Estimation &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="/softwaretool/dashboard" class="btn previous">&laquo;   Previous</a>
<a href="calculate/${project.id}" class="btn next">Calculate Cost   &raquo;</a> </h4>
                    <div class="row">
                    			<div class="col-lg-12">
                    			<div class="row">
                    				<label>Project Name: </label>${project.name}<hr>
                    			</row>
                    			</div>
                                <div class="col-lg-12">
                                        <div class="row">
                                        	<form action="save-cfp" name="cfp-form" method="POST">
                                        	<input type="hidden" name="projectId" value="${project.id}">
                                        	<input type="hidden" name="cfpId" value="${cfp.id}">
                                        	<input type="hidden" name="eiId" value="${externalInputs.id}">
                                        	<input type="hidden" name="eifId" value="${externalInterfaceFiles.id}">
                                        	<input type="hidden" name="eoId" value="${externalOutputs.id}">
                                        	<input type="hidden" name="eqId" value="${externalQueries.id}">
                                        	<input type="hidden" name="ilfId" value="${internalLogicFiles.id}">
                                        	<label>CFP Calculation Table</label>
                                			<table class="table table-bordered table-hover table-striped">
	                                            <thead>
	                                                <tr>
	                                                    <th>Complexity</th>
	                                                    <th colspan="2">Simple</th>
	                                                    <th colspan="2">Average</th>
	                                                    <th colspan="2">Complex</th>
	                                                    <th >Total</th>
	                                                </tr>
	                                            </thead>
	                                            <tbody>
	                                            		<tr>
		                                                    <td width="">External Inputs</td>
		                                                    <td width=""><input type="number" name="eiSimple" value="${externalInputs.simple}"></td>
		                                                    <td width="">X 3</td>
		                                                    <td width=""><input type="number" name="eiAverage" value="${externalInputs.average}"></td>
		                                                    <td width="">X 4</td>
		                                                    <td width=""><input type="number" name="eiComplex" value="${externalInputs.complex}"></td>
		                                                    <td width="">X 6</td>
		                                                    <td width="">16</td>
	                                                	</tr>
	                                                	<tr>
		                                                    <td width="">External Interface Files</td>
		                                                    <td width=""><input type="number" name="eifSimple" value="${externalInterfaceFiles.simple}"></td>
		                                                    <td width="">X 4</td>
		                                                    <td width=""><input type="number" name="eifAverage" value="${externalInterfaceFiles.average}"></td>
		                                                    <td width="">X 5</td>
		                                                    <td width=""><input type="number" name="eifComplex" value="${externalInterfaceFiles.complex}"></td>
		                                                    <td width="">X 7</td>
		                                                    <td width="">13 </td>
	                                                	</tr>
	                                                	<tr>
		                                                    <td width="">External Outputs</td>
		                                                    <td width=""><input type="number" name="eoSimple" value="${externalOutputs.simple}"></td>
		                                                     <td width="">X 7</td>
		                                                    <td width=""><input type="number" name="eoAverage" value="${externalOutputs.average}"></td>
		                                                     <td width="">X 10</td>
		                                                    <td width=""><input type="number" name="eoComplex" value="${externalOutputs.complex}"> </td>
		                                                     <td width="">X 15</td>
		                                                    <td width="">19 </td>
	                                                	</tr>
	                                                	<tr>
		                                                    <td width="">External Queries</td>
		                                                    <td width=""><input type="number" name="eqSimple" value="${externalQueries.simple}"></td>
		                                                     <td width="">X 3</td>
		                                                    <td width=""><input type="number" name="eqAverage" value="${externalQueries.average}"> </td>
		                                                     <td width="">X 5</td>
		                                                    <td width=""><input type="number" name="eqComplex" value="${externalQueries.complex}"> </td>
		                                                     <td width="">X 7</td>
		                                                    <td width="">17 </td>
	                                                	</tr>
	                                                	<tr>
		                                                    <td width="">Internal Logic Files</td>
		                                                    <td width=""><input type="number" name="ilfSimple" value="${internalLogicFiles.simple}"></td>
		                                                     <td width="">X 5</td>
		                                                    <td width=""><input type="number" name="ilfAverage" value="${internalLogicFiles.average}"></td>
		                                                     <td width="">X 7</td>
		                                                    <td width=""><input type="number" name="ilfComplex" value="${internalLogicFiles.complex}"></td>
		                                                     <td width="">X 10</td>
		                                                    <td width="">14 </td>
	                                                	</tr>
	                                                	
	                                            </tbody>
                                       		 </table>
                                       		
                                       		 <input type="submit" class="btn btn-primary pull-right" name="save" value="Save CFP Table"/>
                                       		 <button type="reset" class="btn btn-default pull-right">Reset Table   </button>
                                       		</form>
		                                </div>
		                                <div class="row">
                                        	<form action="save-rcaf" name="rcaf-form" method="POST">
                                        	<input type="hidden" name="projectId" value="${project.id}">
                                        	<input type="hidden" name="rcafId" value="${rcaf.id}">
                                        	<label>Relative complexity adjustment factor (RCAF) form</label>
                                			<table class="table table-bordered table-hover table-striped">
	                                            <thead>
	                                                <tr>
	                                                    <th>No</th>
	                                                    <th>Subject</th>
	                                                    <th>Grade</th>
	                                                </tr>
	                                            </thead>
	                                            <tbody>
	                                                  	 <c:forEach items="${map}" var="subject">
													        <tr>
				                                                   <td>${subject.key}</td>
				                                                   <td>${subject.value}</td>
				                                                   <td>
				                                                 
				                                                   <input type="radio" name="s${subject.key}" value="0" <c:if test="${gradeMap[subject.key] eq 0}">checked</c:if>>0 &nbsp&nbsp&nbsp 
				                                                   <input type="radio" name="s${subject.key}" value="1" <c:if test="${gradeMap[subject.key] eq 1}">checked</c:if>>1 &nbsp&nbsp&nbsp
				                                                   <input type="radio" name="s${subject.key}" value="2" <c:if test="${gradeMap[subject.key] eq 2}">checked</c:if>>2 &nbsp&nbsp&nbsp
				                                                   <input type="radio" name="s${subject.key}" value="3" <c:if test="${gradeMap[subject.key] eq 3}">checked</c:if>>3 &nbsp&nbsp&nbsp
				                                                   <input type="radio" name="s${subject.key}" value="4" <c:if test="${gradeMap[subject.key] eq 4}">checked</c:if>>4 &nbsp&nbsp&nbsp
				                                                   <input type="radio" name="s${subject.key}" value="5" <c:if test="${gradeMap[subject.key] eq 5}">checked</c:if>>5 &nbsp&nbsp&nbsp
				                                                   </td>
	                                                		</tr>
													    </c:forEach>
	                                            </tbody>
                                       		 </table>
                                       		 
                                       		 <input type="submit" class="btn btn-primary pull-right" name="save" value="Save RCAF Form"/>
                                       		 <button type="reset" class="btn btn-default pull-right">Reset From  </button>
                                       		</form>
		                                </div>
                                  </div>
                     </div>
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
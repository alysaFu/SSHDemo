<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oracle.hackson.bean.EmployeeResult"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.png">

    <title>Person vCard </title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
	
	
    <link rel="stylesheet" href="css/jquery.jOrgChart.css"/>
	 <link rel="stylesheet" href="css/custom.css"/>
	<link href="css/prettify.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="prettify.js"></script>
     <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="jquery.jOrgChart.js"></script>
    <script>
    jQuery(document).ready(function() {
    	   $("#org").jOrgChart({
   			chartElement : '#chart'
   		});
    	   $("#department").jOrgChart({
   			chartElement : '#departmentChart'
   		});	   
		/* Extra Code */
		$("#show-list").click(function(e){
			e.preventDefault();
			
			$('#list-html').toggle('fast', function(){
				if($(this).is(':visible')){
					$('#show-list').text('Hide underlying list.');
					$(".topbar").fadeTo('fast',0.9);
				}else{
					$('#show-list').text('Show underlying list.');
					$(".topbar").fadeTo('fast',1);					
				}
			});
		});
    });
    </script>
	
	

    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">
	

   
  

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
		<style>
body{TEXT-ALIGN: center;}
.center{ MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;

height:100px;
width:900px;
vertical-align:middle;

}
</style>
  </head>

  <body >
  <jsp:include page="/jsp/navheader.jsp" flush="true"/>
  <div class="center">
   <h3 class="demo-panel-title" style="TEXT-ALIGN:left;margin-left:80px">Alimama Search</h3>
      <div class="row" style="height:100px;">
        <div class="col-xs-3" style="width:83%;height:100px;margin-left:80px">
          <div class="form-group" style="height:100px">
            <input type="text" value="" placeholder="Enter name or email address" class="form-control" id="search-name"/>
	
	</div>
	
		   
        </div>
          
      </div> <!-- /row -->
	</div>

    <%
       String email = request.getParameter("email");
       EmployeeResult rs = (EmployeeResult)request.getSession().getAttribute(email);
       String displayName = "";
	   if(rs.getFirstName() != null && rs.getFirstName().trim().length() > 0)
		   displayName += rs.getFirstName() + " ";
	   if(rs.getMiddleName() != null && rs.getMiddleName().trim().length() > 0)
		   displayName += rs.getMiddleName() + " ";
	   if(rs.getLastName() != null && rs.getLastName().trim().length() > 0)
		   displayName += rs.getLastName() + " ";
	   List<EmployeeResult> emList = (List<EmployeeResult>)request.getSession().getAttribute("orgsList");
    %>
    <input type="hidden" id="email" value="<%=email%>">
    <div class="container">
    	<div class="col-lg-6 col-lg-offset-3">
    	
    		<!-- ===== vCard Navigation ===== -->
    		<div class="row w">
    			<div class="col-md-4">
    				<img class="img-responsive" src="img/userImage/<%=rs.getPhoto().split(".jpg")[0]+"_new.jpg" %>" alt="" onerror="this.src='img/userImage/default2.jpg'"/>
					<ul class="nav nav-tabs nav-stacked" id="myTab">
					  <li class="active"><a id="aboutTab"href="#about">Basic</a></li>
					  <li><a id="profileTab" href="#profile">Org</a></li>
					  <li><a id="portfolioTab" href="#portfolio">Department</a></li>
					  <li><a id="nameCardTab" href="#portfolio">Name Card</a></li>
					</ul>    			
				</div><!-- col-md-4 -->

    		<!-- ===== vCard Content ===== -->
    			<div class="col-md-8">
	    			<div class="tab-content">
	    			
	    			  <!-- ===== First Tab ===== -->
					  <div class="tab-pane active" id="about">
					  	<h3><%=displayName%></h3>
					  	<h5><%=rs.getJobTitle()%>, <%=rs.getGender()%></h5>
					  		<h4><i class="icon-file-text-alt"></i> Contacts</h4>
					  	<p class="sm">
					  		<grey>Work Phone</grey> | <%=rs.getWorkPhone()%><br/>
					  		<grey>Cell Phone</grey> | <%=rs.getMobilePhone()%><br/>
							<grey>email</grey> |  <%=rs.getEmail()%><br/>
					  	</p>
					  
						  <h4><i class="icon-file-text-alt"></i> Address</h4>
					  	<p class="sm">
					  		<grey>Country</grey> |  <%=rs.getCountryName()%><br/>
							<grey>Region</grey> |  <%=rs.getAddress()%><br/>
					  		<grey>Building</grey> | <%=rs.getBuilding()%><br/>
							<grey>Floor</grey> | <%=rs.getFloor() %> <br/>
							<grey>Office</grey> | <%=rs.getOffice() %><br/>
					  	</p>
					  
					  </div><!-- tab about -->
					  
	    			  <!-- ===== Second Tab ===== -->
					  <div class="tab-pane" id="profile">
					  <ul id="org" style="display:none">
    <li>
       <a href="#" target="_blank"><%=emList.get(0).getFirstName() +" "+ emList.get(0).getLastName() %></a>
       <p><%=emList.get(0).getJobTitle()%></p>
       <ul>
         <li><a href="#" target="_blank"><%=displayName %></a>
             <p><%=rs.getJobTitle()%></p>
		  <ul>
		     <%for(int i=1; i <emList.size(); ++i){
		         if(emList.get(i).getEmail().equals(email))continue;
		      %>
             <li><a href="#" target="_blank"><%=emList.get(i).getFirstName()+" " + emList.get(i).getLastName() %></a>
              <p><%=emList.get(i).getJobTitle()%></p>
             </li>
             <%} %>
             
           </ul>
		   </li>
		 
    
       </ul>
     </li>
   </ul>			
	
	<div id="chart" class="orgChart">
	</div>
					  </div><!-- Tab Profile -->
					  
	    			  <!-- ===== Third Tab ===== -->
					  <div class="tab-pane" id="portfolio">
						<ul id="department" style="display:none">
    <li>
       <a href="#" target="_blank"><%=emList.get(0).getOrg()%></a>
       <ul>
         <li><a href="#" target="_blank"><%=rs.getOrg() %></a>
		 <ul>
		     <%for(int i=1; i <emList.size(); ++i){
		         if(emList.get(i).getEmail().equals(email) || emList.get(i).getOrg().equals(rs.getOrg()))continue;
		      %>
             <li><a href="#" target="_blank"><%=emList.get(i).getOrg() %></a></li>
             <%} %>
           </ul>
		   </li>
		 
    
       </ul>
     </li>
   </ul>			
	
	<div id="departmentChart" class="orgChart">
					  </div><!-- /Tab Portfolio -->
					  
	    			 
					  
					</div><!-- Tab Content -->
					
			<div class="tab-pane" id="nameCard" style="display:none">
					  	
					  	<img src="img/2Dcode.jpg"/>
			</div>
    			</div><!-- col-md-8 -->
    		</div><!-- row w -->
    	</div><!-- col-lg-6 -->
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

	<script>
	$('#profileTab').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	 
	  $("#about").css('display','none');
	    $("#portfolio").css('display','none');
		$("#profile").css('display','');
		$("#nameCard").css('display','none');
	 
		//parent.location.reload();
	})
	$('#aboutTab').click(function (e) {
	  e.preventDefault();
	  $(this).tab('show');
	    $("#profile").css('display','none');
	    $("#portfolio").css('display','none');
		$("#about").css('display','');
		$("#nameCard").css('display','none');
	  
	});
	$('#nameCardTab').click(function (e) {
		  e.preventDefault();
		  $(this).tab('show');
		    $("#profile").css('display','none');
		    $("#portfolio").css('display','none');
			$("#about").css('display','none');
			$("#nameCard").css('display','');
		  
		});
	$('#portfolioTab').click(function (e) {
	  e.preventDefault();
	  
	  $(this).tab('show');
	    $("#about").css('display','none');
	    $("#profile").css('display','none');
		$("#portfolio").css('display','');
		$("#nameCard").css('display','none');
	  
	});
	
	 $("#search-name").bind('keypress',function(event){
		 if(event.keyCode == "13"){
			$.ajax({  
		        url : "basicSearch",   
		        type : "post", 
				dataType: "json",
		        data:{"keywords" : $("#search-name").val()},  
		        success : function(message){
		        		//$('#help').html(message);
		        	    location.replace(basePath+"/searchResult.jsp");
		        },
		        error:function(data){alert("page error!");}   
		    }); 
		 }
		});
		
	</script>    
	
    
  </body>
</html>

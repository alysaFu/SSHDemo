<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oracle.hackson.bean.EmployeeResult"%>
<%@ page import="java.util.List"%>
<html>
  <head>
    <meta charset="utf-8">
    <title>Search Result</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="assets/dist/css/vendor/bootstrap.min.css" rel="stylesheet">
    <link href="dist/css/vendor/bootstrap-theme.min.css" rel="stylesheet">
	<link href="dist/css/vendor/theme.css" rel="stylesheet">
    

    <!-- Loading Flat UI -->
    <link href="assets/dist/css/flat-ui.css" rel="stylesheet">
    <link href="assets/docs/assets/css/demo.css" rel="stylesheet">

    <link rel="shortcut icon" href="img/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="dist/js/vendor/html5shiv.js"></script>
      <script src="dist/js/vendor/respond.min.js"></script>
    <![endif]-->
	<style>
body{TEXT-ALIGN: center;}
.center{ MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;

height:100px;
width:900px;
vertical-align:middle;
line-height:200px;
}
.pagination{ MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;
vertical-align:middle;
TEXT-ALIGN:left;
}
dl.palette1{ 
border-radius: 10px 10px 0px 0px; 
}
dl.palette2{ 
border-radius: 0px 0px 10px 10px; 
}
</style>
       <script type="text/javascript">
        var basePath = "<%=request.getContextPath()%>";
       </script>
  </head>
  <body >
  <jsp:include page="/jsp/navheader.jsp" flush="true"/>
  
   <div class="center">
      <h3 class="demo-panel-title" style="TEXT-ALIGN:left">Alimama Search</h3>
	
      <div class="row" >
        <div class="col-xs-3" style="width:72%; height:100px">
          <div class="form-group">
           <div class="demo-icons" >
		<div >
		<span id="listViewSwitch" class="fui-list-numbered" style="position:absolute;right:62px;top:-30px;width:60px;text-align:right;margin-top:5px;cursor: pointer;"></span>
         <span id="cardVewSwitch" class="fui-list-large-thumbnails" style="position:absolute;top:-30px;right:12px;width:60px;text-align:right;margin-top:5px;cursor: pointer;"><a href="#"></a></span>
	 	</div>
	    </div>
            <input type="text" value="" placeholder="Enter name or email address" class="form-control" id="search-name2"/>
       
            
          </div>
        </div>
              
      </div> <!-- /row -->
	</div>
	<div class="center">
      <div class="row demo-swatches-row">
	      <div class="swatches-col"  id="card">
	        <input type="hidden" id="curpage" value="0"/>
            
     <% 
        int size = 0;  
        int dlsPerPage = 9;
        int curPage = 0;
        if(request.getParameter("currentPage") != null && request.getParameter("currentPage").trim().length() > 0)
        	curPage = Integer.parseInt(request.getParameter("currentPage"));
        if(request.getSession().getAttribute("employeeResults") != null){
               List<EmployeeResult> emList = (List<EmployeeResult>)request.getSession().getAttribute("employeeResults");
    	       size = emList.size();
               for(int i=curPage * dlsPerPage; i < emList.size() && i < (curPage + 1) * dlsPerPage; ++i){
            	   String displayName = "";
            	   if(emList.get(i).getFirstName() != null && emList.get(i).getFirstName().trim().length() > 0)
            		   displayName += emList.get(i).getFirstName() + " ";
            	   if(emList.get(i).getMiddleName() != null && emList.get(i).getMiddleName().trim().length() > 0)
            		   displayName += emList.get(i).getMiddleName() + " ";
            	   if(emList.get(i).getLastName() != null && emList.get(i).getLastName().trim().length() > 0)
            		   displayName += emList.get(i).getLastName() + " ";
            	   String title = emList.get(i).getJobTitle();
            	   String email = emList.get(i).getEmail();
            	   request.getSession().setAttribute(email, emList.get(i));
      %>
            <input type="hidden" id="firstpage" value="<%=0%>"/>
            <input type="hidden" id="<%=email %>" name="<%=email %>"  value="<%=emList.get(i)%>"/>
            <div class="pallete-item" onclick="javascript:information('<%=email%>')">
            <% if(i % 8 == 0){%>
              <dl class="palette palette-turquoise palette1">
            <%}else if(i % 8 == 1){ %>
              <dl class="palette palette-emerald palette1">
             <%}else if(i % 8 == 2){ %>
             <dl class="palette palette-peter-river palette1">
             <%}else if(i % 8 == 3){ %>
              <dl class="palette palette-amethyst palette1">
             <%}else if(i % 8 == 4){ %>
             <dl class="palette palette-wet-asphalt palette1">
             <%}else if(i % 8 == 5){ %>
              <dl class="palette palette-sun-flower palette1">
             <%}else if(i % 8 == 6){ %>
              <dl class="palette palette-carrot palette1">
             <%}else if(i % 8 == 7){ %>
             <dl class="palette palette-alizarin palette1">
             <%}%>
               <dt placeholder="<%=displayName%>">
                <%=displayName.length() > 15 ? displayName.substring(0, 15)+"...":displayName %>
               </dt>
              </dl>
           <% if(i % 8 == 0){%>
              <dl class="palette palette-green-sea palette2">
            <%}else if(i % 8 == 1){ %>
              <dl class="palette palette-nephritis palette2">
             <%}else if(i % 8 == 2){ %>
              <dl class="palette palette-belize-hole palette2">
             <%}else if(i % 8 == 3){ %>
              <dl class="palette palette-wisteria palette2">
             <%}else if(i % 8 == 4){ %>
             <dl class="palette palette-midnight-blue palette2">
             <%}else if(i % 8 == 5){ %>
             <dl class="palette palette-orange palette2">
             <%}else if(i % 8 == 6){ %>
              <dl class="palette palette-pumpkin palette2">
             <%}else if(i % 8 == 7){ %>
              <dl class="palette palette-pomegranate palette2">
             <%}%>
			    <img src="img/userImage/<%=emList.get(i).getPhoto() %>"  onerror="this.src='img/userImage/default1.jpg'"/>
                <dd>Job Tile: <%=title!=null && title.length() > 16? title.substring(0, 15)+"...":title%></dd>
                <dd>Work Phone: <%=emList.get(i).getWorkPhone() %></dd>
				<dd>Email:<%=email!=null && email.length() > 20? email.substring(0, 19)+"...":email %></dd>
              </dl>
		      </div>
            	   
      <% 
               }
           }else{
      %>
                 <div class="row demo-swatches-row">No Such User.Please Have Another Try.</div>
      <%  	   
           }
      %>

	</div>

    <div class="swatches-col"  id="card">
	      
    <div class="col-sm-4" style="display:none" id="listView">
    
          <div class="list-group" style="width:650px;margin-left:-17px" >
          <%
          if(request.getSession().getAttribute("employeeResults") != null){
              List<EmployeeResult> emList = (List<EmployeeResult>)request.getSession().getAttribute("employeeResults");
   	       size = emList.size();
              for(int i=curPage * dlsPerPage; i < emList.size() && i < (curPage + 1) * dlsPerPage; ++i){
           	   String displayName = "";
           	   if(emList.get(i).getFirstName() != null && emList.get(i).getFirstName().trim().length() > 0)
           		   displayName += emList.get(i).getFirstName() + " ";
           	   if(emList.get(i).getMiddleName() != null && emList.get(i).getMiddleName().trim().length() > 0)
           		   displayName += emList.get(i).getMiddleName() + " ";
           	   if(emList.get(i).getLastName() != null && emList.get(i).getLastName().trim().length() > 0)
           		   displayName += emList.get(i).getLastName() + " ";
           	   String title = emList.get(i).getJobTitle();
           	   String email = emList.get(i).getEmail();
          %>
            <a href="#" class="list-group-item" style="TEXT-ALIGN:left" onclick="javascript:information('<%=email%>')">
              <h4 class="list-group-item-heading"><%=displayName %></h4>
              <p class="list-group-item-text">Job Tile: <%=title%> , Phone : <%=emList.get(i).getWorkPhone()%> ,</p>
              <p class="list-group-item-text">Email:<%=email %></p>
            </a>
            <%}
              }%>
          </div>
        </div>
        </div>
        
        </div>
        </div>
        
                  <%   if(size > 0){   %>

    <div class="pagination">
            <ul>
              <li class="previous"><a href="javascript:frontPagess( <%=size / dlsPerPage + 1%>)" class="fui-arrow-left"></a></li>
              <%  for(int i=0; i < size / dlsPerPage + 1; ++i){
                  if(i < 8){
               %>
              <li id="li<%=i%>"><a href="searchResult.jsp?currentPage=<%=i%>" name="pageIndex"><%= i + 1%></a></li>
                 <% }else{%>
              <li id="li<%=i%>" style="display:none;"><a href="searchResult.jsp?currentPage=<%=i%>" name="pageIndex"><%= i + 1%></a></li>
               <%}
                 }
                 %>
              <li class="next"><a href="javascript:nextPagess( <%=size / dlsPerPage + 1%>)" class="fui-arrow-right"></a></li>
            </ul>
   </div> <!-- /pagination -->
   <%  }   %>
    
    
  
    
    <script src="assets/dist/js/vendor/jquery.min.js"></script>
    <script src="assets/dist/js/vendor/video.js"></script>
    <script src="assets/dist/js/flat-ui.min.js"></script>
    <script src="assets/docs/assets/js/application.js"></script>
    <script src="assets/js/custom.js"></script>
	
    <script>
	$('#cardVewSwitch').click(function () {
	  $("#listView").css('display','none');
	   
		$("#card").css('display','');
	 
		//parent.location.reload();
	});
	$('#listViewSwitch').click(function () {
	  $("#card").css('display','none');
	  // $("#pagination").css('margin-left',"200px");
	   //$("#pagination").css('margin-right',"230px")
		$("#listView").css('display','');
	 
		//parent.location.reload();
	});
	
		
	</script> 	   

    

    <script>
      videojs.options.flash.swf = "assets/dist/js/vendors/video-js.swf";
      
      function nextPages(sum){
    	  var first = parseInt(document.getElementById("firstpage").value);
    	  var newFirst = first;
    	  if(first < sum - 8){
    		  document.getElementById("li"+ first).style.display="none";
    		  document.getElementById("li"+ (first + 8)).style.display="";
    		  ++newFirst;
    	  }
    	  if(first < sum - 9){
    		  document.getElementById("li"+ (first + 1)).style.display="none";
    		  document.getElementById("li"+ (first + 9)).style.display="";
    		  ++newFirst;
    	  }
    	  if(first < sum - 10){
    		  document.getElementById("li"+ (first + 2)).style.display="none";
    		  document.getElementById("li"+ (first + 10)).style.display="";
    		  ++newFirst;
    	  }
    	  document.getElementById("firstpage").value = newFirst;
      }
      
      function frontPages(sum){
    	  var first = parseInt(document.getElementById("firstpage").value);
    	  var newFirst = first;
    	  if(first > 0){
    		  document.getElementById("li"+ (first - 1)).style.display="";
    		  document.getElementById("li"+ (first + 7)).style.display="none";
    		  --newFirst;
    	  }
    	  if(first > 1){
    		  document.getElementById("li"+ (first - 2)).style.display="";
    		  document.getElementById("li"+ (first + 6)).style.display="none";
    		  --newFirst;
    	  }
    	  if(first > 2){
    		  document.getElementById("li"+ (first - 3)).style.display="";
    		  document.getElementById("li"+ (first + 5)).style.display="none";
    		  --newFirst;
    	  }
    	  document.getElementById("firstpage").value = newFirst;
      }
      function information(data1){
      	$.ajax({
        	url:"orgSearch",
        	type:'POST',
        	dateType: "json",   
        	data: {
            	   email : data1,
                  },
        	success:function(message){
        		    window.location.replace(basePath + "/detailResult.jsp?email="+data1);
            },
            error:function(data){alert("page error!");}
        });
    	  
      }
    </script>
  </body>
</html>

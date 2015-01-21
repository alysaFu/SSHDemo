<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        
        <meta charset="utf-8">
        <title>Oracle Social Network Platform</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
       <script type="text/javascript">
        var basePath = "<%=request.getContextPath()%>";
       </script>
        
               <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">
        <!--link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css" -->
        <!--link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster" -->
        <!-- link rel='stylesheet' type='text/css' 
              href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' -->
           
           
        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

       <jsp:include page="/jsp/navheader.jsp" flush="true"/>
       
        <!-- Sign-up Content -->
        <div class="register">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                         <div class="span12">
                        
                                 <h1>Preference Set Up</h1>
                                 <div class="modal-body" id="signup_details" style="padding-left: 400px;">
                                    <table align="left">
                                     <tr>
	                                  <td><span style="font-weight:bold;color:black;">*Search Results per Page: </span></td>
	                                  <td><input type="text" placeholder="30 limit" name="amounts" id="result_amounts" maxlength="2" /></td>
	                                  <td align="left"><span id="result_help" class = "help"></span><br /><br /></td>
	                                 </tr>
	                                 <tr>
	                                   <td><span style="font-weight:bold;color:black;">* </span></td>
	                                   <td><input type="text" placeholder="User Name" name="name" id="signup_name" maxlength="50"/></td>
	                                   <td align="left"><span id="name_help" class = "help"></span><br /><br /> </td>
	                                 </tr>
	                             
	                                   <td></td>
		                               <td><input id="signupButton" style="float:right" type="button" class="btn btn-success"  value="Sign Up" /> </td>
	                                   <td></td>
	                               </table>
	                             </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      <!-- JavaScript -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.countdown.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>
    </body>

</html>


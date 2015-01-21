<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>People Search</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="assets/dist/css/vendor/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    <!-- Loading Flat UI -->
    <link href="assets/dist/css/flat-ui.css" rel="stylesheet">
    <link href="assets/docs/assets/css/demo.css" rel="stylesheet">

    <link rel="shortcut icon" href="img/favicon.ico">
    

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="dist/js/vendor/html5shiv.js"></script>
      <script src="dist/js/vendor/respond.min.js"></script>
    <![endif]-->
       <script type="text/javascript">
        var basePath = "<%=request.getContextPath()%>";
       </script>
  </head>
  <body>
  <jsp:include page="/jsp/navheader.jsp" flush="true"/>
    <div class="container">
      <div class="demo-headline">
        <h1 class="demo-logo">
          <div class="logo"></div>
          	<h2>Legend Enterprise HRMS</h2>
			<p>Personal Information Inquiry System</p>
         <!-- <small>Where amazing happens</small>-->
		  <div class="login-form" style="width:55%;margin-left:330px">
            <div class="form-group">
              <input type="text" name="keywords" class="form-control search-field" value="" placeholder="Enter email or name to search" id="search-name" />
            </div>
        </h1>
      </div> <!-- /demo-headline -->
	  <div class="demo-type-example" id="supportTeam">
	          <p><small><a href="#">Powered by Legend Team</a></small></p>
      		</div>
    <script src="assets/dist/js/vendor/jquery.min.js"></script>
    <script src="assets/dist/js/vendor/video.js"></script>
    <script src="assets/dist/js/flat-ui.min.js"></script>
    <script src="assets/docs/assets/js/application.js"></script>
    <script src="assets/js/custom.js"></script>

    <script>
      videojs.options.flash.swf = "assets/dist/js/vendors/video-js.swf"
    </script>
  </body>
</html>

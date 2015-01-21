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
        
               <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">
        <!--link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css" -->
        <!--link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster" -->
        <!-- link rel='stylesheet' type='text/css' 
              href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' -->
           
           
        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
       <jsp:include page="/jsp/navheader.jsp" flush="true"/>

        <!-- Coming Soon -->
        <div class="coming-soon">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="span12">
                            <h2>We're Coming Soon</h2>
                            <p>We are working very hard on the new version of our site. It will bring a lot of new features. Stay tuned!</p>
                            <div class="timer">
                                <div class="days-wrapper">
                                    <span class="days"></span> <br>days
                                </div>
                                <div class="hours-wrapper">
                                    <span class="hours"></span> <br>hours
                                </div>
                                <div class="minutes-wrapper">
                                    <span class="minutes"></span> <br>minutes
                                </div>
                                <div class="seconds-wrapper">
                                    <span class="seconds"></span> <br>seconds
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Content -->
        <div class="container">
            <div class="row">
                <div class="span12 subscribe">
                    <h3>Subscribe to our newsletter</h3>
                    <p>More Templates  Sign up now to our newsletter and you'll be one of the first to know when the site is ready:</p>
                    <form class="form-inline">
                        <input type="text" name="keywords" id="keywords" placeholder="Enter your email...">
                        <button type="submit" class="btn" id="basicSearchButton">Search</button>
                    </form>
                    <div class="success-message"></div>
                    <div class="error-message" id="error-message"></div>
                </div>
            </div>
            <div class="row">
                <div class="span12 social">
                    <a href="" class="facebook" rel="tooltip" data-placement="top" data-original-title="Facebook"></a>
                    <a href="" class="twitter" rel="tooltip" data-placement="top" data-original-title="Twitter"></a>
                    <a href="" class="dribbble" rel="tooltip" data-placement="top" data-original-title="Dribbble"></a>
                    <a href="" class="googleplus" rel="tooltip" data-placement="top" data-original-title="Google Plus"></a>
                    <a href="" class="pinterest" rel="tooltip" data-placement="top" data-original-title="Pinterest"></a>
                    <a href="" class="flickr" rel="tooltip" data-placement="top" data-original-title="Flickr"></a>
                </div>
            </div>
        </div>
       <jsp:include page="/jsp/foot.jsp" flush="true"/>
      <!-- JavaScript -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.countdown.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>

     
    </body>

</html>


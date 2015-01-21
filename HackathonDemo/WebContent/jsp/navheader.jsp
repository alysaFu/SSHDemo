<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oracle.hackson.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav navbar-right">
      <li>
        <a href="${pageContext.request.contextPath}/index.jsp" data-id="home">Home</a>
      </li>
      <% 
       if(request.getSession().getAttribute("username") != null){
      %>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome <strong>${username}</strong> <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/setup.jsp">My Preference</a></li>
          <li class="divider"></li>
          <li><a id="logoutButton">Logout</a></li>
        </ul>
      </li>
      <%}else{ %>
      <li><a style="cursor:pointer;" id="loginpopup">Login  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
      <%}%>
      <li>&nbsp;&nbsp; </li>
    </ul>
    <!-- 
    <form class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    -->
  </div><!-- /.navbar-collapse -->
</nav>
  
  <!-- Code for Login / Signup Popup -->
  <!-- Modal Log in -->
	<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden='true'>
	  <div class="modal-dialog" style="margin-top: 150px; width:30%; height:30%">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel1">Login to Alimama</h4>
	      </div>
	      
	      <div class="modal-body" id="login_details">
	        *<span style="font-weight:bold;">Your Email</span><br />
	        <input type="text" placeholder="example@oracle.com" name="email" id="email" /><br /></br>
	        *<span style="font-weight:bold;" >Password</span><br />
	        <input type="password" placeholder="Password" name="passwd" id="passwd" /><br />
	        <span id="help" class = "help"></span><br />
	      </div>
	      <div class="modal-footer" >
			<button id="loginButton" style="float: left" type="submit" class="btn btn-success" value="Log In"> Log In </button>
	      </div>
	      
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
 <!--Modal Login Ends -->

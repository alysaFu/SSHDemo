$(document).ready(function(){
    $("#loginButton").bind("click", function() {
        $.ajax({
        	url:"login",
        	type:'POST',
        	dateType: "json",   
        	data: {
            	   email : $("#email").val(),
            	   passwd : $("#passwd").val()
                  },
        	success:function(message){
        		if(message != "Welcome")
        			$('#resultInfo').html(message);
        		else
        			location.reload(true);
        		},
        	error:function(data){alert("page error!");}//////
        });
    });
    var emailValid=false;
    $("#signupButton").bind("click", function() {
    	if(!emailValid || $("#signup_re_passwd").val() != $("#signup_passwd").val()){
    		alert("There were problems creating your account.");
    		return;
    	}
        $.ajax({
        	url:"signup",
        	type:'POST',
        	data:{
        		email : $("#signup_email").val(),
         	    passwd : $("#signup_passwd").val(),
         	    name : $("#signup_name").val(),
         	    //to do
         	    gender : "M",
         	    single : "Y"
         	    //...
        	},
        	success:function(message){
        		location.replace(basePath+"/index.jsp");
        	},
        	error:function(data){alert("There were problems creating your account.");}//////
        });
    });
    $("#basicSearchButton").bind("click", function() {
        $.ajax({
        	url:"basicSearch",
        	type:'POST',
        	dateType: "json",   
        	data: {
            	   keywords : $("#keywords").val(),
                  },
        	success:function(message){
        		if(message != "Welcome")
        			$('#error').html(message);
        		else
        			location.reload(true);
        		},
        	error:function(data){alert("page error!");}//////
        });
    });
    
    $("#logoutButton").bind("click", function() {
        $.ajax({
        	url:"logout",
        	type:'POST',
        	data:{},
        	success:function(message){
        		location.reload(true);
        	},
        	error:function(data){alert("logout error!");}//////
        });
    });
    
    $("#signup_email").bind("blur", function() {
    	emailValid = false;
    	if($("#signup_email").val().indexOf("@") > 0){
    		$.ajax({
            	url:"checkEmail",
            	type:'POST',
            	data:{email : $("#signup_email").val()},
            	success:function(message){
            		$('#email_help').html(message);
            		if(message == "")
            			emailValid = true;
            	},
            	error:function(data){alert("logout error!");}
            });
    	}else{
    		$('#email_help').html("invalid format");
    	}
        
    });
    $("#signup_re_passwd").bind("blur", function() {
    	var msg="";
    	if($("#signup_re_passwd").val() != $("#signup_passwd").val()){
    		msg = "Password doesn't match the confirmation";
    	}
        $('#re_pass_help').html(msg);
    });
    
	$("#loginpopup").bind("click", function() {
		$('#login').modal('show');
	});
	
	 $('#signup-link').bind("click", function() {
	    $('#login').modal('hide');
	     $('#signup').modal('toggle');
	 });
	 $('#login-link').bind("click", function() {
	    $('#signup').modal('hide');
	     $('#login').modal('toggle');
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

	 $("#search-name2").bind('keypress',function(event){
		 if(event.keyCode == "13"){
			$.ajax({  
		        url : "basicSearch",   
		        type : "post", 
		        data:{"keywords" : $("#search-name2").val()},  
		        success : function(message){
		        	$("#resultInfo").html(message);
		        	location.replace(basePath+"/searchResult.jsp?currentPage=0");
		        },
		        error:function(data){alert("page error!");}   
		    }); 
		 }
		});
	 
	 // Boostrap Slider
	 $('.carousel').carousel();
	 
			// navigation click actions	
			$('.scroll-link').on('click', function(event){
				event.preventDefault();
				var sectionID = $(this).attr("data-id");
				scrollToID('#' + sectionID, 750);
				$('.navbar-nav li').each(function(){
					$(this).removeClass("active");
				});
				$(this).parent().addClass("active");
			});
			// scroll to top action
			$('.scroll-top').on('click', function(event) {
				event.preventDefault();
				$('html, body').animate({scrollTop:0}, 'slow'); 		
			});
			// mobile nav toggle
			$('#nav-toggle').on('click', function (event) {
				event.preventDefault();
				$('#main-nav').toggleClass("open");
			});

		// scroll function
		function scrollToID(id, speed){
			var offSet = 50;
			var targetOffset = $(id).offset().top - offSet;
			var mainNav = $('#main-nav');
			$('html,body').animate({scrollTop:targetOffset}, speed);
			if (mainNav.hasClass("open")) {
				mainNav.css("height", "1px").removeClass("in").addClass("collapse");
				mainNav.removeClass("open");
			}
		}
		if (typeof console === "undefined") {
		    console = {
		        log: function() { }
		    };
		}
	 
})


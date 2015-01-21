$("input").keydown(function(){
	alert("Enter");
	$.ajax({  
        url : "./basicSearch",   
        type : "post", 
		dataType: "html",
        data:{"keywords" : $("#search-name").val()},  
        success : function(message){
        		if(message != "Welcome")
        			$('#help').html(message);
        		else
        			location.reload(true);
        		},
        	error:function(data){alert("page error!");}   
    });  
}); 

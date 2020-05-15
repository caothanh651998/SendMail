$(document).ready(function(){
	$("#newMail").click(function(){
		// $("#form").toggle(50);
		$("#form1").toggle(50);
	});

	$("#close").click(function(){
		// $("#form").toggle(50);
		$("#form1").toggle(50);
	});

	$("#to").click(function(){
		$("#myUL").toggle(50);
	});
	// $("#wrapper").click(function(){
	// 	$("#show-mail").hide();
	// })
	$("#checkbox").click(function(){
		if($("#checkbox").is(':checked')){
			var arr =[];
			// arr.push($(".mail").text());

			$.each($("#checkbox:checked"), function(){            
                arr.push($(".mail").text());
            });

			$("#to:text").val(function(a,c){
				return c + arr.join(", ");
			});
		}else{
			$("#to").val("");
		}
		
	});

	$(".mail").click(function() {
        var text = $(this).text();
            $("#to:text").val(function(a, c) { 
                 return c + text; 
            });
	});

	$(".td").click(function() {
        var text = $(this).text();
            $("#title:text").val(function(a, c) { 
                 return c + text; 
            });
            // $("#content").val(function(a, c) { 
            //      return c + text; 
            // });
	});
	$(".td1").click(function() {
        var text = $(this).text();
            
            $("#content").val(function(a, c) { 
                 return c + text; 
            });
	});  
	
	// get data jquery java spring 
	$("select.a").change(function(){
        var doituong = $(this).children("option:selected").val();
        // console.log(doituong);
        $(".mail").remove();
        $.ajax({ url: "http://localhost:8080/khachhang?madoituong=" + $(this).children("option:selected").val() })
            .then(function (data) {
                console.log(data); 
            
            // $("#myUL").append('<li ><a href="#" class="mail">'+data[0].mail+'</a><a href="#" style="display: none;">,</a></li>');

            for (var i = 0; i < data.length; i++) {
            	var getData = data[i];
            	$("#myUL").append('<li class="mail"><a href="#" >'+getData.mail+'</a><a href="#" style="display: none;">,</a></li>');
            }
            $(".mail").click(function() {
		        var text = $(this).text();
		        console.log(text);
		        $("#to:text").val(function(a, c) { 
		        	return c + text; 
		        });

			});
        });
    });
	
	
});

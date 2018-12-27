<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.maphilight.min.js"></script>
    <script type="text/javascript">

     $(function() {
     		$('.map').maphilight({fade: false});
     });

  $().ready(function () {
        //EITHER USE A GLOBAL VAR OR PLACE VAR IN HIDDEN FIELD
        //IF FOR WHATEVER REASON YOU WANT TO STOP POLLING
        pollServer();

        $('.s21').on("click", function(e){
                e.preventDefault();
                alert("onclick");
        });
    });



    var isActive = true;

    function pollServer()
        {
            if (isActive)
            {
                window.setTimeout(function () {
                    $.ajax({
                        url: "/light/status",
                        type: "GET",
                        success: function (result) {
                            //SUCCESS LOGIC
                            //alert(result);
                            highlightSeat(result);
                            pollServer();
                        },
                        error: function () {
                            //ERROR HANDLING
                            pollServer();
                        }});
                }, 2500);
            }
        }

     function highlightSeat(result){
        $('#s21').mouseout();
        if(result == "S21"){
            $('#s21').mouseover();
         }
     }

	</script>

</head>
<body>


	<div class="container">

		<img class="map" src="images/787-8a.png" width="924" height="264" usemap="#787">
		<map name="787">
            <area id="s21"  class="s21" target="" alt="" title="21" href="" coords="636,98,651,113" shape="rect">
        </map>
	</div>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
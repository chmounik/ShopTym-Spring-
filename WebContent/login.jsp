<!DOCTYPE HTML>
<html>
<head>
<title>ShopTym</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });
                        
            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });
                        
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
     </script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- end menu -->
<!-- top scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>
<body>

	<%
		if(request.getSession() != null) {
			request.getSession().removeAttribute("userEmail") ;
			request.getSession().removeAttribute("userType") ;
		}
	%>
	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt="" /></a>
			</div>
			<div class="cssmenu">
				<ul>
					<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
					<jsp:include page="menu.jsp" />
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="wrap">
			<!-- start header menu -->
			<ul class="megamenu skyblue">
				<li><a class="color1" href="${contextPath}/commonUser/index">Home</a></li>
				<li class="grid"><a class="color2" href="#">Electronics &
						Computers</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4 class="top">Electronics</h4>
									<ul>
										<li><a href="shop.html">TV & Video</a></li>
										<li><a href="shop.html">Cell Phones & Accessories</a></li>
										<li><a href="shop.html">Wearable Technology</a></li>
										<li><a href="shop.html">Headphones</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4 class="top">Computers</h4>
									<ul>
										<li><a href="shop.html">Computers & Tablets</a></li>
										<li><a href="shop.html">Monitors</a></li>
										<li><a href="shop.html">Accessories</a></li>
										<li><a href="shop.html">Drives & Storage</a></li>
									</ul>
								</div>
							</div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<img src="images/nav_img.jpg" alt="" />
						</div>
					</div></li>
				<li class="active grid"><a class="color4" href="#">Clothing</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Men</h4>
									<ul>
										<li><a href="shop.html">Shirts</a></li>
										<li><a href="shop.html">Jackets & Coats</a></li>
										<li><a href="shop.html">Jeans</a></li>
										<li><a href="shop.html">Shorts</a></li>
										<li><a href="shop.html">Sweaters</a></li>
										<li><a href="shop.html">Pants</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Women</h4>
									<ul>
										<li><a href="shop.html">Dresses</a></li>
										<li><a href="shop.html">Tops & Tees</a></li>
										<li><a href="shop.html">Sweaters</a></li>
										<li><a href="shop.html">Jeans</a></li>
										<li><a href="shop.html">Pants</a></li>
										<li><a href="shop.html">Skirts</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Kids</h4>
									<ul>
										<li><a href="shop.html">Pants</a></li>
										<li><a href="shop.html">Jeans</a></li>
										<li><a href="shop.html">Sweaters</a></li>
										<li><a href="shop.html">Shorts</a></li>
										<li><a href="shop.html">Shirts</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<img src="images/nav_img1.jpg" alt="" />
								</div>
							</div>
						</div>
					</div></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<div class="login">
		<div class="wrap">
			<div class="col_1_of_login span_1_of_login">
				<h4 class="title">New Customers</h4>
				<h5 class="sub_title">Register Account</h5>
				<p>Welcome to ShopTym. Our motto is 'Save Time, Save Money'.
					Have a wonderful shopping experience.</p>
				<div class="button1">
					<a href="${contextPath}/commonUser/register"><input type="submit" name="Submit"
						value="Continue"></a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
					<h4 class="title">Registered Customers</h4>
					<div class="comments-area">
						<form action="./login.htm">
							<p>
								<label>Name</label> <span>*</span> <input type="text"
									name="userName">
							</p>
							<p>
								<label>Password</label> <span>*</span> <input type="password"
									name="password">
							</p>
							<p>
								<label>User Type</label>&nbsp; &nbsp; <select name="userType">
									<option value="customer">Customer</option>
									<option value="seller">Seller</option>
								</select>
							</p>
							<p id="login-form-remember">
								<label><a href="${contextPath}/forgotPassword/jsp">Forgot Your
										Password ? </a></label>
							</p>
							<p>
								<input type="submit" value="Login">
							</p>
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="footer">

		<!--This code is for footer-->
		<!-- 	<div class="copy">
       	
       	   <div class="wrap">
       	   	  <p>© All rights reserved | ShopTym</p>
       	   </div>
       	 </div>
  	-->

	</div>


	<script>

        document.getElementById("onsubmit").onclick = function() {f1()};

       function f1()

       {

           var countryValue = document.getElementById('userName').value;



    if (countryValue == "") 

    {
            alert("Please enter Username");

        return false;

    }

    var stateValue = document.getElementById('password').value;

    if (stateValue == "") 

    {

            alert("Please enter Password");

        return false;

    }

    var UserType = document.getElementById('UserType').value;

    if (UserType == "") 

    {

            alert("Please enter UserType");

        return false;

    }

}      
    </script>
	<script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
	<a href="#" id="toTop" style="display: block;"><span
		id="toTopHover" style="opacity: 1;"></span></a>
</body>
</html>

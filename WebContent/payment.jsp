<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>ShopTym</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/form.css" />" rel="stylesheet" type="text/css" media="all" />
<link href='<c:url value="/http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" />' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="<c:url value="/resources/jquery.min.js"/>" ></script>
<script src="<c:url value="/resources/jquery.easydropdown.js"/>" ></script>
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
<link href="<c:url value="/resources/megamenu.css"/>" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value="/resources/megamenu.js"/>"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- end menu -->
<script type="text/javascript" src="<c:url value="/resources/jquery.jscrollpane.min.js"/>"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- top scrolling -->
<script type="text/javascript" src="<c:url value="/resources/move-top.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/easing.js"/>"></script>
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
  <div class="header-top">
	 <div class="wrap"> 
		<div class="logo">
			<a href="index.html"><img src="<c:url value="/resources/logo.png" />" alt="" /></a>
	    </div>
	    <div class="cssmenu">
		   <ul>
			 <ul>
					<c:set var="contextPath" value="${pageContext.request.contextPath}" />
					<jsp:include page="menu.jsp" />
		   </ul>
		</div>
		<div class="clear"></div>
 	</div>
   </div>
   <div class="header-bottom">
   	<div class="wrap">
   	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
   		<!-- start header menu -->
		<ul class="megamenu skyblue">
		    <li><a class="color1" href="#">Home</a></li>
			<li class="grid"><a class="color2" href="#">Electronics & Computers</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4 class="top">Electronics</h4>
								<ul>
									<li><a href="${contextPath}/product/productList/productFilter/TV">TV & Video</a></li>
									<li><a href="${contextPath}/product/productList/productFilter/Mobile Phone">Cell Phones & Accessories</a></li>
<!-- 									<li><a href="shop.html">Cell Phones & Accessories</a></li> -->
									<li><a href="${contextPath}/product/productList/productFilter/Wearables">Wearable Technology</a></li>
									<li><a href="${contextPath}/product/productList/productFilter/Headphones">Headphones</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4 class="top">Computers</h4>
								<ul>
									<li><a href="${contextPath}/product/productList/productFilter/Computers">Computers & Tablets</a></li>
									<li><a href="${contextPath}/product/productList/productFilter/Monitors">Monitors</a></li>
									<li><a href="${contextPath}/product/productList/productFilter/Accessories">Accessories</a></li>
									<li><a href="${contextPath}/product/productList/productFilter/Storage">Drives & Storage</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<img src="<c:url value="/resources/nav_img.jpg"/>" alt=""/>
					</div>
				</div>
				</li>
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
						   <img src="<c:url value="/resources/nav_img1.jpg"/>" alt=""/>
						 </div>
						</div>
					</div>
				</div>
    			</li>
		   </ul>
		   <div class="clear"></div>
     	</div>
       </div>
       <div class="register_account">
          	<div class="wrap">
          	<div class="col_1_of_login span_1_of_login">
    	      <h4 class="title">Payment</h4>
    	      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	      
    		   <form name="payment" action="${contextPath}/product/payment/">
    			 
    						 <p>
								<label>Credit Card Number</label>
								<span>*</span>
								<input type="text" id="cardnumber" name="cardnumber" value="">
							</p>
							<p>
								<label>CVC</label>
								<span>*</span>
								<input type="text" id="cvc" name="cvc" value="">
							</p>
							<br>
							<p>
								<label>Expiry Date</label><br/>
								<select name="expmonth" id="expmonth" style="max-width: 540px;">
  									<option value="01">Jan</option>
						            <option value="02">Feb</option>
						            <option value="03">Mar</option>
						            <option value="04">Apr</option>
						            <option value="05">May</option>
						            <option value="06">Jun</option>
						            <option value="07">Jul</option>
						            <option value="08">Aug</option>
						            <option value="09">Sep</option>
						            <option value="10">Oct</option>
						            <option value="11">Nov</option>
						            <option value="12">Dec</option>
								</select>
							</p>
							<br/><br/><br/>
							<p>
								 <select name="expyear" id="expyear" style="max-width: 540px;">
						            <option value="2016">2016</option>
						            <option value="2017">2017</option>
						            <option value="2018">2018</option>
						            <option value="2019">2019</option>
						            <option value="2020">2020</option>
						            <option value="2021">2021</option>
						            <option value="2022">2022</option>
						        </select>
							</p>
							<br/><br/><br/>
							<p>
								<label>First Name</label>
								<span>*</span>
								<input type="text" id="fname" name="fname" value="">
							</p>
							<p>
								<label>Last Name</label>
								<span>*</span>
								<input type="text" id="lname" name="lname" value="">
							</p>

							<p>
								<label>City</label>
								<span>*</span>
								<input type="text" id="city" name="city" value="">
							</p>
							<p>
								<label>State</label>
								<span>*</span>
								<input type="text" id="state" name="state" value="">
								<label>ZipCode</label><input type="text" id="zip" name="zip" value="">
							</p>
							<p>
								<label>Country</label>
								<span>*</span>
								<input type="text" id="country" name="country" value="">
							</p>
							<p>
								<label>Contact Number</label>
								<span>*</span>
								<input type="text" id="number" name="number" value="">
							</p>
							
							<p>
								<label>Billing Address</label>
								<span>*</span>
								<input type="text" id="billaddress" name="billaddress" value="">
							</p>
		   			 
		    	 <br>
		    	  
		          <div>
		         <button class="grey" id="onsubmit" type="submit">Make Payment</button>
		         </div>
		         
		         </form>
		     </div>    
		     </div>
		     </div>
		    
    	
        
        <script>

        document.getElementById("onsubmit").onclick = function() {f1()};

       function f1()

       {

           var cardnumber = document.getElementById('cardnumber').value;



    if (cardnumber == "") 

    {

            alert("Please enter Credit Card Number");

        return false;

    }

    var cvc = document.getElementById('cvc').value;

    if (cvc == "") 

    {

            alert("Please enter CVC");

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
        <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
</body>
</html>
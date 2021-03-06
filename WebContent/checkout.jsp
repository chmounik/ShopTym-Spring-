<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>ShopTym</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/styles.css" />">
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
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
		    <li><a class="color1" href="#">Home</a></li>
			<li class="grid"><a class="color2" href="#">Electronics & Computers</a>
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
       
       			<div class="wrap">

       			<br>
       			<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
       			<form action="${contextPath}/product/update/">
       			<table id="cart">
       			<thead>
				  <tr>
				    <th class="first">Product</th>
				    <th class="second">Quantity</th>
				    <th class="third">Name</th>
				    <th class="fourth">Price</th>
				    <th class="fifth">Remove Product</th>
				  </tr>
				  </thead>
				  <c:set var="sum" value="${0}" />
				  
				  <c:forEach items="${cartItems}" var="product">
				  	<c:set var="sum" value="${sum + product.quantity * product.cost}" />
       				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				  <tbody>
				  <tr class="productitm">
				    <td><img class="thumb" src="<c:url value="/myCartImage/imageDisplay?id=${product.productId}"/>" /></td>
				    <td><input name="qty" type="text" value="${product.quantity}"  class="qtyinput" ></td>
				    <td>${product.productName}</td>
				    <td>$${product.quantity * product.cost}</td>
				    <c:set var="quant" value="${product.quantity}" />
				    <td>
				    <a href="${pageContext.request.contextPath}/product/remove/${product.productId}">Remove</a>
				    </td>
				  </tr>
				  </c:forEach>
				  <tr class="extracosts">
            		<td class="light">Shipping &amp; Tax</td>
            		<td colspan="2" class="light"></td>
            		<td>$35.00</td>
            		
            		<td><div class="btn_form">

					 <input type="submit" value="Update" title="">
					 			  
				  </div></td>
          		  </tr>
          		
          		
         		 <tr class="totalprice">
           			 <td class="light">Total:</td>
            		 <td colspan="2">&nbsp;</td>
            		 <td colspan="1"><span class="thick">$${sum +35.00}</span></td>
            		 <td>&nbsp;</td>

          		</tr>
				</tbody>
				</table>
				
				
				<br>
				</form>
				<table>
				<tr>
				<td class="first">
				<div class="btn_form">
				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
       			<form action="${contextPath}/product/productList/all">
					 <input type="submit" value="Continue Shopping" title="">
				</form>	 			  
				 </div>
				 </td>
				 <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				 <td class="second"> 
				<div class="btn_form">
				
				   <form action="${contextPath}/product/paymentpage/">
				  
					 <input type="submit" value="Pay" title="">
					 
					 
				  </form>
				  
				</div>
				</td>
				</tr>
    			</table>
                
			</div>
			<br>
		<div class="footer">
       	   <div class="footer-top">
       		<div class="wrap">
       			   <div class="col_1_of_footer-top span_1_of_footer-top">
				  	 <ul class="f_list">
				  	 	<li><img src="<c:url value="/resources/f_icon.png"/>" alt=""/><span class="delivery">Free delivery on all orders over $50*</span></li>
				  	 </ul>
				   </div>
				   <div class="col_1_of_footer-top span_1_of_footer-top">
				  	<ul class="f_list">
				  	 	<li><img src="<c:url value="/resources/f_icon1.png"/>" alt=""/><span class="delivery">Customer Service :<span class="orange"> (800)-SHOPTYM (freephone)</span></span></li>
				  	 </ul>
				   </div>
				   <div class="col_1_of_footer-top span_1_of_footer-top">
				  	<ul class="f_list">
				  	 	<li><img src="<c:url value="/resources/f_icon2.png"/>" alt=""/><span class="delivery">Fast delivery & free returns</span></li>
				  	 </ul>
				   </div>
				  <div class="clear"></div>
			 </div>
			 </div>
       	    </div>
       	    <div class="footer-middle">
       	 	  <div class="wrap">
       	 		<div class="section group">
				<div class="col_1_of_middle span_1_of_middle">
					<dl id="sample" class="dropdown">
			        <dt><a href="#"><span>Please Select a Country</span></a></dt>
			        <dd>
			            <ul>
			                <li><a href="#">Australia<img class="flag" src="<c:url value="/resources/as.png"/>" alt="" /><span class="value">AS</span></a></li>
			                <li><a href="#">Sri Lanka<img class="flag" src="<c:url value="/resources/srl.png"/>" alt="" /><span class="value">SL</span></a></li>
			                <li><a href="#">Newzealand<img class="flag" src="<c:url value="/resources/nz.png"/>" alt="" /><span class="value">NZ</span></a></li>
			                <li><a href="#">Pakistan<img class="flag" src="<c:url value="/resources/pk.png"/>" alt="" /><span class="value">Pk</span></a></li>
			                <li><a href="#">United Kingdom<img class="flag" src="<c:url value="/resources/uk.png"/>" alt="" /><span class="value">UK</span></a></li>
			                <li><a href="#">United States<img class="flag" src="<c:url value="/resources/us.png"/>" alt="" /><span class="value">US</span></a></li>
			            </ul>
			         </dd>
   				    </dl>
   				 </div>
				<div class="col_1_of_middle span_1_of_middle">
					<ul class="f_list1">
						<li><span class="m_8">Sign up for email and Get 15% off</span>
						<div class="search">	  
							<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
							<input type="submit" value="Subscribe" id="submit" name="submit">
							<div id="response"> </div>
			 			</div><div class="clear"></div>
			 		    </li>
					</ul>
				</div>
				<div class="clear"></div>
			   </div>
       	 	</div>
       	 </div>
       	 <div class="copy">
       	   <div class="wrap">
       	   	  <p>� All rights reserved</p>
       	   </div>
       	 </div>
       </div>
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
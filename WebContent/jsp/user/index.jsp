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
	$(document).ready(
			function() {
				$(".dropdown img.flag").addClass("flagvisibility");

				$(".dropdown dt a").click(function() {
					$(".dropdown dd ul").toggle();
				});

				$(".dropdown dd ul li a").click(
						function() {
							var text = $(this).html();
							$(".dropdown dt a span").html(text);
							$(".dropdown dd ul").hide();
							$("#result").html(
									"Selected value is: "
											+ getSelectedValue("sample"));
						});

				function getSelectedValue(id) {
					return $("#" + id).find("dt a span.value").html();
				}

				$(document).bind('click', function(e) {
					var $clicked = $(e.target);
					if (!$clicked.parents().hasClass("dropdown"))
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
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- end menu -->
<!-- top scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1200);
		});
	});
</script>
</head>
<body>
	<%!boolean isLoggedIn = false;
	String userType = "";
	String userEmail = "";
	String list1 = "";
	String list2 = "";%>
	<%
		if (session!= null && session.getAttribute("userEmail") != null && !session.getAttribute("userEmail").toString().equals("")) {
			isLoggedIn = true ;
			userEmail = session.getAttribute("userEmail").toString();
		}
		
		if (session!= null && session.getAttribute("userType") != null) {
			userType = session.getAttribute("userType").toString();
		}

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Expires", "0");
		response.setDateHeader("Expires", -1);
		
		if(isLoggedIn) {
			list1 = "<li class=\"active\"><a href=\"checkout.html\">Checkout</a></li>";
			list2 = " <li><a href= \"/logOut\">Log out</a></li>";
		}
		else {
			list1 = "<li class=\"active\"><a href=\"register\">Sign up</a></li>";
			list2 = "<li><a href=\"login\">My Account</a></li>";
		}
		
	%>
	<%=isLoggedIn %>
	<%=userEmail %>
	<%=userType %>
	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt="" /></a>
			</div>
			<div class="cssmenu">
				<ul>
					<%=list1%>
					<%=list2%>
					<jsp:include page="menu.jsp"/>
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
				<li class="grid"><a class="color2" href="#">Electronics and
						Computers</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4 class="top">Electronics</h4>
									<ul>
										<li><a href="shop.html">TV and Video</a></li>
										<li><a href="shop.html">Cell Phones and Accessories</a></li>
										<li><a href="shop.html">Wearable Technology</a></li>
										<li><a href="shop.html">Headphones</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4 class="top">Computers</h4>
									<ul>
										<li><a href="shop.html">Computers and Tablets</a></li>
										<li><a href="shop.html">Monitors</a></li>
										<li><a href="shop.html">Accessories</a></li>
										<li><a href="shop.html">Drives and Storage</a></li>
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
										<li><a href="shop.html">Jackets and Coats</a></li>
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
										<li><a href="shop.html">Tops and Tees</a></li>
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
	<div class="index-banner">
		<div class="wmuSlider example1" style="height: 560px;">
			<div class="wmuSliderWrapper">
				<article style="position: relative; width: 100%; opacity: 1;">
					<div class="banner-wrap">
						<div class="slider-left">
							<img src="images/banner1.jpg" alt="" />
						</div>
						<div class="slider-right">
							<h2>Samsung</h2>
							<h3>S7 Edge</h3>
							<p>4GB RAM|32GB Storage</p>
							<div class="btn">
								<a href="shop.html">Shop Now</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</article>
				<article style="position: absolute; width: 100%; opacity: 0;">
					<div class="banner-wrap">
						<div class="slider-left">
							<img src="images/banner2.jpg" alt="" />
						</div>
						<div class="slider-right">
							<h2>Apple</h2>
							<h3>MacBook Air</h3>
							<p>7th Gen i5|256GB SSD|13.3 inch</p>
							<div class="btn">
								<a href="shop.html">Shop Now</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</article>
				<article style="position: absolute; width: 100%; opacity: 0;">
					<div class="banner-wrap">
						<div class="slider-left">
							<img src="images/banner3.jpg" alt="" />
						</div>
						<div class="slider-right">
							<h2>LeVI'S</h2>
							<h3>Deer Faux Leather Hooded Trucker</h3>
							<p>Full Sherpa Lining</p>
							<div class="btn">
								<a href="shop.html">Shop Now</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</article>
			</div>
			<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
			<ul class="wmuSliderPagination">
				<li><a href="#" class="">0</a></li>
				<li><a href="#" class="">1</a></li>
				<li><a href="#" class="wmuActive">2</a></li>
			</ul>
			<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
			<ul class="wmuSliderPagination">
				<li><a href="#" class="wmuActive">0</a></li>
				<li><a href="#" class="">1</a></li>
				<li><a href="#" class="">2</a></li>
			</ul>
		</div>
		<script src="js/jquery.wmuSlider.js"></script>
		<script type="text/javascript" src="js/modernizr.custom.min.js"></script>
		<script>
			$('.example1').wmuSlider();
		</script>
	</div>
	<div class="main">
		<div class="wrap">
			<div class="content-top">
				<div class="lsidebar span_1_of_c1">
					<p>Social Media</p>
				</div>
				<div class="cont span_2_of_c1">
					<div class="social">
						<ul>
							<li class="facebook"><a href="#"><span> </span></a>
								<div class="radius">
									<img src="images/radius.png"><a href="#"> </a>
								</div>
								<div class="border hide">
									<p class="num">1.51K</p>
								</div></li>
						</ul>
					</div>
					<div class="social">
						<ul>
							<li class="twitter"><a href="#"><span> </span></a>
								<div class="radius">
									<img src="images/radius.png">
								</div>
								<div class="border hide">
									<p class="num">1.51K</p>
								</div></li>
						</ul>
					</div>
					<div class="social">
						<ul>
							<li class="google"><a href="#"><span> </span></a>
								<div class="radius">
									<img src="images/radius.png">
								</div>
								<div class="border hide">
									<p class="num">1.51K</p>
								</div></li>
						</ul>
					</div>
					<div class="social">
						<ul>
							<li class="dot"><a href="#"><span> </span></a>
								<div class="radius">
									<img src="images/radius.png">
								</div>
								<div class="border hide">
									<p class="num">1.51K</p>
								</div></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="content-bottom">
				<div class="box1">
					<div class="col_1_of_3 span_1_of_3">
						<a href="single.html">
							<div class="view view-fifth">
								<div class="top_box">
									<h3 class="m_1">Lee Cooper T-Shirt</h3>
									<p class="m_2">Printed Tees</p>
									<div class="grid_img">
										<div class="css3">
											<img src="images/pic.jpg" alt="" />
										</div>
										<div class="mask">
											<div class="info">Quick View</div>
										</div>
									</div>
									<div class="price">$15</div>
								</div>
							</div> <span class="rating"> <input type="radio"
								class="rating-input" id="rating-input-1-5" name="rating-input-1">
								<label for="rating-input-1-5" class="rating-star1"></label> <input
								type="radio" class="rating-input" id="rating-input-1-4"
								name="rating-input-1"> <label for="rating-input-1-4"
								class="rating-star1"></label> <input type="radio"
								class="rating-input" id="rating-input-1-3" name="rating-input-1">
								<label for="rating-input-1-3" class="rating-star1"></label> <input
								type="radio" class="rating-input" id="rating-input-1-2"
								name="rating-input-1"> <label for="rating-input-1-2"
								class="rating-star"></label> <input type="radio"
								class="rating-input" id="rating-input-1-1" name="rating-input-1">
								<label for="rating-input-1-1" class="rating-star"></label>&nbsp;
								(45)
						</span>
							<ul class="list">
								<li><img src="images/plus.png" alt="" />
									<ul class="icon1 sub-icon1 profile_img">
										<li><a class="active-icon c1" href="#">Add To Cart</a>
											<ul class="sub-icon1 list">
												<li><h3>Add to Shopping Cart</h3> <a href=""></a></li>
											</ul></li>
									</ul></li>
							</ul>
							<div class="clear"></div>
						</a>
					</div>
					<div class="col_1_of_3 span_1_of_3">
						<a href="single.html">
							<div class="view view-fifth">
								<div class="top_box">
									<h3 class="m_1">Tommy Hilfigher</h3>
									<p class="m_2">Womens Maroon dress</p>
									<div class="grid_img">
										<div class="css3">
											<img src="images/pic1.jpg" alt="" />
										</div>
										<div class="mask">
											<div class="info">Quick View</div>
										</div>
									</div>
									<div class="price">$25</div>
								</div>
							</div> <span class="rating"> <input type="radio"
								class="rating-input" id="rating-input-1-5" name="rating-input-1">
								<label for="rating-input-1-5" class="rating-star1"></label> <input
								type="radio" class="rating-input" id="rating-input-1-4"
								name="rating-input-1"> <label for="rating-input-1-4"
								class="rating-star1"></label> <input type="radio"
								class="rating-input" id="rating-input-1-3" name="rating-input-1">
								<label for="rating-input-1-3" class="rating-star1"></label> <input
								type="radio" class="rating-input" id="rating-input-1-2"
								name="rating-input-1"> <label for="rating-input-1-2"
								class="rating-star"></label> <input type="radio"
								class="rating-input" id="rating-input-1-1" name="rating-input-1">
								<label for="rating-input-1-1" class="rating-star"></label>&nbsp;
								(45)
						</span>
							<ul class="list">
								<li><img src="images/plus.png" alt="" />
									<ul class="icon1 sub-icon1 profile_img">
										<li><a class="active-icon c1" href="#">Add To Cart</a>
											<ul class="sub-icon1 list">
												<li><h3>Add to Shopping Cart</h3> <a href=""></a></li>
											</ul></li>
									</ul></li>
							</ul>
							<div class="clear"></div>
						</a>
					</div>
					<div class="col_1_of_3 span_1_of_3">
						<a href="single.html">
							<div class="view view-fifth">
								<div class="top_box">
									<h3 class="m_1">Microsoft Surface Book</h3>
									<p class="m_2">i5 processor|256GB SSD</p>
									<div class="grid_img">
										<div class="css3">
											<img src="images/pic2.jpg" alt="" />
										</div>
										<div class="mask">
											<div class="info">Quick View</div>
										</div>
									</div>
									<div class="price">$799</div>
								</div>
							</div> <span class="rating"> <input type="radio"
								class="rating-input" id="rating-input-1-5" name="rating-input-1">
								<label for="rating-input-1-5" class="rating-star1"></label> <input
								type="radio" class="rating-input" id="rating-input-1-4"
								name="rating-input-1"> <label for="rating-input-1-4"
								class="rating-star1"></label> <input type="radio"
								class="rating-input" id="rating-input-1-3" name="rating-input-1">
								<label for="rating-input-1-3" class="rating-star1"></label> <input
								type="radio" class="rating-input" id="rating-input-1-2"
								name="rating-input-1"> <label for="rating-input-1-2"
								class="rating-star"></label> <input type="radio"
								class="rating-input" id="rating-input-1-1" name="rating-input-1">
								<label for="rating-input-1-1" class="rating-star"></label>&nbsp;
								(45)
						</span>
							<ul class="list">
								<li><img src="images/plus.png" alt="" />
									<ul class="icon1 sub-icon1 profile_img">
										<li><a class="active-icon c1" href="#">Add To Cart</a>
											<ul class="sub-icon1 list">
												<li><h3>Add to Shopping Cart</h3> <a href=""></a></li>
											</ul></li>
									</ul></li>
							</ul>
							<div class="clear"></div>
						</a>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="footer">
		<div class="footer-top">
			<div class="wrap">
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="images/f_icon.png" alt="" /><span
							class="delivery">Free delivery on all orders over $50*</span></li>
					</ul>
				</div>
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="images/f_icon1.png" alt="" /><span
							class="delivery">Customer Service :<span class="orange">
									(800)-SHOPTYM (freephone)</span></span></li>
					</ul>
				</div>
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="images/f_icon2.png" alt="" /><span
							class="delivery">Fast delivery and free returns</span></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="footer-middle">
			<div class="wrap">
				<div class="section group">
					<div class="col_1_of_middle span_1_of_middle">
						<dl id="sample" class="dropdown">
							<dt>
								<a href="#"><span>Please Select a Country</span></a>
							</dt>
							<dd>
								<ul>
									<li><a href="#">Australia<img class="flag"
											src="images/as.png" alt="" /><span class="value">AS</span></a></li>
									<li><a href="#">Sri Lanka<img class="flag"
											src="images/srl.png" alt="" /><span class="value">SL</span></a></li>
									<li><a href="#">Newzealand<img class="flag"
											src="images/nz.png" alt="" /><span class="value">NZ</span></a></li>
									<li><a href="#">Pakistan<img class="flag"
											src="images/pk.png" alt="" /><span class="value">Pk</span></a></li>
									<li><a href="#">United Kingdom<img class="flag"
											src="images/uk.png" alt="" /><span class="value">UK</span></a></li>
									<li><a href="#">United States<img class="flag"
											src="images/us.png" alt="" /><span class="value">US</span></a></li>
								</ul>
							</dd>
						</dl>
					</div>
					<div class="col_1_of_middle span_1_of_middle">
						<ul class="f_list1">
							<li><span class="m_8">Sign up for email and Get 15%
									off</span>
								<div class="search">
									<input type="text" name="s" class="textbox" value="Search"
										onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Search';}">
									<input type="submit" value="Subscribe" id="submit"
										name="submit">
									<div id="response"></div>
								</div>
								<div class="clear"></div></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<div class="copy">
			<div class="wrap">
				<p>© All rights reserved</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {

			var defaults = {
				containerID : 'toTop', // fading element id
				containerHoverID : 'toTopHover', // fading element hover id
				scrollSpeed : 1200,
				easingType : 'linear'
			};

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop" style="display: block;"><span
		id="toTopHover" style="opacity: 1;"></span></a>
</body>
</html>
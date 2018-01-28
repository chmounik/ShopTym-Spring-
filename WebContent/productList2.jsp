<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>ShopTym</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css" media="all" />
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"
	type="text/css" media="all" />
<link
	href='<c:url value="/http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" />'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<c:url value="/resources/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/jquery.easydropdown.js"/>"></script>
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
<link href="<c:url value="/resources/megamenu.css"/>" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/megamenu.js"/>"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- end menu -->
<script type="text/javascript"
	src="<c:url value="/resources/jquery.jscrollpane.min.js"/>"></script>
<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- top scrolling -->
<script type="text/javascript"
	src="<c:url value="/resources/move-top.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/easing.js"/>"></script>
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
				<a href="index.html"><img
					src="<c:url value="/resources/logo.png" />" alt="" /></a>
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
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
										<li><a
											href="${contextPath}/product/productList/SMARTPHONES">Cell
												Phones & Accessories</a></li>
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
							<img src="<c:url value="/resources/nav_img.jpg"/>" alt="" />
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
									<img src="<c:url value="/resources/nav_img1.jpg"/>" alt="" />
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
			<div class="rsidebar span_1_of_left">
				<section class="sky-form">
					<h4>Occasion</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Athletic (20)</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Athletic Shoes (48)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Casual
								(45)</label> <label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Casual (45)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other
								(1)</label>
						</div>
					</div>
					<h4>Category</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Flats (70)</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Athletic Shoes (48)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Athletic
								Shoes (48)</label> <label class="checkbox"><input
								type="checkbox" name="checkbox"><i></i>Heels (38)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other
								(1)</label>
						</div>
					</div>
					<h4>Styles</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Athletic (20)</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Ballerina (5)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Pumps
								(7)</label> <label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>High Tops (2)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other
								(1)</label>
						</div>
					</div>
				</section>
				<section class="sky-form">
					<h4>Brand</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Adidas by Stella
								McCartney</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Asics</label> <label class="checkbox"><input
								type="checkbox" name="checkbox"><i></i>Bloch</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Bloch
								Kids</label> <label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Capezio</label> <label class="checkbox"><input
								type="checkbox" name="checkbox"><i></i>Capezio Kids</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Nike</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Zumba</label>
						</div>
					</div>
				</section>
				<section class="sky-form">
					<h4>Heel Height</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Flat (20)</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Under 1in(5)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>1in
								- 1 3/4 in(5)</label> <label class="checkbox"><input
								type="checkbox" name="checkbox"><i></i>2in - 2 3/4 in(3)</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>3in - 3 3/4 in(2)</label>
						</div>
					</div>
				</section>
				<section class="sky-form">
					<h4>Price</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>$50.00 and Under (30)</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>$100.00 and Under (30)</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>$200.00
								and Under (30)</label> <label class="checkbox"><input
								type="checkbox" name="checkbox"><i></i>$300.00 and Under
								(30)</label> <label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>$400.00 and Under (30)</label>
						</div>
					</div>
				</section>
				<section class="sky-form">
					<h4>Colors</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Red</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Green</label> <label class="checkbox"><input
								type="checkbox" name="checkbox"><i></i>Black</label> <label
								class="checkbox"><input type="checkbox" name="checkbox"><i></i>Yellow</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox"><i></i>Orange</label>
						</div>
					</div>
				</section>
			</div>
			<div class="cont span_2_of_3">
				<div class="mens-toolbar">
					<div class="sort">
						<div class="sort-by">
							<label>Sort By</label> <select>
								<option value="">Popularity</option>
								<option value="">Price : High to Low</option>
								<option value="">Price : Low to High</option>
							</select> <a href=""><img src="<c:url value="/resources/arrow2.gif"/>"
								alt="" class="v-middle"></a>
						</div>
					</div>
					<div class="pager">
						<div class="limiter visible-desktop">
							<label>Show</label> <select>
								<option value="" selected="selected">9</option>
								<option value="">15</option>
								<option value="">30</option>
							</select> per page
						</div>
						<ul class="dc_pagination dc_paginationA dc_paginationA06">
							<li><a href="#" class="previous">Pages</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
				<c:forEach items="${products}" var="product">
					<div class="box1">

						<div class="col_1_of_single1 span_1_of_single1">
							<a href="${contextPath}/product/viewProduct/${product.productId}">
								<div class="view1 view-fifth1">
									<div class="top_box">
										<h3 class="m_1">${product.productName}</h3>
										<p class="m_2">${product.productDescription}</p>
										<div class="grid_img">
											<div class="css3">
												<img
													src="<c:url value="/myImage/imageDisplay?id=${product.productId}"/>">
											</div>
											<div class="mask1">
												<div class="info">Quick View</div>
											</div>
										</div>
										<div class="price">$ ${product.productCost}</div>
									</div>
								</div> <span class="rating1"> <input type="radio"
									class="rating-input" id="rating-input-1-5"
									name="rating-input-1"> <label for="rating-input-1-5"
									class="rating-star1"></label> <input type="radio"
									class="rating-input" id="rating-input-1-4"
									name="rating-input-1"> <label for="rating-input-1-4"
									class="rating-star1"></label> <input type="radio"
									class="rating-input" id="rating-input-1-3"
									name="rating-input-1"> <label for="rating-input-1-3"
									class="rating-star1"></label> <input type="radio"
									class="rating-input" id="rating-input-1-2"
									name="rating-input-1"> <label for="rating-input-1-2"
									class="rating-star"></label> <input type="radio"
									class="rating-input" id="rating-input-1-1"
									name="rating-input-1"> <label for="rating-input-1-1"
									class="rating-star"></label>&nbsp; (45)
							</span>
								<ul class="list2">
									<li><img src="<c:url value="/resources/plus.png"/>" alt="" />
										<ul class="icon1 sub-icon1 profile_img">
											<li><a class="active-icon c1" href="#">Add To Bag </a>
												<ul class="sub-icon1 list">
													<li><h3>Buy Now</h3>
														<a href=""></a></li>
												</ul></li>
										</ul></li>
								</ul>
								<div class="clear"></div>
							</a>
						</div>
						<div class="clear"></div>
					</div>
				</c:forEach>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="footer">
		<div class="footer-top">
			<div class="wrap">
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="<c:url value="/resources/f_icon.png"/>" alt="" /><span
							class="delivery">Free delivery on all orders over $50*</span></li>
					</ul>
				</div>
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="<c:url value="/resources/f_icon1.png"/>" alt="" /><span
							class="delivery">Customer Service :<span class="orange">
									(800)-SHOPTYM (freephone)</span></span></li>
					</ul>
				</div>
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="<c:url value="/resources/f_icon2.png"/>" alt="" /><span
							class="delivery">Fast delivery & free returns</span></li>
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
						<dt>
							<a href="#"><span>Please Select a Country</span></a>
						</dt>
						<dd>
							<ul>
								<li><a href="#">Australia<img class="flag"
										src="<c:url value="/resources/as.png"/>" alt="" /><span
										class="value">AS</span></a></li>
								<li><a href="#">Sri Lanka<img class="flag"
										src="<c:url value="/resources/srl.png"/>" alt="" /><span
										class="value">SL</span></a></li>
								<li><a href="#">Newzealand<img class="flag"
										src="<c:url value="/resources/nz.png"/>" alt="" /><span
										class="value">NZ</span></a></li>
								<li><a href="#">Pakistan<img class="flag"
										src="<c:url value="/resources/pk.png"/>" alt="" /><span
										class="value">Pk</span></a></li>
								<li><a href="#">United Kingdom<img class="flag"
										src="<c:url value="/resources/uk.png"/>" alt="" /><span
										class="value">UK</span></a></li>
								<li><a href="#">United States<img class="flag"
										src="<c:url value="/resources/us.png"/>" alt="" /><span
										class="value">US</span></a></li>
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
								<input type="submit" value="Subscribe" id="submit" name="submit">
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
	<a href="#" id="toTop" style="display: block;"><span
		id="toTopHover" style="opacity: 1;"></span></a>
</body>
</html>
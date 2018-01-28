<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.beans.Feature"%>

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
<link rel="stylesheet"
	href='<c:url value="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"/>'>
<link
	href='<c:url value="/http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" />'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="<c:url value="/resources/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/jquery.easydropdown.js"/>"></script>
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
<link href="<c:url value="/resources/megamenu.css"/>" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/megamenu.js"/>"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- end menu -->
<script type="text/javascript"
	src="<c:url value="/resources/jquery.jscrollpane.min.js"/>"></script>
<script type="text/javascript" id="sourcecode">
	$(function() {
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

	<%
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Expires", "0");
		response.setDateHeader("Expires", -1);
	%>

	<%!
		ArrayList<String> brandsFromSession;
		String productCategoryFromSession;
		ArrayList<Feature> featuresFromSession;
	%>

	<%

		if (session.getAttribute("brandsFromSession") != null) {
			//out.write("Session working");
			brandsFromSession = (ArrayList<String>) session.getAttribute("brandsFromSession");
		}
	
		if (session.getAttribute("productCategoryFromSession") != null) {
			//out.write("Session working");
			productCategoryFromSession = (String) session.getAttribute("productCategoryFromSession");
		}

		if (session.getAttribute("featuresFromSession") != null) {
			//out.write("Session working");
			featuresFromSession = (ArrayList<Feature>) session.getAttribute("featuresFromSession");
		}
	%>
	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="${pageContext.request.contextPath}"><img
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
	<div class="header-bottom">
		<div class="wrap">
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<!-- start header menu -->
			<ul class="megamenu skyblue">
				<li><a class="color1"
					href="${contextPath}/product/productList/all">Home</a></li>
				<li class="grid"><a class="color2" href="#">Electronics and
						Computers</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4 class="top">Electronics</h4>
									<ul>
										<li><a
											href="${contextPath}/product/productList/productFilter/TV">TV
												and Video</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/SMARTPHONES">Cell
												Phones and Accessories</a></li>
										<!-- 									<li><a href="shop.html">Cell Phones and Accessories</a></li> -->
										<li><a
											href="${contextPath}/product/productList/productFilter/Wearables">Wearable
												Technology</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/Headphones">Headphones</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4 class="top">Computers</h4>
									<ul>
										<li><a
											href="${contextPath}/product/productList/productFilter/Computers">Computers
												and Tablets</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/Monitors">Monitors</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/Accessories">Accessories</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/Storage">Drives
												and Storage</a></li>
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
										<li><a
											href="${contextPath}/product/productList/productFilter/MENSHIRTS">Shirts</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/MENJACKETS">Jackets
												and Coats</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/MENJEANS">Jeans</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/MENSHORTS">Shorts</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/MENSWEATERS">Sweaters</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/MENPANTS">Pants</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Women</h4>
									<ul>
										<li><a
											href="${contextPath}/product/productList/productFilter/WOMENDRESS">Dresses</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/WOMENTOPS">Tops
												and Tees</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/WOMENSWEATERS">Sweaters</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/WOMENJEANS">Jeans</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/WOMENPANTS">Pants</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/WOMENSKIRTS">Skirts</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Kids</h4>
									<ul>
										<li><a
											href="${contextPath}/product/productList/productFilter/KIDPANTS">Pants</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/KIDJEANS">Jeans</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/KIDSWEATERS">Sweaters</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/KIDSHORTS">Shorts</a></li>
										<li><a
											href="${contextPath}/product/productList/productFilter/KIDSHIRTS">Shirts</a></li>
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
				<form name="filterProductsForm"
					action="${contextPath}/product/productList/filterProducts"
					method="post">
					<input type="hidden" name="productCategoryForFilter" value="${productCategoryFromSession}">
					<section class="sky-form">
						<h4>Brands</h4>
						<c:forEach items="${brandsFromSession}" var="brand">
							<label class="checkbox"> <input type="checkbox"
								name="brands" value="${brand}" /> <i></i>${brand}
							</label>
						</c:forEach>
						<c:forEach items="${featuresFromSession}" var="feature">
							<h4>${feature.getFeatureName()}</h4>
							<c:forEach items="${feature.getFeatureValues()}" var="value">
								<label class="checkbox"> <input type="checkbox"
									name="${feature.getFeatureID()}" value="${value}" /> <i></i>${value}</label>
							</c:forEach>
						</c:forEach>
						<input type="submit" value="Filter Products" />
					</section>
				</form>

			</div>
			<div class="cont span_2_of_3">
				<div class="labout span_1_of_a1">
					<!-- start product_slider -->
					<ul id="etalage">
						<li><a href="#"> <img
								class="etalage_thumb_image"
								src="<c:url value="/myImage/imageDisplay?id=${product.productId}"/>" />
								<!-- 									<img class="etalage_source_image" src="images/t2.jpg" /> -->
						</a></li>
						<!-- 							<li> -->
						<!-- 								<img class="etalage_thumb_image" src="images/t2.jpg" /> -->
						<!-- 								<img class="etalage_source_image" src="images/t2.jpg" /> -->
						<!-- 							</li> -->
						<!-- 							<li> -->
						<!-- 								<img class="etalage_thumb_image" src="images/t3.jpg" /> -->
						<!-- 								<img class="etalage_source_image" src="images/t3.jpg" /> -->
						<!-- 							</li> -->
						<!-- 							<li> -->
						<!-- 								<img class="etalage_thumb_image" src="images/t4.jpg" /> -->
						<!-- 								<img class="etalage_source_image" src="images/t4.jpg" /> -->
						<!-- 							</li> -->
						<!-- 							<li> -->
						<!-- 								<img class="etalage_thumb_image" src="images/t5.jpg" /> -->
						<!-- 								<img class="etalage_source_image" src="images/t5.jpg" /> -->
						<!-- 							</li> -->
						<!-- 							<li> -->
						<!-- 								<img class="etalage_thumb_image" src="images/t6.jpg" /> -->
						<!-- 								<img class="etalage_source_image" src="images/t6.jpg" /> -->
						<!-- 							</li> -->
						<!-- 							<li> -->
						<!-- 								<img class="etalage_thumb_image" src="images/t1.jpg" /> -->
						<!-- 								<img class="etalage_source_image" src="images/t1.jpg" /> -->
						<!-- 							</li> -->
					</ul>


					<!-- end product_slider -->
				</div>
				<div class="cont1 span_2_of_a1">
					<c:choose>
						<c:when test="${grantEditPermission}">

							<div class="register_account">
								<div class="wrap">
									<h4>${message}</h4>
									<h4 class="title">Modify Product &nbsp;
									<a href="${contextPath}/product/deleteProduct?productID=${product.productId}">Delete Product</a>
									</h4>
									<c:set var="contextPath" value="${pageContext.request.contextPath}" />
									<form name="modifyProduct" method="post" action="${contextPath}/product/modifyProduct">
										<input type="hidden" name="productID" value="${product.productId}"/>
										<div class="col_1_of_2 span_1_of_2">

											<div>
												<label>Product Name</label>
												<span>*</span>
												<input type="text" name="productName" value="${product.productName}">
											</div>
											<div>
												<label>Price</label>
												<span>*</span>
												<input type="text" name="productPrice" value="${product.productCost}">
											</div>
											<div>
												<label>Quantity</label>
												<span>*</span>
												<input type="text" name="productQuantity" value="${product.productQuantity}">
											</div>
											<div>
												<textarea rows="4" cols="31" name="productDescription">${product.productDescription}</textarea>
											</div>
											<div>
												<button class="grey" id="onsubmit">Submit</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div>
							</div>
						</c:when>

						<c:otherwise>
							<h3 class="m_3">${product.productName}</h3>

							<div class="price_single">
								<span>$ ${product.productCost}</span>
							</div>
						<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<div class="btn_form">
				
				   <form action="${contextPath}/product/checkout/${product.productId}">
				  
					 <input type="submit" value="buy now" title="">
					 
					 
				  </form>
				  
				</div>
							
							<p class="m_desc">${product.productDescription}</p>

							<div class="social_single">
								<ul>
									<li class="fb"><a href="#"><span> </span></a></li>
									<li class="tw"><a href="#"><span> </span></a></li>
									<li class="g_plus"><a href="#"><span> </span></a></li>
									<li class="rss"><a href="#"><span> </span></a></li>
								</ul>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="clear"></div>
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />

				<c:if test="${! grantEditPermission}">
					<ul id="flexiselDemo3">
						<c:forEach items="${recommendedProducts}" var="Product">
							<li><img
								src="<c:url value="/myImage/imageDisplay?id=${Product.productId}"/>" />
								<div class="grid-flex">
									<a
										href="${contextPath}/product/viewProduct/${product.productId}">${Product.productName}</a>
									<p>$ ${Product.productCost}</p>
								</div></li>
							<%-- 			<li><img src="<c:url value="/resources/pic10.jpg"/>"/><div class="grid-flex"><a href="#">Capzio</a><p>Rs 850</p></div></li> --%>
							<%-- 			<li><img src="<c:url value="/resources/pic9.jpg"/>"/><div class="grid-flex"><a href="#">Zumba</a><p>Rs 850</p></div></li> --%>
							<%-- 			<li><img src="<c:url value="/resources/pic8.jpg"/>"/><div class="grid-flex"><a href="#">Bloch</a><p>Rs 850</p></div></li> --%>
							<%-- 			<li><img src="<c:url value="/resources/pic7.jpg"/>"/><div class="grid-flex"><a href="#">Capzio</a><p>Rs 850</p></div></li> --%>
						</c:forEach>
					</ul>
				</c:if>

				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo1").flexisel();
						$("#flexiselDemo2").flexisel({
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 1
								},
								landscape : {
									changePoint : 640,
									visibleItems : 2
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
								}
							}
						});

						$("#flexiselDemo3").flexisel({
							visibleItems : 5,
							animationSpeed : 1000,
							autoPlay : true,
							autoPlaySpeed : 3000,
							pauseOnHover : true,
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 1
								},
								landscape : {
									changePoint : 640,
									visibleItems : 2
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
								}
							}
						});

					});
				</script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/resources/jquery.flexisel.js"></script>
				<div class="toogle">
					<c:choose>
						<c:when test="${grantEditPermission}">
							
						</c:when>
						<c:otherwise>
							<h3 class="m_3">Product Description</h3>
							<c:forEach items="${descriptionFeatureList}"
								var="descriptionFeature">
								<p class="m_text">
									<c:out value="${descriptionFeature.featureID}" />
									:
									<c:out value="${descriptionFeature.featureName}" />
								</p>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
				<c:if test="${not empty flagreviewadd}">
					<div class="btn_form">
						<form
							action="${contextPath}/product/writeReview/${product.productId}">
							<input name="review" type="text" /> <input type="submit" value="Submit" title="">
						</form>
					</div>
				</c:if>
				<div class="toogle">
					<h3 class="m_3">Product Reviews</h3>
					<c:forEach items="${reviewList}" var="Review">
						<p class="m_text">
							<tr>
								<td><b>User: <c:out value="${Review.costumerId}" /></b></td>
							</tr>
						</p>
						<p class="m_text">
							<tr>
								<td>Review: <c:out value="${Review.review}" /></td>
						</p>
						<c:if test="${not empty Review.reviewReply.reviewReplyString}">
							<p class="m_text">
								<tr>
									<td>Reply: <c:out
											value="${Review.reviewReply.reviewReplyString}" /></td>
								</tr>
							</p>
						</c:if>
						<c:if test="${not empty flag}">
							<c:if test="${empty Review.reviewReply.reviewReplyString}">
								<p>
								<form action="${contextPath}/product/writeReviewReply/${Review.reviewId}">
									<input name="reply" type="text" /> <input name="productId"
										type="hidden" value="${product.productId}" /> <input
										type="submit" value="post reply" />
								</form>
								</p>
							</c:if>
						</c:if>
					</c:forEach>
				</div>
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
							class="delivery">Free delivery on all orders over £100*</span></li>
					</ul>
				</div>
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="<c:url value="/resources/f_icon1.png"/>" alt="" /><span
							class="delivery">Customer Service :<span class="orange">
									(800) 000-2587 (freephone)</span></span></li>
					</ul>
				</div>
				<div class="col_1_of_footer-top span_1_of_footer-top">
					<ul class="f_list">
						<li><img src="<c:url value="resources/f_icon2.png"/>" alt="" /><span
							class="delivery">Fast delivery & free returns</span></li>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.beans.Feature"%>
<%@ page import="com.st.beans.Product"%>
<%@ page import="com.beans.ProductCategoryIDMap"%>

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
	<!-- FoRM -->
	<div class="register_account">

		<div class="wrap">

			<h4 class="title">ADD PRODUCT</h4>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<form name="addproduct" method="post"
				action="${contextPath}/addproduct/add">

				<div class="col_1_of_2 span_1_of_2">

					<div>
						<label>Product Name</label><span>*</span><input type="text"
							id="productname" name="productname" value="">
					</div>
					<div>
						<label>Product Description</label>
						<input type="text" id="word" name="productdescription" value="">
					</div>
					<div>
						<select id="productCategory" name="productCategory" style="max-width: 587px;">
							<option value="">Select Product Category</option>
							<c:forEach var="productCategory" items="${productCategories}">
								<option value="${productCategory.getProductCategoryID()}">${productCategory.getCategoryName()}</option>
							</c:forEach>
						</select>
					</div>
					<br><br><br>
					<div>
						<label>Brand</label>
						<input type="text" id="productBrand" name="productBrand" value="">
					</div>
					<div>
						<label>Product Quantity</label>
						<span>*</span>
						<input type="text" id="word" name="productquantity" value="">
					</div>
					<div>
						<label>Product price</label>
						<span>*</span>
						<input type="text" id="productprice" name="productprice" value="">
					</div>

					<div>
						<button class="grey" id="onsubmit">Submit</button>
					</div>
				</div>
			</form>

		</div>

	</div>
	<!-- Script -->


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
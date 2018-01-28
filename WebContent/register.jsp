<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.beans.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
				<li><a class="color1" href="${contextPath}/commonUser/index">Home</a></li>
				<li class="grid"><a class="color2"
					href="${contextPath}/product/productList/all">Electronics and
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
									<img src="<c:url value="/resources/nav_img1.jpg"/>" alt="" />
								</div>
							</div>
						</div>
					</div></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<div class="register_account">

		<div class="wrap">

			<h4 class="title">Create an Account</h4>

			<form name="register"
				action="<%=request.getContextPath()%>/RegistrationServlet"
				method="post">

				<input type="hidden" name="action" value="register"></input>

				<div class="col_1_of_2 span_1_of_2">

					<div>
						<label>First Name</label><input type="text" id="fName"
							name="firstName" value="">
					</div>

					<div>
						<label>Last Name</label><input type="text" id="lName"
							name="LastName" value="">
					</div>

					<div>
						<label>Email</label><input type="text" id="mail" name="E-mail"
							value="">
					</div>

					<div>
						<label>Password</label><input type="text" id="word"
							name="password" value="">
					</div>

				</div>

				<div class="col_1_of_2 span_1_of_2">

					<div>
						<label>Gender</label><input type="text" name="gender" value="">
					</div>

					<div>
						<label>country</label><select id="country" name="country"
							onchange="change_country(this.value)" class="frm-field required">

							<option value="null">Select a Country</option>

							<option value="AX">Åland Islands</option>

							<option value="SN">Senegal</option>

						</select>
					</div>

					<div>
						<label>city</label><input type="text" value="">
					</div>

					<label>Phone number</label> <input type="text" name="phone number"
						value="">

					<div>

						<button class="grey" id="onsubmit">Submit</button>

						<p class="terms">
							By clicking 'Create Account' you agree to the <a href="#">Terms
								&amp; Conditions</a>.
						</p>

					</div>

				</div>

			</form>

		</div>

	</div>



	<script>
		document.getElementById("onsubmit").onclick = function() {
			f1()
		};

		function f1()

		{

			var firstName = document.getElementById('fName').value;

			if (firstName == "")

			{

				alert("Please enter FirstName");

				return false;

			}

			var LastName = document.getElementById('lName').value;

			if (LastName == "")

			{

				alert("Please enter LastName");

				return false;

			}

			var Email = document.getElementById('mail').value;

			if (Email == "")

			{

				alert("Please enter E-mail");

				return false;

			}

			var password = document.getElementById('word').value;

			if (password == "")

			{

				alert("Please enter password");

				return false;

			}

		}
	</script>


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
		document.getElementById("onsubmit").onclick = function() {
			f1()
		};
		function f1() {
			var countryValue = document.getElementById('email').value;
			if (countryValue == "") {
				alert("Please enter Email");
				return false;
			}

			var stateValue = document.getElementById('password').value;
			if (stateValue == "") {
				alert("Please enter Password");
				return false;
			}

			var UserType = document.getElementById('UserType').value;
			if (UserType == "") {
				alert("Please enter UserType");
				return false;
			}
		}
	</script>

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
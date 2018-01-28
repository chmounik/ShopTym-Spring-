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
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    text-align: center;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 8px;
    padding-bottom: 8px;
    text-align: center;
    background-color: #D62320;
    color: white;
}
</style>
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
					<jsp:include page="../../menu.jsp" />
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
	<c:if test="${users == null || users.size() == 0}">
		<h4>Not users found</h4>
	</c:if>
	<br/>
	<%!	ArrayList<User> users ;
		boolean isDeleted = false ;
		String email = "" ;
		String message ;
	%>
	<%
	
		if(session != null && session.getAttribute("email") != null) {
			email = session.getAttribute("email").toString() ;
			isDeleted = (boolean)session.getAttribute("isDeleted") ;
		}
		
		if(!email.equals("")) {
			if(isDeleted) {
				message = email + " deleted successfully" ;
			}
			else {
				message = email + " couldn't be deleted" ;
			}
		}
		if(session != null && session.getAttribute("email") != null) {
			out.print("<h3>" + message + "</h3>") ;
		}
	%>
	<table id="customers">
		<thead>			
			<tr>
				<th>User Email</th>
				<th>User Type</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Contact Number</th>
				<th>Is Active</th>
				<th>Is Approved</th>
				<th>Delete</th>
				<th>Approve Seller</th>
			</tr>
			<tr>
			<form name="searchUsers" action="${contextPath}/admin/getUsers" method="post">
				<th>
					<input type="text" name="userEmail" value=""/>
				</th>
				
				<th>
					<select name="userType">
						<option value="">All</option>
						<option value="CUSTOMER">Customer</option>
						<option value="SELLER">Seller</option>
						<option value="ADMIN">Admin</option>
					</select>
				</th>
				
				<th>
					<input type="text" name="firstName" value="" />
				</th>

				<th>
					<input type="text" name="lastName" value="" />
				</th>
				
				<th>
					<select name="gender" id="gender">
						<option value="">All</option>
						<option value="FEMALE">Female</option>
						<option value="MALE">Male</option>
						<option value="OTHER">Other</option>
					</select>
				</th>
				
				<th>
					<input type="text" name="contactNo" value="" />
				</th>
				
				<th>
					<select name="isActive" id="isActive">
						<option value="">All</option>
						<option value="1">True</option>
						<option value="0">False</option>
					</select>
				</th>
				
				<th>
					<select name="isApproved" id="isApproved">
						<option value="">All</option>
						<option value="1">True</option>
						<option value="0">False</option>
					</select>
				</th>
				
				<th colspan="2">
					<input type = "submit" value="Filter"/>
				</th>
			</form>
			</tr>

		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${ user.getEmail() }</td>
					<td>${ user.getUserType() }</td>
					<td>${ user.getFirstName() }</td>
					<td>${ user.getLastName() }</td>
					<td>${ user.getGender() }</td>
					<td>${ user.getContactNo() }</td>
					<td>${ user.isActive() }</td>
					<td>${ user.isApproved() }</td>
					
					<c:choose>
						<c:when test="${user.isActive() }">
							<td><a
								href="${contextPath}/admin/deleteUser?email=${ user.getEmail() }">Delete</a></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					
					<c:if test = "${user.getUserType() == 'SELLER' && ! user.isApproved() }">
						<td><a href = "${contextPath}/admin/approveSeller?email=${ user.getEmail() }">Approve</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>

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
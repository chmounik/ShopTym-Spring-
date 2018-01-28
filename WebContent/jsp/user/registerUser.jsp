<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Expires", "0");
		response.setDateHeader("Expires", -1);
	%>
	<h4>User registered</h4>
	<table>
    <tr>
        <td>First Name</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${lastName}</td>
    </tr>
        <tr>
        <td>Email</td>
        <td>${email}</td>
    </tr>
        <tr>
        <td>Password</td>
        <td>${password}</td>
    </tr>
        <tr>
        <td>User Type</td>
        <td>${userType}</td>
    </tr>
        <tr>
        <td>Gender</td>
        <td>${gender}</td>
    </tr>
        <tr>
        <td>Contact No</td>
        <td>${contactNo}</td>
    </tr>
</table>
</body>
</html>
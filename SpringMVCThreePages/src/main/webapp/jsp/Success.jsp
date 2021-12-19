<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>First Name :</td><td>${sessionScope.Personalinfo.firstname}</td>
</tr>

<tr>
<td>Last Name :</td><td>${sessionScope.Personalinfo.lastname}</td>
</tr>


<tr>
<td>Middle Name :</td><td>${sessionScope.Personalinfo.middlename}</td>
</tr>
<tr>
<td>Address city :</td><td>${sessionScope.Address.city}</td>
</tr>

<tr>
<td>Bank Name :</td><td>${user.bank}</td>
</tr>

</table>
<font color=red size=20>You have successfully registered</font>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Info Page</title>
</head>
<body>
<center><h1>Personal Info Page</h1></center>
<form:form method="post" modelAttribute="user" action="processInfo.do">
      <table>
          <tr>
              <td>First Name:</td>
              <td><form:input path="firstname" /></td>
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><form:input path="lastname" /></td>
          </tr>
          
          <tr>
              <td>Middle Name:</td>
              <td><form:input path="middlename" /></td>
          </tr>
          
          <tr>
              <td>Gender:</td>
              <td>Male<form:radiobutton path="gender" value="male" /></td>
              <td>Female<form:radiobutton path="gender" value="female" /></td>
          </tr>
          
          
          <tr>
              <td colspan="2">
                  <input type="submit" value="Save Changes" />
              </td>
          </tr>
      </table>
<% Object obj=request.getAttribute("errormsg");
			String str=null;
						if(obj!=null)
						{ str=(String)obj;
		%>
					<font color=red><%= str %></font>	
							
						<%} %>
</form:form>

</body>
</html>
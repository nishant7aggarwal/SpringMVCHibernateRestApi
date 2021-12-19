<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Now enter your Address details</h2>

<form:form method="post" modelAttribute="user" action="processAddress.do">
      <table>
          <tr>
              <td>Address:</td>
              <td><form:input path="address" /></td>
          </tr>
          <tr>
              <td>City:</td>
              <td><form:input path="city" /></td>
          </tr>
          
          <tr>
              <td>State:</td>
              <td><form:input path="state" /></td>
          </tr>
          
           <tr>
              <td>Country:</td>
              <td><form:input path="country" /></td>
          </tr>
             <tr>
              <td>Phone:</td>
              <td><form:input path="phone" /></td>
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
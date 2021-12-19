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
<h2>Now enter the Bank details</h2>

<form:form method="post" modelAttribute="user" action="processBank.do">
      <table>
          <tr>
              <td>Bank Name:</td>
              <td><form:input path="bank" /></td>
          </tr>
          <tr>
              <td>Account number:</td>
              <td><form:input path="account" /></td>
          </tr>
          
          <tr>
              <td>SSN number:</td>
              <td><form:input path="ssn" /></td>
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
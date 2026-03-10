<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="Model.User" %>
<%
User u = (User) request.getAttribute("user");
%>

<form action="UpdateUser" method="post">

<input type="hidden" name="id" value="<%=u.getUserId()%>">

Username: <input type="text" name="name" value="<%=u.getUsername()%>"><br><br>
Email: <input type="text" name="email" value="<%=u.getUserEmail()%>"><br><br>
Password: <input type="password" name="password" value="<%=u.getUserPassword()%>"><br><br>

Gender:
<input type="radio" name="gender" value="male" <%=u.getUserGender().equals("male")?"checked":""%>>Male
<input type="radio" name="gender" value="female" <%=u.getUserGender().equals("female")?"checked":""%>>Female<br><br>

State:
<select name="state">
<option <%=u.getUserState().equals("Kerala")?"selected":""%>>Kerala</option>
<option <%=u.getUserState().equals("Karnataka")?"selected":""%>>Karnataka</option>
<option <%=u.getUserState().equals("Tamil Nadu")?"selected":""%>>Tamil Nadu</option>
</select><br><br>

<input type="submit" value="Update Details">

</form>


</body>
</html>
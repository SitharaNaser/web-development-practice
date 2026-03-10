<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServletController" method="post">
Username:<input type="text" name="name"><br><br>
Email:<input type="text" name="email"><br><br>
Password:<input type="password" name="password"><br><br>

State:<select name="state">
<option value="Kerala">Kerala</option>
<option value="Karnataka">Karnataka</option>
<option value="Tamil Nadu">Tamil Nadu</option>
</select><br><br>

Gender:<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female<br><br>

<input type="submit" value="Register">

</form>
</body>
</html>
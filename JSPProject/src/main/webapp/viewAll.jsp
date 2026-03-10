<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Users</title>
</head>
<body>

<h2>All Registered Users</h2>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Gender</th>
        <th>State</th>
        <th>Action</th>
    </tr>

<%
    List<User> users = (List<User>) request.getAttribute("users");

    if (users != null) {
        for (User u : users) {
%>
    <tr>
        <td><%= u.getUserId() %></td>
        <td><%= u.getUsername() %></td>
        <td><%= u.getUserEmail() %></td>
        <td><%= u.getUserGender() %></td>
        <td><%= u.getUserState() %></td>
        <td>
            <a href="EditUser?id=<%= u.getUserId() %>">Edit</a> |
            <a href="DeleteUser?id=<%= u.getUserId() %>"
   onclick="return confirm('Are you sure you want to delete this user?');">
   Delete
</a>
            
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6">No users found</td>
    </tr>
<%
    }
%>

</table>

<br>
<a href="success.jsp">Back</a>

</body>
</html>

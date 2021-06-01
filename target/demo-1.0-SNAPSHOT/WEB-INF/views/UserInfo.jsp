<%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/4/23
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.guiyusong.model.user" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    user user = (user)session.getAttribute("user");
%>
<h1>User Info</h1>

<table border="1">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birth Date</th>
    </tr>
    <tr>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getGender()%></td>
        <td><%=user.getBrithdate()%></td>
    </tr>

</table>
<a href="updateUser">Update User</a>
<%@include file="footer.jsp"%>

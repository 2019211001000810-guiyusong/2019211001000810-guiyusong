<%@ page import="com.guiyusong.model.user" %><%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/4/12
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Info</h1>
<%
    user user=(user)request.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
        </tr><tr>
        <td>Password:</td><td><%=user.getPassword()%></td>
</tr><tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
</tr><tr>
        <td>Gender:</td><td><%=user.getGender()%></td>
</tr><tr>
        <td>Birth Date:</td><td><%=user.getBrithdate(rs.getDate("birthdate"))%></td>

    </tr>
</table>
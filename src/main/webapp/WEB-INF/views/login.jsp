<%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/4/5
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file ="header.jsp"%>
<h1>Login</h1>
<%
if (request.getRequestDispatcher("message")==null){
    out.println(request.getAttribute("message"));
}
%>
LOGIN
<form method ="post" action="Login">
    Username:<input type="text" name="username" required><br/>
    Password:<input type="password" name="password" required><br/>
    <input type="submit" name="send data to servlet"><br/>
</form>
<%@include file="footer.jsp"%>

</body>
</html>

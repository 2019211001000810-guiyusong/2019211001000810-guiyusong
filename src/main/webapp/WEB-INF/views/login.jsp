<%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/4/5
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Login2</h1>

<%
    if(!(request.getAttribute("message")==null))
        System.out.println("<h3 size=\"4\" color=\"red\">"+request.getAttribute("message")+"</h3>");
%>

<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",rememberMeVal = "";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if(c.getName().equals("rememberMeVal")){
                rememberMeVal = c.getValue();
            }
        }
    }
%>

<form  id="login" method="post" action="/login">
    <label for="username">username</label>
    <input id="username" name="username" type="text" value="<%=username%>"> <br/>

    <label for="username">password</label>
    <input id="password" name="password" type="password" value="<%=password%>"> <br/>

    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>>Remember Me<br/>

    <input class="submit" type="submit" value="login">
</form>

<%@include file="footer.jsp"%>
</body>
</html>

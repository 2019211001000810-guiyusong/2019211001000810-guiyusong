<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1><%= "Hellow word!!!" %>
</h1>
<br/>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet-week1</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">Config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC-week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login.jsp">Login-week5</a>
<br/>-->
<h2>Welcome to My Online Shop Home Page.</h2><br>
<form method="get" target="_blank" action="search">
    <input type="text " name="txt" size=30>
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
    </select>
    <input type="submit" value="Search">
</form>
<%@include file="footer.jsp"%>s
<a href="hello-servlet">Hello Servlet</a>

    <%@include file="header.jsp"%>
    <h2>Welcome to My Online Shop Home Page </h2> <br>
    <form method="get" target="_blank" action="search">
    <input type ="text" n ="txt" size=30/>
    <select n ="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>

    <input type="submit" value="Search"/>
    </form>
<%@include file="footer.jsp"%>>
<form>
    <span style="color:white;
     background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" >New User Registraintion</span><br/><br/>
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" >username</span><input type="text" name="name" required="true"/><br/><br/>
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" >password</span><input type="password" name="password" required="true" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black"><br/><br/>
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;">Email</span><input type="email" name="email" required="ture" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black"><br/><br/>
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;">Gender</span>
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;">Male</span><input type="radio">
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;">Female</span><input type="radio"><br/><br/>
    <span style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;">Date of birth(yyyy-mm-dd)</span><input type="date" pattern="yyyy-mm-dd" required="ture"  style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black"><br/><br/>
    <input type="submit" value="register" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black">
</form>
<%@include file="footer.jsp"%>
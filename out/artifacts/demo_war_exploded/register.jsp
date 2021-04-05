<%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/3/18
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<from method="post" action="/register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth :<input type="text name" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</from>

<%@include file="footer.jsp"%>
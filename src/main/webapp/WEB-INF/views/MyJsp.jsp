<%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/3/14
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="baidu.com">go to baidu</a><br/>
<from method="post"><!-what is method when we use form?--><!-- its GET ,why? default is GET-->
    <!-- its better to  use POST in fore-->
    Name :<input type="text" name="name"><br/>
    ID :<input type="text" name="id"><br/>
    PassWord :<input type="text" name="password"><br/>
    <label>性别</label>
    <c:choose>
        <c:when test="${sInfo.studentSex==77}">
            <input type="radio" name="sex" checked="checked" value="male">男
            <input type="radio" name="sex" value="female">女
        </c:when>
    </c:choose><br/>
    <input type="submit" value="Send data to server"/>

</from>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/29
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>管理员登录界面</title>
</head>
<body>
<h1>管理员登录界面</h1>
<form method="post" action="${pageContext.request.contextPath}/admin/login">
    <input type="text" name="name"><br>
    <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
<a href="${pageContext.request.contextPath}/user/goLogin">用户登录页面</a>

</body>
</html>

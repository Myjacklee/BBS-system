<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/26
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h1>登录页面</h1>
${message}
<form method="post" action="${pageContext.request.contextPath}/user/login">
    <input name="email" type="email" value="${email}"><br>
    <input name="password" type="password" value="${password}"><br>
    <input type="submit" value="登录">
</form>
<a href="${pageContext.request.contextPath}/user/goRegister">注册页面</a>
<a href="${pageContext.request.contextPath}/admin/goLogin">管理员登录页面</a>
</body>
</html>

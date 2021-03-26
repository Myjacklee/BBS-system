<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/2/26
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>查询成功页面</h1>
    <c:forEach items="${list}" var="account">
        账户id:${account.id}<span> </span>
        账户余额:${account.money}<span> </span>
        账户姓名:${account.name}<br>
    </c:forEach>
</body>
</html>

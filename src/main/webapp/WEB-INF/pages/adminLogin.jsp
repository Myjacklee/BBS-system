<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/29
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员登录界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script src="${pageContext.request.contextPath}/js/reload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="jumbotron login-top">
        <h2>管理员登录</h2>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4  ">
            <c:if test="${message!=null}">
                <div class="alert alert-danger" >${message}</div>
            </c:if>
            <form method="post" action="${pageContext.request.contextPath}/admin/login">
                <div class="form-group">
                    <label>账号</label> <input type="text" name="name" class="form-control">
                    <label>账号</label><input type="password" name="password" class="form-control"><br>
                    <input class="btn btn-primary" type="submit" value="登录">
                </div>

            </form>
            <a href="${pageContext.request.contextPath}/user/goLogin">用户登录页面</a>
        </div>
    </div>


</div>



</body>
</html>

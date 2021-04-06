<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>
        .login-top{
            background-image: url("${pageContext.request.contextPath}/images/school.jpg");
            height: 260px;
            background-repeat:no-repeat;
            background-position: center bottom	;
            background-size: cover;
        }
        .login-top h1{
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron login-top">
        <h1>校园BBS系统</h1>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4  ">
            <h1>登录</h1>
            <c:if test="${message!=null}">
                <div class="alert alert-danger" >${message}</div>
            </c:if>
            <form method="post" action="${pageContext.request.contextPath}/user/login">
                <div class="form-group">
                    <label>邮箱：</label><input name="email" type="email" value="${email}" class="form-control"><br>
                    <label>密码：</label><input name="password" type="password" value="${password}" class="form-control"><br>
                    <input type="submit" class="btn btn-primary" value="登录">
                </div>
            </form>
            <a href="${pageContext.request.contextPath}/user/goRegister">注册</a>
            <a href="${pageContext.request.contextPath}/admin/goLogin">管理员登录</a>
        </div>
    </div>


</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/26
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script>
        $(function () {
            $("#password_2").blur(function(){
                if($("#password_1").val()!=$("#password_2").val()){
                    alert("两次键入的密码不一致，请重新输入");
                    $("#password_2").val("");
                    $("#password_1").val("");
                }
            });
        });
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
            <h1>欢迎注册BBS</h1>
            <c:if test="${message}!=null">
                <div class="alert alert-danger" role="alert">${message}</div>
            </c:if>
            <form method="post" action="${pageContext.request.contextPath}/user/register">
                <div class="form-group">
                    <label>邮箱：</label> <input class="form-control" type="email" name="email"  value="${user.email}" required="required">
                    <label>姓名：</label> <input class="form-control" type="text" name="username" value="${user.username}" required="required">
                    <label>昵称：</label><input class="form-control" type="text" name="nickname"  value="${user.nickname}" required="required">
                    <label>学校：</label><input class="form-control" type="text" name="school" value="${user.school}" required="required">
                    <label>学院：</label><input class="form-control" type="text" name="college"  value="${user.college}" required="required">
                    <label>班级：</label><input class="form-control" type="text" name="studentClass" value="${user.studentClass}" required="required">
                    <label>密码：</label><input class="form-control" type="password" id="password_1"name="password" value="${user.password}" required="required">
                    <label>确认密码：</label><input class="form-control" type="password" id="password_2" name="confirmPassword" value="${user.password}" required="required"><br>
                    <input type="submit" value="确认提交" class="btn btn-primary">
                </div>
            </form>
            <a href="${pageContext.request.contextPath}/user/login">登录</a>
        </div>
    </div>
</div>


</body>
</html>

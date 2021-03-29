<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/26
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
</head>
<body>
<h1>注册页面</h1>
${message}
<form method="post" action="${pageContext.request.contextPath}/user/register">
    <input type="email" id="email" name="email" placeholder="邮箱" value="${user.email}" required="required"><br>
    <input type="text" name="username" placeholder="姓名" value="${user.username}" required="required"><br>
    <input type="text" name="nickname" placeholder="昵称" value="${user.nickname}" required="required"><br>
    <input type="text" name="school" placeholder="学校" value="${user.school}" required="required"><br>
    <input type="text" name="college" placeholder="学院" value="${user.college}" required="required"><br>
    <input type="text" name="studentClass" placeholder=班级 value="${user.studentClass}" required="required"><br>
    <input type="password" id="password_1"name="password" placeholder="密码" value="${user.password}" required="required"><br>
    <input type="password" id="password_2" name="confirmPassword" placeholder="确认密码" value="${user.password}" required="required"><br>
    <input type="submit" value="确认提交">
</form>
<a href="${pageContext.request.contextPath}/user/login"><button>登录</button></a>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/2/27
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BBS系统主界面</title>
</head>
<body>
<h1>主界面</h1>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
<h2>用户信息</h2>
<p>uid:${sessionScope.user.uid}</p>
<p>邮箱:${sessionScope.user.email}</p>
<p>姓名:${sessionScope.user.username}</p>
<p>昵称:${sessionScope.user.nickname}</p>
<p>学校:${sessionScope.user.school}</p>
<p>学院:${sessionScope.user.college}</p>
<p>班级:${sessionScope.user.studentClass}</p>
<h2>版块信息</h2>
<table>
    <thead>
    <tr>
        <td>版块id</td>
        <td>版块名称</td>
        <td>版块帖子数量</td>
        <td>版块描述</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${postList}" var="post">
        <tr>
            <td>${post.bbs_section_id}</td>
            <td><a href="${pageContext.request.contextPath}/post/${post.bbs_section_id}">${post.section_name}</a></td>
            <td>${post.post_num}</td>
            <td>${post.post_describe}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

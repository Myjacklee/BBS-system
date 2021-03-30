<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/29
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员管理界面</title>
</head>
<body>
<h1>管理员管理界面</h1>
<h2>管理员基本信息</h2>
<p>${sessionScope.admin.name}</p>
<p>${sessionScope.admin.password}</p>
<a href="${pageContext.request.contextPath}/admin/logout">注销</a>
<h2>帖子基本信息</h2>
<table>
    <thead>
    <tr>
        <th>版块id</th>
        <th>版块名称</th>
        <th>版块帖子数量</th>
        <th>版块描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${postList}" var="post">
        <tr>
            <td>${post.bbs_section_id}</td>
            <td>${post.section_name}</td>
            <td>${post.post_num}</td>
            <td>${post.post_describe}</td>
            <td><a >删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>添加版块</h3>
<form method="post" action="${pageContext.request.contextPath}/admin/addPost">
    <input type="text" name="section_name" required="required" placeholder="版块名称">
    <input type="text" name="post_describe" required="required" placeholder="版块简介">
    <input type="submit" value="提交">
</form>
</body>
</html>

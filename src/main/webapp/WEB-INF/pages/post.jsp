<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/29
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BBS系统二级界面（展示每个主题板块中的帖子列表）</title>
</head>
<body>
<h1>版块页面</h1>
<h2>当前版块信息</h2>
<p>版块ID:${post.bbs_section_id}</p>
<p>版块名称:${post.section_name}</p>
<p>版块帖子数:${post.post_num}</p>
<p>版块简介:${post.post_describe}</p>
<h2>发帖栏</h2>
<form method="post" action="${pageContext.request.contextPath}/post/add/${post.bbs_section_id}">
    帖子标题：<input type="text" name="board_title"><br>
    帖子内容：<textarea name="board_content" rows="10" cols="30"></textarea><br>
    <input type="submit" value="提交">
</form>
<h2>帖子列表</h2>
<table>
    <thead>
    <tr>
        <th>帖子id</th>
        <th>帖子标题</th>
        <th>发帖人uid</th>
        <th>发帖人昵称</th>
        <th>创建时间</th>
        <th>最后回复时间</th>
    </tr>
    </thead>
<c:forEach items="${allBoard}" var="board">
    <tbody>
    <tr>
        <td>${board.board_id}</td>
        <td><a href="${pageContext.request.contextPath}/board/${board.board_id}">${board.board_title}</a></td>
        <td>${board.uid}</td>
        <td>${board.nickname}</td>
        <td>${board.board_create_time}</td>
        <td>${board.last_reply_time}</td>
    </tr>
    </tbody>
</c:forEach>
</table>
</body>
</html>

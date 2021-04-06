<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/4
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户主页展示界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
</head>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <div class="jumbotron">
        <h2>欢迎来到${user.nickname}的个人主页</h2>
        <p>学校:${user.school}</p>
        <p>学院:${user.college}</p>
        <p>班级:${user.studentClass}</p>
        <p>账号:${user.uid}</p>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2>该用户的个人帖子</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>帖子id</td>
                    <td>所在版块</td>
                    <td>标题</td>
                    <td>回帖数量</td>
                    <td>发布时间</td>
                    <td>最后回复时间</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allBoard}" var="board">
                    <tr>
                        <td>${board.board_id}</td>
                        <td><a href="${pageContext.request.contextPath}/post/${board.bbs_section_id}">${board.section_name}</a></td>
                        <td><a href="${pageContext.request.contextPath}/board/${board.board_id}">${board.board_title}</a></td>
                        <td>${board.board_reply_num}</td>
                        <td>${board.board_create_time}</td>
                        <td>${board.last_reply_time}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>

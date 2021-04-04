<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/1
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户个人主界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/reload.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">

</head>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <%@include file="manageNavbar.jsp"%>
    <div class="row">
        <div class="col-md-12">
            <h2>个人帖子管理</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>帖子id</td>
                    <td>所在版块</td>
                    <td>标题</td>
                    <td>回帖数量</td>
                    <td>发布时间</td>
                    <td>最后回复时间</td>
                    <td>操作</td>
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
                        <td><a href="${pageContext.request.contextPath}/manage/deleteBoard/${board.board_id}">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>


</body>

</html>

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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script src="${pageContext.request.contextPath}/js/reload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        .post_title{
            padding-left: 15px;
        }

    </style>
</head>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <div class="jumbotron">
        <h2>欢迎来到校园BBS系统，校园BBS，连通你我</h2>
        <p>BBS的全称是Bulletin Board System，翻译为中文为电子公告板，注册的用户可以在本系统的各个板块畅所欲言，发表自己的想法。也可以对各个帖子进行回复</p>
        <p>您的个人账号为 ${sessionScope.user.uid} ，请牢记</p>
    </div>
    <div class="row">
        <h2 class="post_title">版块信息</h2>
        <c:forEach items="${postList}" var="post">
        <a href="${pageContext.request.contextPath}/post/${post.bbs_section_id}">
            <div class="col-md-4">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">${post.section_name} <span class="pull-right text-info">当前发帖数 ${post.post_num}</span></h3>
                    </div>
                    <div class="panel-body">
                        <td>${post.post_describe}</td>
                    </div>
                </div>
            </div>
        </a>
        </c:forEach>

    </div>
</div>
</body>
</html>

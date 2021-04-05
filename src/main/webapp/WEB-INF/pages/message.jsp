<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/5
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人消息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h2>新消息</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>发送人</th>
                    <th>消息内容</th>
                    <th>发送时间</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${newMessage}" var="message">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/home/${message.sender_uid}"  target="_blank">${message.sender_name}</a> </td>
                        <td><a href="${pageContext.request.contextPath}/${message.message_url}"  target="_blank">${message.message_content}</a> </td>
                        <td>${message.message_time}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-12">
            <h2>历史消息</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>发送人</th>
                    <th>消息内容</th>
                    <th>发送时间</th>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${historyMessage}" var="history">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/home/${history.sender_uid}" target="_blank">${history.sender_name}</a> </td>
                        <td><a href="${pageContext.request.contextPath}/${history.message_url}"  target="_blank">${history.message_content}</a> </td>
                        <td>${history.message_time}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

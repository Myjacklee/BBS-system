<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/30
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BBS系统三级页面（展示每一条帖子的详细内容）</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script src="${pageContext.request.contextPath}/js/reload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">

    <script type="text/javascript">
        $(function(){
            $("#uploadReply").click(function(){
                var input=$("#uploadReplyForm").serializeJson();
                var inputString=JSON.stringify(input);
                $.ajax({
                    url:"${pageContext.request.contextPath}/reply/add/${board.board_id}",
                    contentType:"application/json;charset=UTF-8",
                    type:"post",
                    data:inputString,
                    dateType:"json",
                    success:function(data){
                        if(data.message=="success"){
                            alert("回帖成功");
                            window.location.href="${pageContext.request.contextPath}/board/${board.board_id}/#"+data.floor;
                        }else{
                            alert("回帖失败，请重新尝试");
                        }
                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                })
            });
        });
    </script>
</head>
<%@include file="navbar.jsp"%>
<body>
<h1>该页面展示每条帖子的详细信息</h1>
<h2>帖子信息</h2>
<p>帖子id：${board.board_id}</p>
<p>帖子所在模块id：${board.bbs_section_id}</p>
<p>最新回复时间：${board.last_reply_time}</p>
<p>创建时间${board.board_create_time}</p>
<p>帖子标题：${board.board_title}</p>
<p>帖子内容：${board.board_content}</p>
<p>创建帖子的用户昵称：${board.nickname}</p>
<h2>回帖栏</h2>
<form id="uploadReplyForm" >
    <textarea cols="30" rows="10" name="reply_content"></textarea>
</form>
<button id="uploadReply">回复</button>

<h2>回帖楼层</h2>
<table>
    <thead>
    <tr>
        <td>当前楼层</td>
        <td>层主昵称</td>
        <td>回帖内容</td>
        <td>回帖时间</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allReply}" var="reply" >
        <tr id="${reply.floor}">
            <td height="100px">${reply.floor}</td>
            <td height="100px">${reply.nickname}</td>
            <td height="100px">${reply.reply_content}</td>
            <td height="100px">${reply.reply_time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

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
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script src="${pageContext.request.contextPath}/js/reload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <style>
        #uploadBoardForm label{
            font-size: 16px;
        }
        textarea{
            resize: none;
        }
    </style>
    <script type="text/javascript">
            function deleteBoard(boardId){
                $.ajax({
                    url:"${pageContext.request.contextPath}/board/adminDeleteBoard/${post.bbs_section_id}/"+boardId,
                    contentType:"application/json;charset=UTF-8",
                    type:"POST",
                    dateType:"json",
                    success:function(data){

                        if(data=="1"){
                            alert("删除成功");
                            location.reload();
                        }else if(data=="0"){
                            alert("删除失败");
                        }else{
                            alert("无权限访问");
                        }
                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                });
            }
            $(function(){
            $("#uploadBoard").click(function(){
                //提取表单中的数据转化为json对象
                var input=$("#uploadBoardForm").serializeJson();
                //将json对象转化为字符串
                var inputString=JSON.stringify(input);

                $.ajax({
                    url:"${pageContext.request.contextPath}/board/add/${post.bbs_section_id}",
                    contentType:"application/json;charset=UTF-8",
                    type:"POST",
                    data:inputString,
                    dateType:"json",
                    success:function(data){

                        if(data=="success"){
                            alert("发帖成功");
                            location.reload();
                        }else if(data="title_too_long"){
                            alert("标题太长，请控制在50个字符以内");
                        }else if(data="content_too_long"){
                            alert("内容太长，请控制在200个字符以内");
                        }else{
                            alert("发帖失败");
                        }
                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                });
            });
            $(".board_title").change(function(){
                if($(".board_title").val().length>50){
                    alert("输入的标题的字符长度不能大于50，当前字符长度"+$(".board_title").val().length);
                }
            });
                $(".board_content").change(function(){
                    if($(".board_content").val().length>200){
                        alert("输入的内容字符长度不能大于200,当前字符长度"+$(".board_content").val().length);
                    }
                });

        });
    </script>
</head>
<%@include file="navbar.jsp"%>

<body>
<div class="container">
    <div class="jumbotron">
        <h2>${post.section_name}</h2>
        <p>${post.post_describe}</p>
        <p>版块帖子数:${post.post_num}</p>
        <p>版主:<c:if test="${post.adminUid==null}">暂未设置</c:if> <a href="${pageContext.request.contextPath}/home/${post.adminUid}">${post.adminNickname}</a></p>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2>帖子列表</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>帖子id</th>
                    <th>帖子标题</th>
                    <th>发帖人uid</th>
                    <th>发帖人昵称</th>
                    <th>回帖数</th>
                    <th>创建时间</th>
                    <th>最后回复时间</th>
                    <c:if test="${sessionScope.uid eq post.adminUid}"><th>操作</th></c:if>
                </tr>
                </thead>
                <c:forEach items="${allBoard}" var="board">
                    <tbody>
                    <tr>
                        <td>${board.board_id}</td>
                        <td><a href="${pageContext.request.contextPath}/board/${board.board_id}">${board.board_title}</a></td>
                        <td>${board.uid}</td>
                        <td>${board.nickname}</td>
                        <td>${board.board_reply_num}</td>
                        <td>${board.board_create_time}</td>
                        <td>${board.last_reply_time}</td>
                        <c:if test="${sessionScope.uid eq post.adminUid}"><td><button onclick="deleteBoard(${board.board_id})" class="btn btn-danger" >删除</button></td></c:if>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2>发帖栏</h2>
            <div class="form-group">
                <form id="uploadBoardForm">
                    <label>帖子标题</label><input type="text" name="board_title" class="board_title form-control" autocomplete="off"><br>
                    <label>帖子内容</label><textarea name="board_content" rows="10" cols="30" class="board_content form-control" autocomplete="off"></textarea><br>
                </form>
                <button  id="uploadBoard" class="btn btn-default">提交</button>
            </div>

        </div>
    </div>
</div>


</body>
</html>

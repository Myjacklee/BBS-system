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
    <style>
        .board_num{
            padding-right: 0;
        }
        .user_home{
            padding-left: 0;
        }
        .text-center img{
            width:150px;
            height: 150px;
        }
        .board{
            border: 2px solid #eeeeee;

        }
        .board_owner_information{
            border-right: 2px solid #eeeeee;
        }
        .board .board_owner_information,.board .board_content{
            padding: 20px;
        }

        .reply_content{
            padding-bottom: 20px;
        }
        textarea{
            resize: none;
        }
    </style>
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
                            window.location.reload();
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
<div class="container">
    <h2>帖子标题：${board.board_title}</h2>
    <div class="row board">
        <div class="col-md-3 text-center board_owner_information">
            <img src="${pageContext.request.contextPath}/images/chatHead.jpg" class="img-thumbnail" alt="头像">
            <h3>${board.nickname}</h3>
            <div class="row">
                <div class="col-md-6 board_num">
                    <p><span class="glyphicon glyphicon-pencil"></span> 发帖数：99+</p>
                </div>
                <div class="col-md-6 user_home">
                    <a href="${pageContext.request.contextPath}/home/${board.uid}"><p><span class="glyphicon glyphicon-home"></span> 个人主页</p></a>
                </div>
            </div>
        </div>
        <div class="col-md-9 board_content">
            <div class="row">
                <div class="col-md-12 reply_content">
                    <p>${board.board_content}</p>
                </div>
            </div>
            <hr>
            <div class="row reply_time">
                <div class="col-md-12">
                    <p class=" text-right ">发表于 ${board.board_create_time}</p>
                </div>
            </div>
        </div>
    </div>
    <h2>回复</h2>
    <c:forEach items="${allReply}" var="reply" >
        <tr id="${reply.floor}">
            <div class="row board" id="${reply.floor}">
                <div class="col-md-3 text-center board_owner_information">
                    <img src="${pageContext.request.contextPath}/images/chatHead.jpg" class="img-thumbnail" alt="头像">
                    <h3>${reply.nickname}</h3>
                    <div class="row">
                        <div class="col-md-6 board_num">
                            <p><span class="glyphicon glyphicon-pencil"></span> 发帖数：99+</p>
                        </div>
                        <div class="col-md-6 user_home">
                            <a href="${pageContext.request.contextPath}/home/${reply.uid}"><p><span class="glyphicon glyphicon-home"></span> 个人主页</p></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-9 board_content">
                    <div class="row">
                        <div class="col-md-12 reply_content">
                            <p>${reply.reply_content}</p>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-6">
                            <p class="text-left ">${reply.floor} 楼</p>
                        </div>
                        <div class="col-md-6">
                            <p class=" text-right ">发表于 ${reply.reply_time}</p>
                        </div>
                    </div>
                </div>
            </div>
        </tr>
    </c:forEach>
    <div class="row">
        <div class="col-md-12">
            <h2>回帖栏</h2>
            <div class="form-group">
                <form id="uploadReplyForm">
                    <label>回帖内容</label><textarea name="reply_content" rows="10" cols="30" class="form-control" autocomplete="off"></textarea><br>
                </form>
                <button  id="uploadReply" class="btn btn-default">提交</button>
            </div>

        </div>
    </div>
</div>

</body>
</html>

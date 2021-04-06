<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/2
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>好友模块界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <style>
        tbody>tr>td{
            display: table-cell;
            vertical-align: middle !important;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("#searchButton").click(function(){
                var input=$("#findFriendForm").serializeJson();
                var inputString=JSON.stringify(input);
                $.ajax({
                    url:"${pageContext.request.contextPath}/friend/findFriend",
                    contentType:"application/json;charset=UTF-8",
                    type:"post",
                    data:inputString,
                    dateType:"json",
                    success:function(data){
                        $("#result").empty();
                        if(data.length==0){
                            alert("没有搜索结果");
                        }else{
                            alert("搜索成功");
                            for(var i in data){
                                $("#result").append('<tr><td>'+data[i].uid+'</td><td><a href=${pageContext.request.contextPath}/home/'+data[i].uid+'>'+data[i].nickname+'</a></td><td><button class="btn btn-info" name='+data[i].uid+' id=addFriend>添加好友</button></td></tr>')
                            }
                        }

                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                })
            });
            $("body").on("click","#addFriend",function(){
                var uid=$("#addFriend").attr("name");
                $.ajax({
                    url:"${pageContext.request.contextPath}/friend/addFriend/"+uid,
                    contentType:"application/json;charset=UTF-8",
                    type:"post",
                    dateType:"json",
                    success:function(data){
                        if(data=="success"){
                            alert("请求添加好友成功，等待回应");
                        }else if(data=="reject"){
                            alert("无法添加自己为好友");
                        }else if(data=="contain"){
                            alert("你与该用户已是好友关系");
                        }else{
                            alert("请求失败");
                        }
                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                })
            });
            $("body").on("click","#agree",function(){
                var uid=$("#agree").attr("name");
                $.ajax({
                    url:"${pageContext.request.contextPath}/friend/response/"+uid+"/1",
                    contentType:"application/json;charset=UTF-8",
                    type:"post",
                    dateType:"json",
                    success:function(data){
                        if(data=="success"){
                            alert("回复成功");
                            window.location.reload();
                        }else{
                            alert("请求非法");
                        }
                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                })
            });
            $("body").on("click","#reject",function(){
                var uid=$("#reject").attr("name");
                $.ajax({
                    url:"${pageContext.request.contextPath}/friend/response/"+uid+"/2",
                    contentType:"application/json;charset=UTF-8",
                    type:"post",
                    dateType:"json",
                    success:function(data){
                        if(data=="success"){
                            alert("回复成功");
                            window.location.reload();
                        }else{
                            alert("请求非法");
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
    <div class="row">
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <h2>好友列表</h2>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>昵称</th>
                            <th>主页</th>
                        </tr>
                        </thead>
                        <tbody id="allFriends">
                        <c:forEach items="${allFriends}" var="friend">
                            <tr>
                                <th>${friend.uid}</th>
                                <th>${friend.nickname}</th>
                                <th><a href="${pageContext.request.contextPath}/home/${friend.uid}">主页</a></th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>


            </div>

        </div>
        <div class="col-md-4">
            <div class="row">
                <div class="col-md-12">
                    <h2>好友添加</h2>
                    <div class="form-group">
                        <form id="findFriendForm" >
                            请输入要搜索的好友的账号：<input type="text" name="uid" class="form-control"/>
                        </form>
                    </div>

                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="result">

                        </tbody>
                    </table>
                    <button id="searchButton" class="btn btn-primary">搜索</button>
                </div>
                <div class="col-md-12">
                    <h2>请求列表</h2>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>昵称</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="friendRequest">
                            <c:forEach items="${allRequest}" var="request">
                                <tr>
                                    <td>${request.uid}</td>
                                    <td>${request.nickname}</td>
                                    <td><a href= "${pageContext.request.contextPath}/friend/response/${request.md5_code}/${request.request_id}/1/${request.uid}"><button type="button" class="btn btn-sm btn-success">同意</button></a> <a href= "${pageContext.request.contextPath}/friend/response/${request.md5_code}/${request.request_id}/2/${request.uid}"><button type="button" class="btn btn-sm btn-danger">拒绝</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>
</div>




</body>
</html>

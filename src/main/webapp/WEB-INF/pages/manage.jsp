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
    <script type="text/javascript">
        window.onload=function(){
            var today=new Date();
            var time1=Date.parse("${userInformation.sign_date}");
            var time2=Date.parse(today.toString());
            var dayCount = Math.round((Math.abs(time2 - time1))/1000/60/60/24);
            $("#comeDay").text(dayCount);
        }
        $(function(){
            $("#uploadInformation").click(function(){
                if($("#new_password").val()==$("#confirm_new_password").val()){
                    var input=$("#userInformation").serializeJson();
                    var inputString=JSON.stringify(input);
                    $.ajax({
                        url:"${pageContext.request.contextPath}/manage/updateUser",
                        contentType:"application/json;charset=UTF-8",
                        type:"post",
                        data:inputString,
                        dateType:"json",
                        success:function(data){
                            if(data=="success"){
                                alert("更新用户信息成功");
                                window.location.reload();
                            }else if(data=="notEqual"){
                                alert("旧密码不正确");
                            }else{
                                alert("更新失败，请重试");
                            }
                        },
                        error: function(XMLHttpRequest){
                            alert( "Error: " + XMLHttpRequest.responseText);
                        }
                    });
                }else{
                    alert("两次键入的新密码不一致");
                }
            });

        });


    </script>
</head>
<body>
<h1>用户个人主界面（用户管理个人的帖子和个人信息</h1>
<h2>欢迎${userInformation.nickname}，你加入BBS已经<span id="comeDay"></span>天了，很高兴与你相伴！</h2>
<h2>个人信息更改</h2>
<form id="userInformation">
    登录邮箱：<input type="text" value="${userInformation.email}" disabled="disabled" name="email"/><br>
    旧登录密码（更改用户信息必填项）：<input type="password" name="password"/><br>
    新登录密码：<input type="password" id="new_password" name="new_password"/><br>
    确认新登录密码：<input type="password" id="confirm_new_password" name="confirm_new_password"/><br>
    学校：<input type="text" value="${userInformation.school}" name="school" /><br>
    学院：<input type="text" value="${userInformation.college}" name="college"/><br>
    班级：<input type="text" value="${userInformation.studentClass}" name="studentClass" /><br>
    用户姓名：<input type="text" value="${userInformation.username}" name="username"/><br>
    用户昵称：<input type="text" value="${userInformation.nickname}" name="nickname"/><br>
</form>
<button id="uploadInformation">确认更改</button>
<h2>个人帖子管理</h2>
<table>
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
</body>

</html>

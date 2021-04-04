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
    <script type="text/javascript">

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
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <%@include file="manageNavbar.jsp"%>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <h2>个人信息更改</h2>
            <form id="userInformation">
                <div class="form-group">
                    <label>登录邮箱</label><input class="form-control" type="text" value="${userInformation.email}" disabled="disabled" name="email"/>
                    <label>旧登录密码（更改用户信息必填项）</label><input class="form-control" type="password" name="password"/>
                    <label>新登录密码</label><input class="form-control" type="password" id="new_password" name="new_password"/>
                    <label>确认新登录密码</label><input class="form-control" type="password" id="confirm_new_password" name="confirm_new_password"/>
                    <label>学校</label><input class="form-control" type="text" value="${userInformation.school}" name="school" />
                    <label>学院</label><input class="form-control" type="text" value="${userInformation.college}" name="college"/>
                    <label>班级</label><input class="form-control" type="text" value="${userInformation.studentClass}" name="studentClass" />
                    <label>用户姓名</label><input class="form-control" type="text" value="${userInformation.username}" name="username"/>
                    <label>用户昵称</label><input class="form-control" type="text" value="${userInformation.nickname}" name="nickname"/>
                </div>

            </form>
            <button id="uploadInformation" class="btn btn-primary">确认更改</button>
        </div>

    </div>

</div>


</body>

</html>

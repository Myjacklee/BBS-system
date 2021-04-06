<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/4
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <style>
        .badge{
            background-color: red;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home/index">校园BBS系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/user/logout"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> 注销</a></li>
                <li>  <a href="${pageContext.request.contextPath}/message" aria-hidden="true"><span class="glyphicon glyphicon-bell" aria-hidden="true"></span> 消息中心 <span id="message_info" class="badge"></span> </a></li>
                <li><a href="${pageContext.request.contextPath}/friend/goFriend"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 好友</a></li>
                <li><a href="${pageContext.request.contextPath}/manage/home"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 个人中心</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
<script type="text/javascript">
    $(document).ready(function(){
        var errorTime=0;
        var interval= window.setInterval(function(){getMessage();if(errorTime>10){clearInterval(interval);}},5000);
        function getMessage(){
            $.ajax({
                url:"${pageContext.request.contextPath}/message/getMessage",
                contentType:"application/json;charset=UTF-8",
                type:"post",
                dateType:"json",
                success:function(data){
                    if(data!=0){
                        $("#message_info").show();
                        $("#message_info").text(data);
                    }else{
                        $("#message_info").hide();
                    }
                },
                error:function(){
                    return errorTime+=1;
                }
            });
        }
    });



</script>
</html>
<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/2/26
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.0.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function(){
                $.ajax({
                    url:"user/register",
                    contentType:"application/json;charset=utf-8",
                    type:"post",
                    data:'{"email":"1273202743@qq.com","password":"lizonggen","username":"lufeng","nickname":"joker","school":"南京信息工程大学","college":"计算机与软件学院","studentClass":"17网工1班"}',
                    dataType:"json",
                    success:function(data){
                        alert(data.res);
                    }
                });
            });
        });
    </script>
</head>
<body>

<form action="account/save" method="post">
    <input type="text" name="name"/>
    <input type="number" name="money"/>
    <input type="submit" value="提交"/>
</form>
<button id="btn">点击我测试</button>
<a href="user/goLogin">点击我跳转到登录界面</a>
</body>
</html>

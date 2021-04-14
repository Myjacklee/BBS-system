<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/29
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员管理界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/serializeJson.js"></script>
    <script src="${pageContext.request.contextPath}/js/reload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <style>
        textarea{
            resize: none;
        }
    </style>
    <script type="text/javascript">
        function setPostAdmin(postId){
            var uid=window.prompt("请输入该管理员的uid");
            if(uid!=null&&uid!=""){
                var input={"uid":uid,"postId":postId};
                var inputString=JSON.stringify(input);
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/setPostAdmin",
                    contentType:"application/json;charset=UTF-8",
                    type:"POST",
                    data:inputString,
                    dateType:"json",
                    success:function(data){
                        if(data=="success"){
                            alert("设置成功");

                        }else if(data=="contain"){
                            alert("已将该该用户设置为版块管理员");
                        }else{
                            alert("设置失败");
                        }
                    },
                    error: function(XMLHttpRequest){
                        alert( "Error: " + XMLHttpRequest.responseText);
                    }
                });
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h2>管理员界面</h2>
        <a href="${pageContext.request.contextPath}/admin/logout">注销</a>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2>版块基本信息</h2>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>版块id</th>
                    <th>版块名称</th>
                    <th>版主uid</th>
                    <th>版块帖子数量</th>
                    <th>版块描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${postList}" var="post">
                    <tr>
                        <td>${post.bbs_section_id}</td>
                        <td>${post.section_name}</td>
                        <td><c:if test="${post.adminUid==null}">暂未设置</c:if>${post.adminUid}</td>
                        <td>${post.post_num}</td>
                        <td>${post.post_describe}</td>
                        <td><button class="btn btn-danger" >禁用</button> <button class="btn btn-info" onclick="setPostAdmin(${post.bbs_section_id})">设置版主</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
    <div class="row">
        <div class="col-md-3">
            <h2>添加版块</h2>
            <form method="post" action="${pageContext.request.contextPath}/admin/addPost">
                <div class="form-group">

                    <label>版块名称</label><input type="text" name="section_name" required="required" placeholder="版块名称" class="form-control" autocomplete="off">
                    <label>简介</label><textarea name="post_describe" required="required" rows="10" cols="30" class="form-control" autocomplete="off"> </textarea>
                </div>
            </form>
            <input type="submit" value="提交" class="btn btn-default">

        </div>
    </div>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/4
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript">
        window.onload=function(){
            var today=new Date();
            var time1=Date.parse("${userInformation.sign_date}");
            var time2=Date.parse(today.toString());
            var dayCount = Math.round((Math.abs(time2 - time1))/1000/60/60/24);
            $("#comeDay").text(dayCount);
        }
    </script>
    <style>
        .img-thumbnail{
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>
<div class="jumbotron">
    <div class="row">
        <div class="col-md-10">
            <h2>欢迎${userInformation.nickname}</h2>
            <p>你加入BBS已经<span id="comeDay"></span>天了，很高兴与你相伴！</p>
        </div>
        <div class="col-md-2">
            <c:if test="${userInformation.headURL==null}">
                <img src="${pageContext.request.contextPath}/images/chatHead.jpg" class="img-thumbnail" alt="头像">
            </c:if>
            <c:if test="${userInformation.headURL!=null}">
                <img src="${pageContext.request.contextPath}/uploads/${userInformation.headURL}" class="img-thumbnail" alt="头像">
            </c:if>
        </div>
    </div>

</div>
<ul class="nav nav-tabs">
    <c:choose>
        <c:when test="${page==1}">
            <li class="active"><a href="${pageContext.request.contextPath}/manage/home">个人信息更改</a></li>
            <li><a href="${pageContext.request.contextPath}/manage/home/boardManage">帖子管理</a></li>
            <li><a href="${pageContext.request.contextPath}/manage/home/replayManage">回复管理</a></li>

        </c:when>
        <c:when test="${page==2}">
            <li><a href="${pageContext.request.contextPath}/manage/home">个人信息更改</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/manage/home/boardManage">帖子管理</a></li>
            <li><a href="${pageContext.request.contextPath}/manage/home/replayManage">回复管理</a></li>
        </c:when>
        <c:when test="${page==3}">
            <li><a href="${pageContext.request.contextPath}/manage/home">个人信息更改</a></li>
            <li><a href="${pageContext.request.contextPath}/manage/home/boardManage">帖子管理</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/manage/home/replayManage">回复管理</a></li>
        </c:when>
    </c:choose>


</ul>
</body>
</html>
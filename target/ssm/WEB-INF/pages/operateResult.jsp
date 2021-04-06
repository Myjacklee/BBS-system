<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/4/3
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>结果</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <style>
        .content{
            margin-top: 200px;
        }
        .img_div{
            border-right: 2px solid #eeeeee;
            text-align: center;
        }
        .text_notice{
            font-size:18px;
            padding-top: 16px;
        }
        .img{
            display: inline;
        }
    </style>
</head>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <div class="row  content">

        <div class="col-md-4 col-md-offset-2 img_div">


                <c:choose>
                     <c:when test="${result.state=='success'}">
                    <img class="img img-responsive"	 src="${pageContext.request.contextPath}/images/success.png">
</c:when>
<c:when test="${result.state=='fail'}">
                     <img class="img img-responsive"	 src="${pageContext.request.contextPath}/images/fail.png">
</c:when>
                </c:choose>

        </div>
        <div class="col-md-4 text-center">
            <h1 class="text-danger">${result.title}</h1>
            <p class="text_notice">${result.message}</p>
        </div>

    </div>
</div>
</body>
</html>

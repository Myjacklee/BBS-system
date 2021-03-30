<%--
  Created by IntelliJ IDEA.
  User: admin_2
  Date: 2021/3/30
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>BBS系统三级页面（展示每一条帖子的详细内容）</title>
</head>
<body>
<h1>该页面展示每条帖子的详细信息</h1>
<h2>帖子信息</h2>
<p>帖子id：${board.board_id}</p>
<p>帖子所在模块id：${board.bbs_section_id}</p>
<p>最新回复时间：${board.last_reply_time}</p>
<p>创建时间${board.board_create_time}</p>
<p>帖子标题：${board.board_title}</p>
<p>帖子内容：${board.board_content}</p>
<p>创建帖子的用户昵称：${board.nickname}</p>
<h2>回帖栏</h2>
<form action="" method="post">
    <textarea cols="30" rows="10"></textarea>
    <input type="submit" value="回复">
</form>
<h2>回帖楼层</h2>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/28
  Time: 下午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is sessionPage2</title>
</head>
<body>
    Session的id号：<%=session.getId()%><br>
    Session的用户名：<%=session.getAttribute("username")%><br>
</body>
</html>

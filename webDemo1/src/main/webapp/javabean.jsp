<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tsingkuo.javabean.User" %>
<html>
<head>
    <title>this is javabean page</title>
</head>
<body>
    <%
        User user = new User();
        user.setPassword("admin");
        user.setUsername("admin");
    %>
    用户名：<%=user.getUsername()%><br>
    密码：<%=user.getPassword()%><br>
</body>
</html>

<%@ page import="com.tsingkuo.javabean.User" %><%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is javabean3 page</title>
</head>
<body>
<jsp:useBean id="myUser" class="com.tsingkuo.javabean.User" scope="request"/>
用户名：<%=((User)request.getAttribute("myUser")).getUsername()%><br>
密码：<%=((User)request.getAttribute("myUser")).getPassword()%><br>

用户名2：<jsp:getProperty name="myUser" property="username"/><br>
密码2：<jsp:getProperty name="myUser" property="password"/><br>
</body>
</html>

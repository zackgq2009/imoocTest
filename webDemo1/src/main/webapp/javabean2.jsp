<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 上午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is javabean2 page</title>
</head>
<body>
<jsp:useBean id="myUser" class="com.tsingkuo.javabean.User" scope="request"/>
<jsp:setProperty name="myUser" property="username"/>
<%--<jsp:setProperty name="myUser" property="password" value="123123123123"/>--%>
<jsp:setProperty name="myUser" property="password" param="password"/>
用户名：<%=myUser.getUsername()%><br>
密码：<%=myUser.getPassword()%><br>

用户名2：<jsp:getProperty name="myUser" property="username"/><br>
密码2：
<jsp:getProperty name="myUser" property="password"/><br>

<a href="javabean3.jsp?username=123&password=123">跳转至javabean3</a>
<%
    request.getRequestDispatcher("javabean3.jsp").forward(request,response);
%>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/12/6
  Time: 下午9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>this is sign in failure page</title>
</head>
<body>
    <h1>这是一个登录失败的页面</h1>
    <h2><%=request.getAttribute("reason")%></h2>
    <a href="<%=path%>/doFiles/doSignUp.jsp">注册</a><br>
    <a href="<%=path%>/doFiles/doSignIn.jsp">登录</a><br>
</body>
</html>

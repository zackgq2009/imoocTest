<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/12/6
  Time: 下午4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>this is signup failure page</title>
</head>
<body>
    <h1>
        不好意思，你注册的用户已存在，请重新注册！
    </h1>
    <a href="<%=path%>/doFiles/doSignUp.jsp">注册</a>
</body>
</html>

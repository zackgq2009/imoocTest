<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/12/1
  Time: 下午6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath(); //获取项目的根目录的路径
%>
<html>
<head>
    <title>This is index welcome page!</title>
</head>
<body>
<h1>Welcome 欢迎来到TENGA首页!</h1><br>
<%
    if (request.getCookies() != null) {
        for (Cookie c : request.getCookies()
                ) {
            if ("marketingProjectUser".equals(c.getName())) {
                request.getRequestDispatcher("itermList.jsp").forward(request, response);
            }
        }
%>
    <a href="../doFiles/doSignUp.jsp">注册</a><br>
    <a href="../doFiles/doSignIn.jsp">登录</a><br>
<%
    } else {
%>
    <a href="../doFiles/doSignUp.jsp">注册</a><br>
    <a href="../doFiles/doSignIn.jsp">登录</a><br>
<%
    }
%>
</body>
</html>


<%@ page import="com.tsingkuo.main.User" %><%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 下午5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page import="com.tsingkuo.main.User" %>--%>
<%@page import="com.tsingkuo.action.UserAction" %>
<jsp:useBean id="user" class="com.tsingkuo.main.User" scope="session"/>
<%--<jsp:useBean id="userAction" class="com.tsingkuo.action.UserAction" scope="page"/>--%>
<%
//    User user = new User();
    UserAction userAction = new UserAction();
%>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>this id do signup page</title>
</head>
<body>
    <h1>这是一个进行注册的页面</h1>
    <%
        if (userAction.create(user)) {
            session.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("signupsuccess.jsp").forward(request, response);
        } else {
            response.sendRedirect("signupfailure.jsp");
        }
    %>
</body>
</html>

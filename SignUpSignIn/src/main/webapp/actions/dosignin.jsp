<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 下午6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.tsingkuo.action.UserAction" %>
<jsp:useBean id="user" class="com.tsingkuo.main.User" scope="session"/>
<%--<jsp:useBean id="userAction" class="com.tsingkuo.action.UserAction" scope="session"/>--%>
<jsp:setProperty name="user" property="*"/>
<%
    UserAction userAction = new UserAction();
    Boolean result = userAction.search(user);
    if (result) {
        session.setAttribute("username", user.getUsername());
        request.getRequestDispatcher("signinsuccess.jsp").forward(request, response);
    } else {
        response.sendRedirect("signinfailure.jsp");
    }
%>
<html>
<head>
    <title>this is do signin page</title>
</head>
<body>
</body>
</html>

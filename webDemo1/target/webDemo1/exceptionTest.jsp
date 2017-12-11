<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/28
  Time: 下午3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="exception.jsp" %>
<html>
<head>
    <title>this is exceptionTest Page</title>
</head>
<body>
    <%
        out.println(100/0); //抛出运行时异常，算数异常
    %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/28
  Time: 下午3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is pageContext</title>
</head>
<body>
    session的ID：<%=pageContext.getSession().getId()%><br>
    Page的信息：<%=pageContext.getPage().toString()%><br>
    <%--<%--%>
        <%--pageContext.forward("index.jsp");--%>
    <%--%><br>--%>
    <%
        pageContext.include("index.jsp");
    %>
</body>
</html>

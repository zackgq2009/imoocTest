<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/28
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is jsp application page</title>
</head>
<body>
    <%
        /**
         * application对象是web服务器全局的一个成员变量
         */
        application.setAttribute("username", "asdf");
        application.setAttribute("a", "asdf");
        application.setAttribute("b", "asdfasdf");
        application.setAttribute("c", "asdfasdfasdf");
    %>
    application的属性：<%=application.getAttribute("username")%><br>
    application所有的属性：<%
        Enumeration enumeration = application.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            out.println(enumeration.nextElement() + "<br>");
        }
    %><br>
    application服务器的信息：<%=application.getServerInfo()%>
</body>
</html>

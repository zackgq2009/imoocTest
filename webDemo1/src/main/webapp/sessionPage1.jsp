<%@ page import="java.util.Date" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/28
  Time: 下午12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is sessionPage1</title>
</head>
<body>
    <%
        Date date = new Date(session.getCreationTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        session.setAttribute("username", "admin");
        session.setAttribute("password", "password");
        session.setAttribute("a", "1");
        session.setAttribute("b", "2");
        session.setAttribute("c", "3");
    %>
    Session的创建时间：<%=session.getCreationTime()%><br>
    Session的创建时间2：<%=simpleDateFormat.format(date)%><br>
    Session的id号：<%=session.getId()%><br>
    Session的用户名：<%=session.getAttribute("username")%><br>
    Session的所有属性：<%
        String[] attributes = session.getValueNames();
        for (String attribute : attributes
                ) {
            out.print(attribute + " ");
        }
    %><br>

    <a href="sessionPage2.jsp" >跳转至sessionPage2</a><br>

    Session的最大失效时间：<%=session.getMaxInactiveInterval()%><br>
    <%
        session.setMaxInactiveInterval(10);
    %>
    Session的第二次失效时间：<%=session.getMaxInactiveInterval()%><br>
</body>
</html>

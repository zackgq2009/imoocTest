<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.sendRedirect("../welcome.jsp");
    session.invalidate();
%>

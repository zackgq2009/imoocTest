<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/27
  Time: 下午4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is user homepage!</title>
</head>
<body>
    <H1>这是用户的登录页面</H1>
    <%
        request.setCharacterEncoding("utf-8");
        request.setAttribute("sex", "male");
    %>
    <br>
    用户注册的用户名：<%=request.getParameter("username")%>
    <br>
    用户输入的密码： <%=request.getParameter("password")%>
    <br>
    用户选择的爱好：<%
        String[] favorites = request.getParameterValues("favorite");
        if (favorites != null) {
            for (String favorite : favorites
                    ) {
                out.print(favorite + "&nbsp;&nbsp;");
            }
        }
    %>
    <br>
    用户的性别：<%=request.getAttribute("sex")%>
    <br>
    请求体的MIME类型：<%=request.getContentType()%>
    <br>
    协议类型以及版本号：<%=request.getProtocol()%>
    <br>
    服务器主机名：<%=request.getServerName()%>
    <br>
    服务器端口号：<%=request.getServerPort()%>
    <br>
    请求文件的长度：<%=request.getContentLength()%>
    <BR>
    请求客户端的IP地址：<%=request.getRemoteAddr()%>
    <br>
    请求的真实路径：<%=request.getRealPath("signup.jsp")%>
    <br>
    请求的上下文路径：<%=request.getContextPath()%>
    <br>
    <%--重定向：--%>
    <%--<%--%>
        <%--response.sendRedirect("loginPage.jsp");--%>
    <%--%>--%>
    转发：
        <%
            request.getRequestDispatcher("loginPage.jsp").forward(request,response);
        %>
</body>
</html>

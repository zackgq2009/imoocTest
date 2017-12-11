<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/27
  Time: 下午4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is login page!</title>
</head>
<body>
<form action="javabean2.jsp" name="loginPage" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" value=<%=request.getAttribute("username")%>></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" value=<%=request.getAttribute("password")%>></td>
        </tr>
        <tr>
            <td><input type="submit" name="loginButton"></td>
        </tr>
    </table>
</form>
<a href="javabean2.jsp?password=ksdjflsjdflksdjflfjsdlfkjsdlfj">login页面跳转至javabean2页面</a>
</body>
</html>

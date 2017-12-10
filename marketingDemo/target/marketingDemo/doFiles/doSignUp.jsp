<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/30
  Time: 下午8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>This is do sign up page</title>
</head>
<body>
<h1>
    这是注册用户的页面！
</h1>
<form action="/servlet/SignUp" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="" ></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" value=""></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="checkbox" name="gender" value="male">男</td>
            <td><input type="checkbox" name="gender" value="female">女</td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age" value=""></td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="submit" value="提交注册" align="bottom">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/30
  Time: 下午8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is do sign in page</title>
</head>
<body>
<h1>
    这是用户登录的页面！
</h1>
<form action="/servlet/SignIn" method="post">
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
            <td>
                <input type="submit" name="submit" value="登录" align="bottom">
            </td>
        </tr>
    </table><br>
    <a href="doSignUp.jsp">注册</a>
</form>
</body>
</html>

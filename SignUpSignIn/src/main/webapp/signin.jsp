<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is sign in page</title>
</head>
<body>
    <h1>这是用户登录页面！</h1>
    <form name="signinuser" action="actions/dosignin.jsp" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" value=""></td>
            </tr>
            <tr>
                <td>密码：
                </td>
                <td><input type="password" name="password" value=""></td>
            </tr>
            <tr>
                <input type="submit" value="登录">
            </tr>
        </table>
    </form>
</body>
</html>

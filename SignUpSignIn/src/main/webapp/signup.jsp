<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/29
  Time: 下午5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is sign up page</title>
</head>
<body>
    <h1>这是用户注册页面！</h1><hr>
    <form name="signupuser" action="actions/dosignup.jsp" method="post">
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
                <td>性别：</td>
                <td>
                    <select name="gender">
                        <option value="male">1</option>
                        <option value="female">2</option>
                    </select>
                </td>
            </tr>
            <tr>
                <input type="submit" value="注册">
            </tr>
        </table>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/27
  Time: 下午5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is user signUP page!</title>
</head>
<body>
    <form action="user.jsp" name="signUp Page">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>爱好：</td>
                <td>
                    <input type="checkbox" name="favorite" content="读书" value="read">读书
                    <input type="checkbox" name="favorite" content="写作" value="write">写作
                    <input type="checkbox" name="favorite" content="看报" value="newpaper">看报
                    <input type="checkbox" name="favorite" content="打游戏" value="game">打游戏
                    <input type="checkbox" name="favorite" content="上网" value="internet">上网
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="signupSubmit">注册注册</td>
            </tr>
        </table>
    </form>
    <br>
    <br>
    <a href="user.jsp?username=tsingkuo&password=gogogogo">URL连接中加入用户的信息</a><br>
    <a href="pageContext.jsp">URL连接到pageContext页面</a><br>
    <%
        out.println(session.getId());
    %>

</body>
</html>

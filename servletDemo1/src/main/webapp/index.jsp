<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/12/4
  Time: 下午1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="servlet/myservletdemo1">通过get方式跳转至servletDemo1页面</a>
<form method="post" action="servlet/myservletdemo1">
    <input type="submit" value="通过post方式跳转至servletDemo1页面"/>
</form>

<a href="servlet/myservletfile1">通过get方式跳转至servletFile1页面</a>
<form method="post" action="servlet/myservletfile1">
    <input type="submit" value="通过post方式跳转至servletFile1页面"/>
</form>
</body>
</html>

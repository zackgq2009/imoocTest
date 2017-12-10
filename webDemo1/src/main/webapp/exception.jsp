<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/28
  Time: 下午3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>this is exception page</title>
</head>
<body>
    异常信息：<%=exception.getMessage()%><br>
    异常信息的字符串描述：<%=exception.toString()%>
</body>
</html>

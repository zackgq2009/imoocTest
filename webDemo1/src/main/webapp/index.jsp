<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>my first jsp test page</title>
</head>
<body>
<h2>Hello World444444444444!</h2>
<!-- -->
<%-- --%>
<%
    //代码中的单行注释
    /**
     * 代码中的多行注释
     */
    out.println("this is my first jsp page!");
%>
<br>
<%!
    String s = "tsingkuo";
    int add(int x, int y) {
        return x+y;
    }

    int count(int x, int y) {
        return x*y;
    }
%>
WELCOME, <%=s %>
<br>
x+y=<%=add(5, 10)%>
<br>
<%
    for (int i=1; i<= 9 ; i++) {
        for (int j=1; j<=i; j++) {
            out.print(i + "*" + j + "=" + count(i, j) + "              ");
        }
%>
<br>
<%
    }
%>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/11/30
  Time: 下午8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.tsingkuo.webapp.entity.Iterm" %>
<%@page import="com.tsingkuo.webapp.action.ItermAction" %>
<%@ page import="com.tsingkuo.webapp.model.ItermModel" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.tsingkuo.webapp.model.UserModel" %>
<%@ page import="com.tsingkuo.webapp.entity.User" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>This is iterm detail page!</title>
</head>
<body>
    <h1>这是商品详情展示页面！！！</h1>

    <a href="<%=path%>/viewFiles/itermList.jsp">返回至商品列表页</a><br>

    <%
        Iterm iterm = new Iterm();
        User user = new User();
        UserModel userModel = new UserModel();
        ItermModel itermModel = new ItermModel();
        ItermAction itermAction = new ItermAction();
        String itermId = request.getParameter("id");
        iterm = itermModel.queryIterm(Integer.parseInt(request.getParameter("id")));
        if (iterm != null) {
    %>
    <form>
        <table>
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>password</th>
                <th>gender</th>
                <th>age</th>
            </tr>
            <%
                boolean cookieFlag = false;
                if (request.getCookies() != null && request.getCookies().length > 0) {
                    for (Cookie c : request.getCookies()
                            ) {
                        if ("marketingProjectUser".equals(c.getName())) {
                            cookieFlag = true;
                            User newUser = new User();
                            newUser.setUsername(c.getValue());
                            user = userModel.searchUser(c.getValue());
            %>
                        <tr>
                            <td><%=user.getId()%>
                            </td>
                            <td><%=user.getUsername()%>
                            </td>
                            <td><%=user.getPassword()%>
                            </td>
                            <td><%=user.getGender()%>
                            </td>
                            <td><%=user.getAge()%>
                            </td>
                        </tr>
                        <tr>
                            <td><a href="/servlet/SignOut">注销</a></td>
                        </tr>
            <%
                        break;
                    }
                }
                if (cookieFlag == false) {
            %>
            <tr>
                <a href="<%=path%>/doFiles/doSignIn.jsp">请先登录</a>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <a href="<%=path%>/doFiles/doSignIn.jsp">请先登录</a>
            </tr>
            <%
                }
            %>
        </table>
    </form>

    <table>
        <td width="70%">
            <table>
                <tr>
                    <td>商品名称：</td>
                    <td><%=iterm.getItermName()%>
                    </td>
                </tr>
                <tr>
                    <td>商品价格：</td>
                    <td><%=iterm.getItermPrice()%>
                    </td>
                </tr>
                <tr>
                    <td>商品库存：</td>
                    <td><%=iterm.getItermStock()%>
                    </td>
                </tr>
                <tr>
                    <td>商品图片：</td>
                    <td><img src="../images/<%=iterm.getItermPicture()%>"></td>
                </tr>
                <tr>
                    <td>商品详细信息：</td>
                    <td><%=iterm.getItermDescription()%></td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="cartItermAmount" value="1">
                    </td>
                    <td>
                        <a href="/servlet/CartServlet?action=add&id=<%=request.getParameter("id")%>&cartItermAmount=10">添加到购物车中</a>
                    </td>
                    <%--<form action="/servlet/CartServlet?action=add&iterm_id=<%=request.getParameter("id")%>" name="addToCart" method="post">--%>
                        <%--<tr>--%>
                            <%--<td><input type="text" name="cartItermAmount" value="1"></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td><input type="submit" name="submitToCart" value="添加到购物车中"></td>--%>
                        <%--</tr>--%>
                    <%--</form>--%>
                </tr>
                <tr>
                    <td><a href="<%=path%>/viewFiles/cartList.jsp">查看购物车</a></td>
                </tr>
            </table>
        </td>
        <%
            String cookieValue = "";
            boolean historyFlag = false;
            if (request.getCookies() != null && request.getCookies().length > 0) {
                for (Cookie cook : request.getCookies()
                        ) {
                    if ("viewHistoryList".equals(cook.getName())) {
                        cookieValue = cook.getValue();
                        historyFlag = true;
                        break;
                    }
                }
                if (historyFlag == false) {
                    //需要说明一下，tomcat对于cookie中的字符有限制，之前我是通过,或者;或者空格进行数据分割，发现这些字符都不合格，需要使用"-"
                    cookieValue = request.getParameter("id") + "-";
                } else {
                    cookieValue += request.getParameter("id") + "-";
                }
            } else {
                cookieValue = request.getParameter("id") + "-";
            }
            String[] ids = cookieValue.split("-");
            if (ids != null && ids.length > 0) {
                if (ids.length >= 1000) {
                    cookieValue = request.getParameter("id") + "-";
                }
            }
            response.setContentType("text/html;charset=utf-8");
            Cookie myCookie = new Cookie("viewHistoryList", cookieValue);
            myCookie.setMaxAge(846000);
            myCookie.setPath("/");
            response.addCookie(myCookie);
        %>
        <td width="30%">
            <h3>这是您浏览过的商品</h3><br>
            <%
                Collection<Iterm> itermCollection = itermAction.queryFifth(cookieValue);
                for (Iterm i : itermCollection
                        ) {
            %>
                <div>
                    <dl>
                        <dt><a href="<%=path%>/viewFiles/itermDetail.jsp?id=<%=i.getId()%>"><img src="../images/<%=i.getItermPicture()%>" width="120" height="90"></a></dt>
                        <dd><%=i.getItermName()%></dd>
                        <dd><%=i.getItermPrice()%></dd>
                    </dl>
                </div>
            <%
                }
            %>
        </td>
    </table>
    <%
        } else {
    %>
    <h2>查询的商品有误</h2>
    <%
        }
    %>
</body>
</html>

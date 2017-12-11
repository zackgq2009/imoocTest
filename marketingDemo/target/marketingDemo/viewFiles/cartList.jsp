<%--
  Created by IntelliJ IDEA.
  User: johnnykuo
  Date: 2017/12/7
  Time: 下午7:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tsingkuo.webapp.entity.Cart" %>
<%@ page import="com.tsingkuo.webapp.model.CartModel" %>
<%@ page import="com.tsingkuo.webapp.entity.User" %>
<%@ page import="com.tsingkuo.webapp.model.UserModel" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.tsingkuo.webapp.model.ItermModel" %>
<%
    User user = new User();
    UserModel userModel = new UserModel();
    String path = request.getContextPath();
    CartModel cartModel = new CartModel();
    Collection<Cart> cartCollection = null;
    ItermModel itermModel = new ItermModel();
%>
<html>
<head>
    <title>this is cart page</title>
</head>
<body>
<h1>这是一个购物车页面！</h1>
<a href="<%=path%>/viewFiles/itermList.jsp">返回至商品列表页</a><br>

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
            <a href="/servlet/SignOut">注销</a>
        </tr>
        <%
            cartCollection = cartModel.searchCart(user.getId());
            if (cartCollection != null && cartCollection.size() > 0) {
        %>
        <table>
            <tr>
                <th>Id:</th>
                <th>商品名称：</th>
                <th>商品价格：</th>
                <th>商品数量：</th>
            </tr>
            <%
                for (Cart cart : cartCollection
                        ) {
            %>
            <tr>
                <td>
                    <%=cart.getId()%>
                </td>
                <td>
                    <%=itermModel.queryIterm(cart.getItermId()).getItermName()%>
                </td>
                <td>
                    <%=itermModel.queryIterm(cart.getItermId()).getItermPrice()%>
                </td>
                <td>
                    <%=cart.getCartItermAmount()%>
                </td>
                <td>
                    <a href="/servlet/CartServlet?action=delete&cart_id=<%=cart.getId()%>">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>
        <h2>您好用户，您未添加任何商品到购物车！</h2>
        <%
                    }
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

</body>
</html>

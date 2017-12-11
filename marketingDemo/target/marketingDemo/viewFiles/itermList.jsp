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
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tsingkuo.webapp.model.UserModel" %>
<%@ page import="com.tsingkuo.webapp.entity.User" %>
<%
    User user = new User();
    UserModel userModel = new UserModel();
    String path = request.getContextPath();
%>
<html>
<head>
    <title>This is iterm list page!</title>
</head>
<body>
    <h1>这是所有商品展示页面</h1>
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
//                    Cookie[] cs = request.getCookies();
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
        <%
            ItermAction itermAction = new ItermAction();
            Collection<Iterm> itermCollection = itermAction.queryAll();
            for (Iterm i : itermCollection
                    ) {
        %>
            <tr>
                <td>商品名称：</td>
                <td><%=i.getItermName()%></td>
            </tr>
            <tr>
                <td>商品价格：</td>
                <td><%=i.getItermPrice()%></td>
            </tr>
            <tr>
                <td>商品库存：</td>
                <td><%=i.getItermStock()%></td>
            </tr>
            <tr>
                <td>商品图片：</td>
                <td><a href="<%=path%>/viewFiles/itermDetail.jsp?id=<%=i.getId()%>"><img src="../images/<%=i.getItermPicture()%>"></a></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>

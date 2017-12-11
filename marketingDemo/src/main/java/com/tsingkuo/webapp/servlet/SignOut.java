package com.tsingkuo.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignOut")
public class SignOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        if (request.getCookies() != null && request.getCookies().length > 0) {
            for (Cookie c : request.getCookies()
                    ) {
                if ("marketingProjectUser".equals(c.getName())) {
                    Cookie cookie = new Cookie("marketingProjectUser", "username");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    continue;
                } else if ("viewHistoryList".equals(c.getName())) {
                    Cookie cookie = new Cookie("viewHistoryList", "viewHistoryList");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    continue;
                }
            }
            response.sendRedirect(path + "/viewFiles/welcome.jsp"); //把cookie清空之后，再跳转至welcome页面上
        } else {
            response.sendRedirect(path + "/viewFiles/welcome.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

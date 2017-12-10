package com.tsingkuo.webapp.servlet;

import com.tsingkuo.webapp.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignIn")
public class SignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String path = request.getContextPath();

        UserModel userModel = new UserModel();
        if (userModel.searchUser(username) != null) {
            if (userModel.searchUser(username, password) != null) {
                response.setContentType("text/html;charset=utf-8");
                Cookie cookie = new Cookie("marketingProjectUser", username);
                cookie.setPath("/");
                response.addCookie(cookie);
                //通过重定向，跳转至itermList页面上
                response.sendRedirect(path + "/viewFiles/itermList.jsp");
            } else {
                request.setAttribute("reason", "输入的密码有误，请重试");
                request.getRequestDispatcher(path + "/viewFiles/signInFailure.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("reason", "不存在此用户");
            request.getRequestDispatcher(path + "/viewFiles/signInFailure.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

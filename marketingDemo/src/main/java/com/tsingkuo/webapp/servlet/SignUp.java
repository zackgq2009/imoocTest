package com.tsingkuo.webapp.servlet;

import com.tsingkuo.webapp.entity.User;
import com.tsingkuo.webapp.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUp")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setGender(gender);
        newUser.setAge(Byte.parseByte(age));

        String path = request.getContextPath();

        UserModel userModel = new UserModel();
        if (userModel.searchUser(username) != null) {
            response.sendRedirect(path + "/viewFiles/signUpFailure.jsp");
        } else {
            if (userModel.createUser(newUser) == false) {
                response.setContentType("text/html;charset=utf-8");
                Cookie cookie = new Cookie("marketingProjectUser", username);
                cookie.setMaxAge(864000);
                cookie.setPath("/");
                /**
                 * 上边的cookie.setPath()这个方法一定要写，因为如果不写的话，servlet添加的cookie会在request中的response的cookie中，所以在jsp页面中根本就无法通过request这个对象来获取到getCookie()
                 */
                response.addCookie(cookie);
                response.sendRedirect(path + "/viewFiles/itermList.jsp");
//                request.getRequestDispatcher(path + "/viewFiles/itermList.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

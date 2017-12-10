package com.tsingkuo.webapp.servlet;

import com.tsingkuo.webapp.entity.Cart;
import com.tsingkuo.webapp.entity.Iterm;
import com.tsingkuo.webapp.entity.User;
import com.tsingkuo.webapp.model.CartModel;
import com.tsingkuo.webapp.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        UserModel userModel = new UserModel();
        String path = request.getContextPath();
        boolean userFlag = false;
        CartModel cartModel = new CartModel();
        Cart cart = null;

        if (request.getCookies() != null && request.getCookies().length > 0) {
            for (Cookie c : request.getCookies()
                    ) {
                if ("marketingProjectUser".equals(c.getName())) {
                    String username = c.getValue();
                    user = userModel.searchUser(username);
                    userFlag = true;
                    break;
                }
            }
            if (userFlag == true) {
                if ("add".equals(request.getParameter("action"))) {
                    cart = new Cart();
                    String itermId = request.getParameter("id");
                    String userItermAmout = request.getParameter("cartItermAmount");
                    int userId = user.getId();
                    if (cartModel.searchCart(userId, Integer.parseInt(itermId)) != null) {
                        cart = cartModel.searchCart(userId, Integer.parseInt(itermId));
                        int amount = cart.getCartItermAmount();
                        amount += Integer.parseInt(userItermAmout);
                        cart.setCartItermAmount(amount);
                        cartModel.updateCart(cart);
                    } else {
                        cart.setUserId(user.getId());
                        cart.setItermId(Integer.parseInt(itermId));
                        cart.setCartItermAmount(Integer.parseInt(userItermAmout));
                        cartModel.createCart(cart);
                    }
                    request.getRequestDispatcher(path + "/viewFiles/itermDetail.jsp").forward(request, response);
                } else if ("delete".equals(request.getParameter("action"))) {
                    String cartId = request.getParameter("cart_id");
                    cart = new Cart();
                    cart.setId(Integer.parseInt(cartId));
                    cartModel.deleteCart(cart);
                    request.getRequestDispatcher(path + "/viewFiles/cartList.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect(path + "/doFiles/doSignIn.jsp");
            }
        } else {
            response.sendRedirect(path + "/doFiles/doSignIn.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public CartServlet() {
        super();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

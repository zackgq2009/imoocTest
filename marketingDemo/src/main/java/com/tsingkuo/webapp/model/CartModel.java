package com.tsingkuo.webapp.model;

import com.tsingkuo.webapp.entity.Cart;
import com.tsingkuo.webapp.entity.Iterm;
import com.tsingkuo.webapp.entity.User;
import com.tsingkuo.webapp.util.MysqlUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CartModel {
    private static final String tableName = "user_cart";
    public Connection connection = null;

    Collection<Cart> cartCollection = null;

    /**
     * 由于preparedStatement.execute()方法返回的结果:
     * true if the first result is a ResultSet object; false if the first result is an update count or there is no result
     * @param
     * @return
     */
    public boolean createCart(Cart cart) {
        connection = MysqlUtil.getConnection();
        String insertString = "insert into " + tableName + " (user_id, iterm_id, cart_iterm_amount) values (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setInt(1, cart.getUserId());
            preparedStatement.setInt(2, cart.getItermId());
            preparedStatement.setInt(3, cart.getCartItermAmount());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("添加用户购物车出现问题");
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteCart(Cart cart) {
        connection = MysqlUtil.getConnection();
        String deleteString = "delete from " + tableName + " where cart_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(deleteString);
            preparedStatement.setInt(1, cart.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("删除用户购物车出现问题");
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCart(Cart cart) {
        connection = MysqlUtil.getConnection();
        String updateString = "update " + tableName + " set user_id = ?, iterm_id = ?, cart_iterm_amount = ? where cart_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setInt(1, cart.getUserId());
            preparedStatement.setInt(2, cart.getItermId());
            preparedStatement.setInt(3, cart.getCartItermAmount());
            preparedStatement.setInt(4, cart.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("更新用户购物车出现问题");
            e.printStackTrace();
            return false;
        }
    }

    public Collection<Cart> queryCart() {
        cartCollection = new ArrayList<Cart>();
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + tableName;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);
            Cart cart = null;
            while (resultSet.next()) {
                cart = new Cart();
                cart.setId(resultSet.getInt("cart_id"));
                cart.setUserId(resultSet.getInt("user_id"));
                cart.setItermId(resultSet.getInt("iterm_id"));
                cart.setCartItermAmount(resultSet.getInt("cart_iterm_amount"));
                cartCollection.add(cart);
            }
            return cartCollection;
        } catch (SQLException e) {
            System.out.println("查询全部数据出现错误");
            e.printStackTrace();
            return null;
        }
    }

    public void queryCart(Cart cart) {

    }

    public Collection<Cart> searchCart(int userId) {
        cartCollection = new ArrayList<Cart>();
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + tableName + " where user_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, userId);
            Cart cart = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cart = new Cart();
                cart.setId(resultSet.getInt("cart_id"));
                cart.setUserId(resultSet.getInt("user_id"));
                cart.setItermId(resultSet.getInt("iterm_id"));
                cart.setCartItermAmount(resultSet.getInt("cart_iterm_amount"));
                cartCollection.add(cart);
            }
            return cartCollection;
        } catch (SQLException e) {
            System.out.println("无法正常查询");
            e.printStackTrace();
            return null;
        }
    }

    public Cart searchCart(int userId, int itermId) {
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + tableName + " where user_id = ? and iterm_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, itermId);
            Cart cart = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cart = new Cart();
                cart.setId(resultSet.getInt("cart_id"));
                cart.setUserId(resultSet.getInt("user_id"));
                cart.setItermId(resultSet.getInt("iterm_id"));
                cart.setCartItermAmount(resultSet.getInt("cart_iterm_amount"));
                return cart;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("无法正常查询到这条购物车记录");
            e.printStackTrace();
            return null;
        }
    }

}

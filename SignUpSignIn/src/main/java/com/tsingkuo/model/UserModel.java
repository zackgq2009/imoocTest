package com.tsingkuo.model;

import com.tsingkuo.main.User;
import com.tsingkuo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UserModel {
    public Connection connection = null;
    public Collection<User> collection = new ArrayList<User>();

    private String mysqlTableName = "user";

    public Boolean createUser(User user) {
        connection = MysqlUtil.getConnection();
        String insertString = "insert into " + mysqlTableName + " (username, password, gender) " + "values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.execute();
            System.out.println("此用户添加成功");
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.out.println("can't get preparedStatement");
            e.printStackTrace();
            return false;
        }
    }

    public void delUser() {

    }

    public void updateUser() {

    }

    public void queryUser() {

    }

    public void queryUser(String userId) {

    }

    public Collection<User> searchUser(User user) {
        User newUser = new User();
        connection = MysqlUtil.getConnection();
        String searchString = "select * from " + mysqlTableName + " where username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(searchString);
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
                System.out.println(resultSet.getString("gender"));
                newUser.setUsername(resultSet.getString("username"));
                newUser.setPassword(resultSet.getString("password"));
                newUser.setGender(resultSet.getString("gender"));
                collection.add(newUser);
            }
            preparedStatement.close();
            return collection;
        } catch (SQLException e) {
            System.out.println("select people is wrong!");
            e.printStackTrace();
            return null;
        }
    }
}

package com.tsingkuo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcTest", "root", "rootguoqing");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from goddess");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + resultSet.getString("user_name"));
        }
        statement.close();
        connection.close();
    }
}

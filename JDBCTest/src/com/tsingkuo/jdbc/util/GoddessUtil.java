package com.tsingkuo.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by johnnykuo on 2017/11/8.
 */
public class GoddessUtil {
    private static final String jdbcURL = "localhost:3306";
    private static final String jdbcDatabaseName = "jdbcTest";
    private static final String jdbcDataTableName = "goddess";
    private static final String jdbcUserName = "root";
    private static final String jdbcPassword = "rootguoqing";

    private static Connection connection = null;

    public GoddessUtil() {
    }

    static {
        StringBuilder mysqlJDBC = new StringBuilder();
        mysqlJDBC.append("jdbc:mysql://");
        mysqlJDBC.append(jdbcURL);
        mysqlJDBC.append("/");
        mysqlJDBC.append(jdbcDatabaseName);
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            Class jdbc = Class.forName("com.mysql.jdbc.Driver");
//            DriverManager driverManager = (DriverManager) jdbc.newInstance();
            connection = DriverManager.getConnection(mysqlJDBC.toString(), jdbcUserName, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static String getJdbcURL() {
        return jdbcURL;
    }

    public static String getJdbcDatabaseName() {
        return jdbcDatabaseName;
    }

    public static String getJdbcDataTableName() {
        return jdbcDataTableName;
    }

    public static String getJdbcUserName() {
        return jdbcUserName;
    }

    public static String getJdbcPassword() {
        return jdbcPassword;
    }
}

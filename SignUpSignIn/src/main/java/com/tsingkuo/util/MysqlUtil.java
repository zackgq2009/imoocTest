package com.tsingkuo.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtil {
    private static String mysqlURL = "127.0.0.1";
    private static int mysqlPort = 3306;
//    private static String mysqlTableName;
    private static String mysqlDatabaseName = "signupsignin";
    private static String mysqlUsername = "root";
    private static String mysqlPassword = "rootguoqing";

    private static Connection connection = null;

    public MysqlUtil() {
    }

    static {
        System.out.println("------------MYSQL JDBC Connection Testing-------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("where is my mysql jdbc driver?");
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jdbc:mysql://");
        stringBuilder.append(mysqlURL);
        stringBuilder.append(":");
        stringBuilder.append(mysqlPort);
        stringBuilder.append("/");
        stringBuilder.append(mysqlDatabaseName);

        try {
            connection = DriverManager.getConnection(String.valueOf(stringBuilder), mysqlUsername, mysqlPassword);
        } catch (SQLException e) {
            System.out.println("connection failed ! check output console!");
            e.printStackTrace();
        }
    }

    public static String getMysqlURL() {
        return mysqlURL;
    }

    public static void setMysqlURL(String mysqlURL) {
        MysqlUtil.mysqlURL = mysqlURL;
    }

    public static String getMysqlUsername() {
        return mysqlUsername;
    }

    public static void setMysqlUsername(String mysqlUsername) {
        MysqlUtil.mysqlUsername = mysqlUsername;
    }

    public static String getMysqlPassword() {
        return mysqlPassword;
    }

    public static void setMysqlPassword(String mysqlPassword) {
        MysqlUtil.mysqlPassword = mysqlPassword;
    }

    public static int getMysqlPort() {
        return mysqlPort;
    }

    public static void setMysqlPort(int mysqlPort) {
        MysqlUtil.mysqlPort = mysqlPort;
    }

    public static String getMysqlDatabaseName() {
        return mysqlDatabaseName;
    }

    public static void setMysqlDatabaseName(String mysqlDatabaseName) {
        MysqlUtil.mysqlDatabaseName = mysqlDatabaseName;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        MysqlUtil.connection = connection;
    }
}

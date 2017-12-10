package com.tsingkuo.webapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtil {
    private static final String mysqlURL = "127.0.0.1"; //本地数据库
    private static final String mysqlDatabaseName = "marketing"; //此项目的database
    private static final String mysqlPort = "3306"; //默认端口
    private static final String mysqlUsername = "root"; //默认root用户
    private static final String mysqlPassword = "rootguoqing"; //root的密码

    private static Connection connection = null;

    static {
        try {
            //反射获得Driver类
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("get mysql driver failure");
            e.printStackTrace();
        }
    }

    public static String getMysqlURL() {
        return mysqlURL;
    }

    public static String getMysqlDatabaseName() {
        return mysqlDatabaseName;
    }

    public static String getMysqlPort() {
        return mysqlPort;
    }

    public static String getMysqlUsername() {
        return mysqlUsername;
    }

    public static String getMysqlPassword() {
        return mysqlPassword;
    }

    public static Connection getConnection() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jdbc:mysql://");
        stringBuilder.append(mysqlURL);
        stringBuilder.append(":");
        stringBuilder.append(mysqlPort);
        stringBuilder.append("/");
        stringBuilder.append(mysqlDatabaseName);
        stringBuilder.append("?");
        stringBuilder.append("characterEncoding=UTF-8");
        try {
            //获得数据库连接
            connection = DriverManager.getConnection(String.valueOf(stringBuilder), mysqlUsername, mysqlPassword);
        } catch (SQLException e) {
            System.out.println("can't get connection");
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static void setConnection(Connection connection) {
        MysqlUtil.connection = connection;
    }
}

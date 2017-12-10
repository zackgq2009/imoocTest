package com.tsingkuo.webapp.model;

import com.tsingkuo.webapp.entity.Iterm;
import com.tsingkuo.webapp.util.MysqlUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ItermModel {
    private static final String tableName = "iterm";
    public Connection connection = null;

    public boolean createIterm(Iterm iterm) {
        connection = MysqlUtil.getConnection();
        String insertString = "insert into " + tableName + " (itermName, itermPrice, itermStock, itermDescription, itermPicture) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, iterm.getItermName());
            preparedStatement.setInt(2, iterm.getItermPrice());
            preparedStatement.setInt(3, iterm.getItermStock());
            preparedStatement.setString(4, iterm.getItermDescription());
            preparedStatement.setString(5, iterm.getItermPicture());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("can't get preparedStatement");
            e.printStackTrace();
            return false;
        } finally {
        }
    }

    public boolean delIterm(Iterm iterm) {
        connection = MysqlUtil.getConnection();
        String delString = "delete from " + tableName + " where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(delString);
            preparedStatement.setInt(1, iterm.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("del can't get preparedStatement");
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateIterm(Iterm iterm) {
        connection = MysqlUtil.getConnection();
        String updateString = "update " + tableName + " set itermName = ?, itermPrice = ?, itermStock = ?, itermDescription = ?, itermPicture = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setString(1, iterm.getItermName());
            preparedStatement.setInt(2, iterm.getItermPrice());
            preparedStatement.setInt(3, iterm.getItermStock());
            preparedStatement.setString(4, iterm.getItermDescription());
            preparedStatement.setString(5, iterm.getItermPicture());
            preparedStatement.setInt(6, iterm.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("update can't get preparedStatement");
            e.printStackTrace();
            return false;
        }
    }

    public Collection<Iterm> queryIterm() {
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + tableName;
        Collection<Iterm> itermCollection = new ArrayList<Iterm>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            Iterm iterm = null;
            while (resultSet.next()) {
                iterm = new Iterm();
                iterm.setId(resultSet.getInt("id"));
                iterm.setItermName(resultSet.getString("itermName"));
                iterm.setItermPrice(resultSet.getInt("itermPrice"));
                iterm.setItermStock(resultSet.getInt("itermStock"));
                iterm.setItermDescription(resultSet.getString("itermDescription"));
                iterm.setItermPicture(resultSet.getString("itermPicture"));
                itermCollection.add(iterm);
            }
            return itermCollection;
        } catch (SQLException e) {
            System.out.println("queryall can't get preparedStatement");
            e.printStackTrace();
            return null;
        }
    }

    public Iterm queryIterm(int itermId) {
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + tableName + " where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, itermId);
            resultSet = preparedStatement.executeQuery();
            Iterm iterm = null;
            if (resultSet.next()) {
                iterm = new Iterm();
                iterm.setId(resultSet.getInt("id"));
                iterm.setItermName(resultSet.getString("itermName"));
                iterm.setItermPrice(resultSet.getInt("itermPrice"));
                iterm.setItermStock(resultSet.getInt("itermStock"));
                iterm.setItermDescription(resultSet.getString("itermDescription"));
                iterm.setItermPicture(resultSet.getString("itermPicture"));
                return iterm;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("queryOne can't get preparedStatement");
            e.printStackTrace();
            return null;
        }
    }

    public Iterm searchIterm(String itermName) {
        connection = MysqlUtil.getConnection();
        String searchString = "select * from " + tableName + " where itermName = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(searchString);
            preparedStatement.setString(1, itermName);
            resultSet = preparedStatement.executeQuery();
            Iterm iterm = null;
            if (resultSet.next()) {
                iterm = new Iterm();
                iterm.setId(resultSet.getInt("id"));
                iterm.setItermName(resultSet.getString("itermName"));
                iterm.setItermPrice(resultSet.getInt("itermPrice"));
                iterm.setItermStock(resultSet.getInt("itermStock"));
                iterm.setItermDescription(resultSet.getString("itermDescription"));
                iterm.setItermPicture(resultSet.getString("itermPicture"));
                return iterm;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("search can't get preparedStatement");
            e.printStackTrace();
            return null;
        }
    }
}

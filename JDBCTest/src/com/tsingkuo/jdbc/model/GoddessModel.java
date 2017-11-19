package com.tsingkuo.jdbc.model;

import com.tsingkuo.jdbc.base.Goddess;
import com.tsingkuo.jdbc.util.GoddessUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by johnnykuo on 2017/11/7.
 */
public class GoddessModel {
    public Connection connection = null;
    public List<Goddess> goddessList = null;

    public Boolean createGoddess (Goddess goddess) {
        connection = GoddessUtil.getConnection();
        String tableName = GoddessUtil.getJdbcDataTableName();
        String insertString = "insert into " + tableName + " (user_name, sex, age, birthday, email, mobile, create_user, create_date, update_user, update_date, isdel)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, goddess.getUser_name());
            preparedStatement.setInt(2, goddess.getId().intValue());
            preparedStatement.setInt(3, goddess.getAge().intValue());
            preparedStatement.setDate(4, new Date(goddess.getBirthday().getTime()));
            preparedStatement.setString(5, goddess.getEmail());
            preparedStatement.setString(6, goddess.getMobile());
            preparedStatement.setString(7, goddess.getCreate_user());
            preparedStatement.setDate(8, new Date(System.currentTimeMillis()));
            preparedStatement.setString(9, goddess.getUpdate_user());
            preparedStatement.setDate(10, new Date(System.currentTimeMillis()));
            preparedStatement.setInt(11, goddess.getIsDel().intValue());

            preparedStatement.execute();
            System.out.println("此用户添加成功");
            preparedStatement.close();
            connection.close();
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("此用户添加失败");
            return  false;
        }
    }

    public Boolean delGoddess (String goddessId) {
        connection = GoddessUtil.getConnection();
        String tableName = GoddessUtil.getJdbcDataTableName();
        String delString = "delete from " + tableName + " where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delString);
            preparedStatement.setString(1, goddessId);

            preparedStatement.execute();
            System.out.println("此用户删除成功");
            preparedStatement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("此用户删除失败");
            return false;
        }
    }

    public Boolean updateGoddess(Goddess goddess) {
        connection = GoddessUtil.getConnection();
        String tableName = GoddessUtil.getJdbcDataTableName();
        String updateString = "update " + tableName + " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=?,isdel=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setString(1, goddess.getUser_name());
            preparedStatement.setInt(2, goddess.getSex());
            preparedStatement.setInt(3, goddess.getAge());
            preparedStatement.setDate(4, new Date(goddess.getBirthday().getTime()));
            preparedStatement.setString(5, goddess.getEmail());
            preparedStatement.setString(6, goddess.getMobile());
            preparedStatement.setString(7, goddess.getUpdate_user());
            preparedStatement.setDate(8, new Date(System.currentTimeMillis()));
            preparedStatement.setInt(9, goddess.getIsDel());
            preparedStatement.setInt(10, goddess.getId());

            preparedStatement.execute();
            System.out.println("此用户更新成功");
            preparedStatement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("此用户更新失败");
            return false;
        }
    }

    public List<Goddess> queryGoddess() {
        goddessList = new ArrayList<>();
        connection = GoddessUtil.getConnection();
        String tableName = GoddessUtil.getJdbcDataTableName();
        String selectString = "select * from " + tableName + " limit 100";
        Goddess goddess;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectString);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("获取100个用户成功");
            while (resultSet.next()) {
                goddess = new Goddess();
                goddess.setUser_name(resultSet.getString("user_name"));
                goddess.setId(resultSet.getInt("id"));
                goddess.setSex(resultSet.getInt("sex"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setMobile(resultSet.getString("mobile"));
                goddess.setCreate_user(resultSet.getString("create_user"));
                goddess.setCreate_date(resultSet.getDate("create_date"));
                goddess.setUpdate_user(resultSet.getString("update_user"));
                goddess.setUpdate_date(resultSet.getDate("update_date"));
                goddess.setIsDel(resultSet.getInt("isdel"));

                goddessList.add(goddess);
            }
            preparedStatement.close();
            connection.close();
            return goddessList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取100个用户失败");
            return null;
        }
    }

    public Goddess queryGoddess(String goddessId) {
        Goddess goddess = null;
        connection = GoddessUtil.getConnection();
        String tableName = GoddessUtil.getJdbcDataTableName();
        String selectString = "select * from " + tableName + " where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectString);
            preparedStatement.setString(1,goddessId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                goddess = new Goddess();
                goddess.setUser_name(resultSet.getString("user_name"));
                goddess.setId(resultSet.getInt("id"));
                goddess.setSex(resultSet.getInt("sex"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setMobile(resultSet.getString("mobile"));
                goddess.setCreate_user(resultSet.getString("create_user"));
                goddess.setCreate_date(resultSet.getDate("create_date"));
                goddess.setUpdate_user(resultSet.getString("update_user"));
                goddess.setUpdate_date(resultSet.getDate("update_date"));
                goddess.setIsDel(resultSet.getInt("isdel"));
            }
            preparedStatement.close();
            connection.close();
            System.out.println("成功获取" + goddess.getUser_name());
            return goddess;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取用户信息失败");
            return null;
        }
    }

    public List<Goddess> queryGoddess(List<Map<String, Object>> params) {
        goddessList = new ArrayList<>();
        Goddess goddess = null;
        connection = GoddessUtil.getConnection();
        String tableName = GoddessUtil.getJdbcDataTableName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from " + tableName);
        stringBuilder.append(" where 1=1");
        for (Map<String, Object> param : params
                ) {
            stringBuilder.append(" and " + param.get("name") + param.get("rela") + param.get("value"));
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(stringBuilder));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                goddess = new Goddess();
                goddess.setUser_name(resultSet.getString("user_name"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setEmail(resultSet.getString("mobile"));
                goddessList.add(goddess);
            }
            return goddessList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败");
            return  null;
        }
    }

}

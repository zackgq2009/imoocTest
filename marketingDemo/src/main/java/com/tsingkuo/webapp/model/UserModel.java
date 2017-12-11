package com.tsingkuo.webapp.model;

import com.tsingkuo.webapp.entity.User;
import com.tsingkuo.webapp.util.MysqlUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserModel {
    private static final String userTableName = "user";
    public Connection connection = null;

    /**
     * 由于preparedStatement.execute()方法返回的结果:
     * true if the first result is a ResultSet object; false if the first result is an update count or there is no result
     * @param user
     * @return
     */
    public boolean createUser(User user) {
        connection = MysqlUtil.getConnection();
        String insertString = "insert into " + userTableName + " (username, password, gender, age) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertString);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setByte(4, user.getAge());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("can't get preparedStatement");
            e.printStackTrace();
            return false;
        } finally {
//            if (preparedStatement != null) {
//                preparedStatement = null;
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    System.out.println("insert preparedStatement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public boolean delUser(User user) {
        connection = MysqlUtil.getConnection();
        String delString = "delete from " + userTableName + " where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(delString);
            preparedStatement.setInt(1, user.getId());
            boolean executeResult = preparedStatement.execute();
            return executeResult;
        } catch (SQLException e) {
            System.out.println("del can't get preparedStatement");
            e.printStackTrace();
            return false;
        } finally {
//            if (preparedStatement != null) {
//                preparedStatement = null;
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    System.out.println("del preparedStatement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public boolean updateUser(User user) {
        connection = MysqlUtil.getConnection();
        String updateString = "update " + userTableName + " set username = ?, password = ?, gender = ?, age = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setByte(4, user.getAge());
            preparedStatement.setInt(5, user.getId());
            boolean executeResult = preparedStatement.execute();
            return executeResult;
        } catch (SQLException e) {
            System.out.println("update can't get preparedStatement");
            e.printStackTrace();
            return false;
        } finally {
//            if (preparedStatement != null) {
//                preparedStatement = null;
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    System.out.println("update preparedStatement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public Collection<User> queryUser() {
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + userTableName;
        Statement statement = null;
        ResultSet resultSet = null;
        Collection<User> userCollection = new ArrayList<User>();
        User user;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getByte("age"));
                userCollection.add(user);
            }
            return userCollection;
        } catch (SQLException e) {
            System.out.println("queryall can't get preparedStatement");
            e.printStackTrace();
            return null;
        } finally {
//            if (resultSet != null) {
//                resultSet = null;
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    System.out.println("resultSet can't close");
//                    e.printStackTrace();
//                }
//            }
//            if (statement != null) {
//                statement = null;
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    System.out.println("statement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public User queryUser(int userId) {
        connection = MysqlUtil.getConnection();
        String queryString = "select * from " + userTableName + " where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getByte("age"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("queryOne can't get preparedStatement");
            e.printStackTrace();
            return null;
        } finally {
//            if (resultSet != null) {
//                resultSet = null;
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    System.out.println("queryOne resultSet can't close");
//                    e.printStackTrace();
//                }
//            }
//            if (preparedStatement != null) {
//                preparedStatement = null;
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    System.out.println("queryOne preparedStatement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public User searchUser(String userName) {
        connection = MysqlUtil.getConnection();
        String searchString = "select * from " + userTableName + " where username = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(searchString);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getByte("age"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("search can't get preparedStatement");
            e.printStackTrace();
            return null;
        } finally {
//            if (resultSet != null) {
//                resultSet = null;
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    System.out.println("search resultSet can't close");
//                    e.printStackTrace();
//                }
//            }
//            if (preparedStatement != null) {
//                preparedStatement = null;
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    System.out.println("search preparedStetement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public User searchUser(String userName, String password) {
        connection = MysqlUtil.getConnection();
        String searchString = "select * from " + userTableName + " where username = ? and password = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(searchString);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getByte("age"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("search can't get preparedStatement");
            e.printStackTrace();
            return null;
        } finally {
//            if (resultSet != null) {
//                resultSet = null;
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    System.out.println("search resultSet can't close");
//                    e.printStackTrace();
//                }
//            }
//            if (preparedStatement != null) {
//                preparedStatement = null;
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    System.out.println("search preparedStetement can't close");
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

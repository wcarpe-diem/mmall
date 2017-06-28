package com.mmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 * Created by Administrator on 2017/6/28.
 */
public class ImageGet {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mmall?characterEncoding=utf-8";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        try {
            statement = connection.createStatement();
            String sql = "select p.photo from photo p where id = 1";
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            inputStream = resultSet.getBinaryStream("photo");
            ImageUtil.readBlob(inputStream, "D:\\photo2.jpg");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (statement != null)
                        if (statement != null)
                            try {
                                statement.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                if (connection != null)
                                    try {
                                        connection.close();
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                            }
                }
            }
        }
    }

}

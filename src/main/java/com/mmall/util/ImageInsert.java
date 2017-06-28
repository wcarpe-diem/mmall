package com.mmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/28.
 */
public class ImageInsert {
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
        String user="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/mmall?characterEncoding=utf-8";
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement=null;
        InputStream inputStream=null;
        inputStream=ImageUtil.getImageByte("C:\\Users\\Administrator\\Desktop\\img.jpg");
        try {
            String sql="insert into photo(id,name,photo) values(?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"image1");
            preparedStatement.setBinaryStream(3,inputStream,inputStream.available());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

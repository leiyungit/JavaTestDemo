package com.msb.utils;

import java.sql.*;

public class MySqlDBUtil {
    private  static final String URL = "jdbc:mysql://localhost:3306/mybatisdb";
    private  static final String USERNAME = "root";
    private  static final String PASSWORD = "123456";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
           return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement statm){
        close(conn,statm,null);
    }

    public static void close(Connection conn, Statement statm, ResultSet result){
        if(result!=null) {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statm!=null) {
            try {
                statm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.msb.oracletest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        // 1、加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 2、建立连接, 两种连接方式：1、thin   2、oci
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "test");
        System.out.println(conn);
        String sql ="select * from emp";
        // 5、准备静态处理块，将sql放置在静态处理块中
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
            String ename = resultSet.getString("ename");
            System.out.println(ename);
            System.out.println("--------------");
        }
        resultSet.close();
        statement.close();
        conn.close();
    }
}

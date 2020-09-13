package com.msb.apacheDBUtil;

import com.msb.domain.User;
import com.msb.utils.MySqlDBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBUtilTest {
    private static Connection  conn ;

    public static void main(String[] args) throws SQLException {
        //testQuery();
        //testArray();
        //testMap();
        testScalar();
        // 还可以添加自定义Handler
    }

    public static void testScalar() throws SQLException {
        conn =  MySqlDBUtil.getConnection();
        System.out.println(conn);
        QueryRunner run = new QueryRunner();
        String sql = "select count(*) from user ";
        Object query = run.query(conn, sql, new ScalarHandler<>());
        System.out.println(query);
        conn.close();
    }
    public static void testMap() throws SQLException {
        conn =  MySqlDBUtil.getConnection();
        System.out.println(conn);
        QueryRunner run = new QueryRunner();
        String sql = "select * from user ";
        Map<String, Object> query = run.query(conn, sql, new MapHandler());
        Set<Map.Entry<String, Object>> entries = query.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }


        conn.close();
    }

    public static void testArray() throws SQLException {
        conn =  MySqlDBUtil.getConnection();
        System.out.println(conn);
        QueryRunner run = new QueryRunner();
        String sql = "select * from user where id = ?";
        Object[] query = run.query(conn, sql, new ArrayHandler(), 42);
        for (Object o : query) {
            System.out.println(o);
        }
        conn.close();
    }

    public static void testQuery() throws SQLException{
        conn =  MySqlDBUtil.getConnection();
        System.out.println(conn);
        QueryRunner run = new QueryRunner();
        //String sql = "select * from user where id = ?";
//        User user = run.query(conn, sql, new BeanHandler<User>(User.class), 42);
//        System.out.println(user);
        String sql = "select * from user";
        List<User> list = run.query(conn, sql, new BeanListHandler<User>(User.class));
        list.forEach(System.out::println);
        conn.close();
    }
}

package com.itcast.dao.impl;

import com.itcast.dao.EmpDao;
import com.itcast.domain.Emp;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    public List<Emp> findAll() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///runoob", "root", "123456");
            pst = conn.prepareStatement("SELECT * FROM emp");
            rs = pst.executeQuery();
            List<Emp> list = new ArrayList<Emp>();
            Emp emp = null;
            while (rs.next()){
                emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                list.add(emp);
            }
            return  list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

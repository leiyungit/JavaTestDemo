package com.itcast.test;

import com.itcast.dao.EmpDao;
import com.itcast.dao.impl.EmpDaoImpl;
import com.itcast.domain.Emp;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class EmpTest {
    @Test
    public  void findAll() throws SQLException {
        EmpDao dao = new EmpDaoImpl();
        List<Emp> list = dao.findAll();
        for (Emp emp : list) {
            System.out.println(emp.getName());
        }
    }
}

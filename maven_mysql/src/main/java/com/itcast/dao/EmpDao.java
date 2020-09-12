package com.itcast.dao;

import com.itcast.domain.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    public List<Emp> findAll() throws SQLException;
}

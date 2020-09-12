package com.itcast.dao;

import com.itcast.damain.User;

import java.util.List;

/**
 *
 */
public interface IUserDao {
    /**
     *
     * @return
     */
    public List<User> findAll();
}

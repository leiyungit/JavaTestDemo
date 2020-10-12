package com.itcast.dao;

import com.itcast.domain.Account;


import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户,同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询所有
     * @param uid
     * @return
     */
    List<Account> findAllByUid(Integer uid);
}

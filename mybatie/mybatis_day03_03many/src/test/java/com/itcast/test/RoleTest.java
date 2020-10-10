package com.itcast.test;

import com.itcast.dao.IRoleDao;
import com.itcast.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSession session;
    private IRoleDao mapper;

    @Before
    public void init() throws IOException {
        // 1、读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2、获取SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3、获取SqlSession对象
        session = factory.openSession();
        // 4、获取dao的代理对象
        mapper = session.getMapper(IRoleDao.class);
    }

    @After
    public void destory() throws IOException {
        // 提交事物
        //session.commit();
        // 释放资源
        session.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Role> roles = mapper.findAll();
        for (Role role : roles) {
            System.out.println("-------每个角色的信息--------");
            System.out.println(role);

        }
    }
}

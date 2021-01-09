package cn.dsq.customer.dao.impl;

import cn.dsq.customer.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDaoImpl userDao;
    @Before
    public void setUp(){
         userDao = new UserDaoImpl();
    }

    @Test
    public void findByName() {
        assertNotNull(userDao.findByName("何事"));
    }

    @Test
    public void save() {
        User user = new User("邓斯琪","2314362158@qq.com",18,"女","株洲市",
                "13574219351","A");
        userDao.save(user);
    }

    @Test
    public void delete() {
        User user = new User("邓斯琪","2314362158@qq.com",18,"女","株洲市",
                "13574219351","A");
        userDao.delete(user);
    }

    @Test
    public void update() {
        User user = new User("邓斯琪","2314362158@qq.com",18,"女","株洲市",
                "13574219351","A");
        userDao.update(user,"age","3");
    }
}
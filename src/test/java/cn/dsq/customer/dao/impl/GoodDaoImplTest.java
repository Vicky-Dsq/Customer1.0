package cn.dsq.customer.dao.impl;

import cn.dsq.customer.domain.Good;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodDaoImplTest {
    GoodDaoImpl goodDaoImpl;

    @Before
    public void setUp(){
        goodDaoImpl = new GoodDaoImpl();
    }
    @Test
    public void findById() {
        Good good = goodDaoImpl.findById(20);
        assertNotNull(good);
    }

    @Test
    public void findByName() {
        Good good = goodDaoImpl.findByName("雷神c8dbeZ");
        assertNotNull(good);
    }

    @Test
    public void save() {
        Good good = new Good(100000,"华为P20",13849);
        goodDaoImpl.save(good);
    }

    @Test
    public void findByNameId() {
        Good good = goodDaoImpl.findByNameId("雷神c8dbeZ",19);
        assertNotNull(good);
    }

    @Test
    public void delete() {
        Good good =new Good(100000,"华为P20",13849);
                goodDaoImpl.delete(good);
    }

    @Test
    public void update() {
        Good good = goodDaoImpl.findById(20);
        goodDaoImpl.update(good,"name","苹果6s");
    }
}
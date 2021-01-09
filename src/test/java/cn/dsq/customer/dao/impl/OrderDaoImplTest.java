package cn.dsq.customer.dao.impl;

import cn.dsq.customer.domain.Order;
import cn.dsq.customer.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDaoImpl orderDao;
    @Before
    public void setUp(){
        orderDao = new OrderDaoImpl();
    }

    @Test
    public void findByCusnameGid() {
        assertNotNull(orderDao.findByCusnameGid("张和",9243));
    }

    @Test
    public void save() {
        Order order = new Order("何东休","18895789907","吉林省","戴尔sV20Sl6",1,1,
                23333);
        orderDao.save(order);
    }

    @Test
    public void delete() {
        Order order = new Order("何东休","18895789907","吉林省","戴尔sV20Sl6",1,1,
                23333);
        User user = new UserDaoImpl().findByName(order.getCusname());
        orderDao.delete(user);
    }
}
package cn.dsq.customer.dao;

import cn.dsq.customer.domain.Order;
import cn.dsq.customer.domain.User;

public interface OrderDao {
    Order findByCusnameGid(String cusname,int goodid);

    void save(Order o);

    void delete(User user);
}

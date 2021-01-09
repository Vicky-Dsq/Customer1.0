package cn.dsq.customer.service.impl;

import cn.dsq.customer.dao.OrderDao;
import cn.dsq.customer.dao.impl.OrderDaoImpl;
import cn.dsq.customer.domain.Order;
import cn.dsq.customer.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderDao oserDao =  new OrderDaoImpl();

    /**
     * 如果订单信息无误，保存订单信息
     * @param order
     * @return
     */
    @Override
    public boolean regist(Order order) {
        Order o=null;
        o=oserDao.findByCusnameGid(order.getCusname(),order.getGoodid());
        if(o!=null){
            System.out.println("order");
            return false;
        }
        oserDao.save(order);
        return true;
    }
}

package cn.dsq.customer.dao.impl;

import cn.dsq.customer.dao.OrderDao;
import cn.dsq.customer.domain.Order;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 实现OrderDao接口
 * 对订单进行操作
 */
public class OrderDaoImpl implements OrderDao {
    private static JdbcTemplate template =
            new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过订单的客户姓名和商品编号查找订单
     * @param cusname
     * @param goodid
     * @return
     */
    @Override
    public Order findByCusnameGid(String cusname,int goodid) {
        Order order=null;
        try {
            //定义SQL语句
            String sql="select * from tab_order where cusname=? and goodid=?";
            //执行SQL语句
            //queryForObject 方法需要传入三个参数，第一个参数是该方法需要执行的SQL语句
            //        数组params为执行动态SQL时需要传入的参数，参数顺序与SQL中的参数顺序相同。
            //        最后一个参数是返回值的类型（只能是基本数据类型的封装类，如Integer、String）
            order = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Order>(Order.class),cusname,goodid);
        } catch (Exception e) {
        }
        return order;
    }

    /**
     * 添加订单
     * @param o
     */
    @Override
    public void save(Order o) {
        //1.定义sql
        String sql = "insert into tab_order values(?,?,?)";
        //2.执行sql

        template.update(sql,
                o.getCusname(),
        o.getGoodid(),
        o.getGoodnum()
        );
    }

    /**
     * 删除客户信息
     * @param user
     */
    @Override
    public void delete(User user) {
        String sql = "delete from tab_order where cusname=?";
        template.update(sql,user.getName());
    }
}

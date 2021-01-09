package cn.dsq.customer.util;

import cn.dsq.customer.dao.GoodDao;
import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.GoodDaoImpl;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.Good;
import cn.dsq.customer.domain.Order;
import cn.dsq.customer.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * 显示表，工具类
 */
public class ShowTable {
    /**
     * 得到客户表的数据
     * @param sql
     * @return
     */
    public static Vector<Vector<Object>> getCustomer(String sql){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        class MyRowMapper implements RowMapper {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                user.setPlace(resultSet.getString("place"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
                user.setGrade(resultSet.getString("grade"));
                return user;
            }
        }
        List<User> list = jdbcTemplate.query(sql,new MyRowMapper());
        Vector<Vector<Object>> contextList = new Vector<>();
        for(User u:list) {
            Vector<Object> v = new Vector<>();
            v.add(u.getName());
            v.add(u.getAge());
            v.add(u.getSex());
            v.add(u.getPlace());
            v.add(u.getPhone());
            v.add(u.getEmail());
            v.add(u.getGrade());
            contextList.add(v);
        }
        return contextList;
    }

    /**
     * 得到客户表的表头
     * @return
     */
    public static Vector<Object> getCusTitle(){
        Vector<Object> titleList = new Vector<>();
        titleList.add("name");
        titleList.add("age");
        titleList.add("sex");
        titleList.add("place");
        titleList.add("phone");
        titleList.add("email");
        titleList.add("grade");
        return titleList;
    }

    /**
     * 得到商品表的信息
     * @param sql
     * @return
     */
    public static Vector<Vector<Object>> getGoods(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        class MyRowMapper implements RowMapper {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Good good = new Good();
                good.setId(resultSet.getInt("id"));
                good.setName(resultSet.getString("name"));
                good.setPrice(resultSet.getInt("price"));
                return good;
            }
        }
        List<Good> list = jdbcTemplate.query(sql,new MyRowMapper());
        Vector<Vector<Object>> contextList = new Vector<>();
        for(Good g:list) {
            Vector<Object> v = new Vector<>();
            v.add(g.getId());
            v.add(g.getName());
            v.add(g.getPrice());
            contextList.add(v);
        }
        return contextList;
    }

    /**
     * 得到商品表的表头
     * @return
     */
    public static Vector<Object> getGoodTitile() {
        Vector<Object> titleList = new Vector<>();
        titleList.add("编号");
        titleList.add("商品名称");
        titleList.add("单价");
        return titleList;
    }

    /**
     * 得到订单表的信息
     * @param sql
     * @return
     */
    public static Vector<Vector<Object>> getOrder(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        class MyRowMapper implements RowMapper {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setCusname(resultSet.getString("cusname"));
                order.setPhone(resultSet.getString("phone"));
                order.setPlace(resultSet.getString("place"));
                order.setName(resultSet.getString("name"));
                order.setGoodnum(resultSet.getInt("goodnum"));
                order.setAllprice(resultSet.getInt("allprice"));
                return order;
            }
        }
        List<Order> list = jdbcTemplate.query(sql,new MyRowMapper());
        Vector<Vector<Object>> contextList = new Vector<>();
        for(Order o:list) {
            Vector<Object> v = new Vector<>();
            v.add(o.getCusname());
            v.add(o.getPhone());
            v.add(o.getPlace());
            v.add(o.getName());
            v.add(o.getGoodnum());
            v.add(o.getAllprice());
            contextList.add(v);
        }
        return contextList;
    }
    /**
     * 得到订单表的表头
     * @return
     */
    public static Vector<Object> getOrderTitile() {
        Vector<Object> titleList = new Vector<>();
        titleList.add("客户姓名");
        titleList.add("客户电话");
        titleList.add("客户地址");
        titleList.add("所购商品名");
        titleList.add("购买该商品的数量");
        titleList.add("购买该商品的总价");
        return titleList;
    }

}

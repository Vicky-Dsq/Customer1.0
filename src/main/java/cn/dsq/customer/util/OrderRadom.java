package cn.dsq.customer.util;

import cn.dsq.customer.domain.Order;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.service.OrderService;
import cn.dsq.customer.service.impl.OrderServiceImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

/**
 * 随机生成10010条订单信息
 */
public class OrderRadom {
    private static JdbcTemplate template =
        new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) throws IOException {
        String sql ="SELECT name FROM tab_user ORDER BY RAND() LIMIT 1";
        OrderService orderService = new OrderServiceImpl();
       //File f = new File("C:\\Users\\86135\\Desktop\\Java课设\\订单.txt");
        //Writer writer = new FileWriter(f);
        int m=10010;
        for(int i=0;i<m;i++) {
            String name = template.queryForObject(sql,
                    String.class);
            Random random = new Random();
            int id = random.nextInt(10000) + 1;
            int num = random.nextInt(1000) + 1;
            Order order = new Order();
            order.setCusname(name);
            order.setGoodid(id);
            order.setGoodnum(num);
            System.out.println(name+" "+id+" "+num);
            if (!orderService.regist(order)) {
                m++;
            }
        }

//            writer.write(name + "\t");
//            writer.write(id + "\t");
//            writer.write(num+"\n");
//            writer.flush();
//        }
//        writer.close();

        }
    }

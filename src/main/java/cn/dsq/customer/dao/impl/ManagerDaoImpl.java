package cn.dsq.customer.dao.impl;

import cn.dsq.customer.dao.ManagerDao;
import cn.dsq.customer.domain.Manager;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 实现ManagerDao接口
 * 对管理员进行操作
 *
 * （由于管理员数据较少，改用文本文件存储用户名，密码）
 * （主程序中该类未被调用）
 * @author
 */
public class ManagerDaoImpl implements ManagerDao {
    private static JdbcTemplate template =
            new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过用户名查找管理员
     * @param maName
     * @return
     */
    @Override
    public Manager findByName(String maName) {
        Manager manager=null;
       try {
           String sql = "select * from tab_manager where maName=?";
           manager = template.queryForObject(sql,
                   new BeanPropertyRowMapper<Manager>(Manager.class),
                   maName);
       }
       catch (Exception e){
       }
       return manager;
    }

    /**
     * 添加管理员信息
      * @param manager
     * @return
     */
    @Override
    public void save(Manager manager) {
        String sql = "insert into tab_manager values(?,?)";
        template.update(sql,manager.getMaName(),manager.getMaPassword());
    }

    /**
     * 通过用户名和密码查找管理员
     * @param maName
     * @param maPassword
     * @return
     */
    @Override
    public Manager findByNameAndPassword(String maName,String maPassword) {
       // System.out.println(maName+","+maPassword+"\n");
        Manager manager=null;
        try {
            String sql = "select * from tab_manager where maName=? and " +
                    "maPassword=?";
            manager = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Manager>(Manager.class),
                    maName,maPassword);
        }
        catch (Exception e){
        }
        return manager;
    }
}

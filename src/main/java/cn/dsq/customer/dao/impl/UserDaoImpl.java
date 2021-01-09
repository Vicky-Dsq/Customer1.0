package cn.dsq.customer.dao.impl;
import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 实现UserDao接口
 * 对客户进行操作
 */
public class UserDaoImpl implements UserDao {

    private static JdbcTemplate template =
            new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 通过客户名称查找客户
     * @param name
     * @return
     */
    @Override
    public User findByName(String name) {
        User user=null;
        try {
            //定义SQL语句
            String sql="select * from tab_user where name=?";
            //执行SQL语句
            //queryForObject 方法需要传入三个参数，第一个参数是该方法需要执行的SQL语句
            //        数组params为执行动态SQL时需要传入的参数，参数顺序与SQL中的参数顺序相同。
            //        最后一个参数是返回值的类型（只能是基本数据类型的封装类，如Integer、String）
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),name);
        } catch (Exception e) {
        }
        return user;
    }

    /**
     * 添加用户信息
     * @param user
     */
    @Override
    public void save(User user) {
        //1.定义sql
        String sql = "insert into tab_user values(?,?,?,?,?,?,?)";
        //2.执行sql

        template.update(sql, user.getName(),
                user.getAge(),
                user.getSex(),
                user.getPlace(),
                user.getPhone(),
                user.getEmail(),
                user.getGrade()
        );
    }

    /**
     * 删除客户信息
     * @param user
     */
        @Override
        public void delete(User user){
            String sql = "delete from tab_user where name=?";
            template.update(sql,user.getName());
        }

    /**
     * 修改客户信息
     * @param user
     * @param change
     * @param replace
     */
    @Override
    public void update(User user,String change,String replace) {
        String sql = "update tab_user set "+change+" = ? where name = ?";
        if(change.equals("age")){
            int re =Integer.parseInt(replace);
            template.update(sql,re,user.getName());
        }
        else
        template.update(sql,replace,user.getName());
    }

}

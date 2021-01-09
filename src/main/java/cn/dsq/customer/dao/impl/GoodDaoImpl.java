package cn.dsq.customer.dao.impl;

import cn.dsq.customer.dao.GoodDao;
import cn.dsq.customer.domain.Good;
import cn.dsq.customer.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *实现GoodDao接口
 * 对商品进行操作
 */
public class GoodDaoImpl implements GoodDao {
    private static JdbcTemplate template =
            new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 通过编号查找商品
     * @param id
     * @author dsq
     * @return
     */
    @Override
    public Good findById(int id) {
        Good good=null;
        try {
            String sql = "select * from tab_good where id=?";
            good = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Good>(Good.class),
                    id);
        }
        catch (Exception e){
        }
        return good;
    }
    
    /**
     * 通过商品名称查找商品
     * @param name
     * @return
     */
    @Override
    public Good findByName(String name) {
        String sql="select * from tab_good where name=?";
        Good good=null;
        try {
            good=template.queryForObject(sql,
                    new BeanPropertyRowMapper<Good>(Good.class),
                    name);
        }catch (Exception e){
        }
        return good;
    }


    /**
     * 添加商品信息
     * @param good
     */
    @Override
    public void save(Good good) {
        String sql="insert into tab_good values(?,?,?)";
        template.update(sql,good.getId(),good.getName(),good.getPrice());
    }

    /**
     * 通过商品名称和编号查找商品
     * @param name
     * @param id
     * @return
     */
    @Override
    public Good findByNameId(String name,int id) {
        Good good=null;
        good = this.findById(id);
        if(good==null)
        good = this.findByName(name);
        return good;
    }

    /**
     * 通过商品编号查找商品
     * @param good
     */
    @Override
    public void delete(Good good) {
        String sql = "delete from tab_good where id=?";
        template.update(sql,good.getId());
    }

    /**
     * 通过商品编号修改商品信息
     * @param good
     * @param change
     * @param replace
     */
    @Override
    public void update(Good good, String change, String replace) {
        String sql = "update tab_good set "+change+" = ? where id = ?";
        if(change.equals("price")){
            int re =Integer.parseInt(replace);
            template.update(sql,re,good.getId());
        }
        else
            template.update(sql,replace,good.getId());
    }
}

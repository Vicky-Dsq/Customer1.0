package cn.dsq.customer.dao;

import cn.dsq.customer.domain.Good;
import cn.dsq.customer.domain.User;

public interface GoodDao {
    public Good findById(int id);
    public Good findByName(String name);
    public void save(Good good);
    public Good findByNameId(String name,int id);
    public void delete(Good good);
    public void update(Good good, String change, String replace);
}

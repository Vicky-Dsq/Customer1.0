package cn.dsq.customer.dao;

import cn.dsq.customer.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    public User findByName(String name);

    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    public void delete(User user);

    void update(User user,String change,String replace);
}

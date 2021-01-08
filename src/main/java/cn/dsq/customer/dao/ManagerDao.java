package cn.dsq.customer.dao;


import cn.dsq.customer.domain.Manager;

public interface ManagerDao {
    public Manager findByName(String maName);
    public void save(Manager manager);
    Manager findByNameAndPassword(String maName,String maPassword);
}

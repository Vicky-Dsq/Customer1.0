package cn.dsq.customer.service.impl;
import cn.dsq.customer.dao.ManagerDao;
import cn.dsq.customer.dao.impl.ManagerDaoImpl;
import cn.dsq.customer.domain.Manager;
import cn.dsq.customer.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public boolean regist(Manager manager) {
        Manager m=null;
        m=managerDao.findByName(manager.getMaName());
        if(m!=null){
            System.out.println("有重复");
            return false;
        }
        managerDao.save(manager);
        return true;
    }
}

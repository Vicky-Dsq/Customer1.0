package cn.dsq.customer.service.impl;

import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 如果客户信息无误，保存客户信息
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u=null;
        u=userDao.findByName(user.getName());
        if(u!=null){
            System.out.println("有重复");
            return false;
        }
        userDao.save(user);
        return true;
    }

}

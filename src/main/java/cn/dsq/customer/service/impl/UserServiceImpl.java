package cn.dsq.customer.service.impl;

import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.service.UserService;
import cn.dsq.customer.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
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

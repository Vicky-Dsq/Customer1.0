package cn.dsq.customer.service.impl;

import cn.dsq.customer.dao.GoodDao;
import cn.dsq.customer.dao.impl.GoodDaoImpl;
import cn.dsq.customer.domain.Good;
import cn.dsq.customer.service.GoodService;

public class GoodServiceImpl implements GoodService {
    public GoodDao goodDao = new GoodDaoImpl();

    /**
     * 如果商品信息无误，保存商品信息
     * @param good
     * @param id
     * @return
     */
    @Override
    public boolean register(Good good,int id) {
        Good g = new Good();
        g = goodDao.findByNameId(good.getName(),good.getId());
        if(g!=null){
            System.out.println("有重复");
            return false;
        }
        good.setId(id);
        goodDao.save(good);
        return true;
    }
}

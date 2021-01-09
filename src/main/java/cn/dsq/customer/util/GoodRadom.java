package cn.dsq.customer.util;

import cn.dsq.customer.domain.Good;
import cn.dsq.customer.service.GoodService;
import cn.dsq.customer.service.UserService;
import cn.dsq.customer.service.impl.GoodServiceImpl;
import cn.dsq.customer.service.impl.UserServiceImpl;

import java.util.Random;

/**
 * 随机生成10010条商品信息
 */
public class GoodRadom {

    public static void main(String[] args) {
        Good good = new Good();
        GoodService service=new GoodServiceImpl();

        Random random=new Random();

        String[] compuName={"联想","华硕","戴尔","惠普","神舟","小米","雷神","炫龙",
                "苹果","火影"};

        for(int j=1;j<=10010;j++) {
            String name = "";
            name += compuName[random.nextInt(compuName.length)];

            for (int i = 0; i < (random.nextInt(3) + 6); i++) {
                int num = random.nextInt(3);
                char a = (char) (random.nextInt(26) + 65);
                char b = (char) (random.nextInt(26) + 97);
                char c = (char) (random.nextInt(10) + 48);
                if (num == 0 && i != 0)
                    name += c;
                else if (num == 1)
                    name += a;
                else {
                    name += b;
                }
            }
            System.out.println(name);
            int price =random.nextInt(10000)+3000;
            System.out.println(price);
            GoodService goodService = new GoodServiceImpl();
            good.setName(name);
            good.setPrice(price);
            if(!goodService.register(good,j)) {
                j--;
            }
        }
    }

}

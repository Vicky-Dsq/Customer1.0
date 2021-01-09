package cn.dsq.customer.domain;

/**
 * 订单类
 */
public class Order {
    private String cusname;
    private String phone;
    private String place;
    private String name;
    private int goodid;
    private int goodnum;
    private int allprice;

    public Order() {
    }

    public Order(String cusname, String phone, String place, String name, int goodid, int goodnum, int allprice) {
        this.cusname = cusname;
        this.phone = phone;
        this.place = place;
        this.name = name;
        this.goodid = goodid;
        this.goodnum = goodnum;
        this.allprice = allprice;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(int goodnum) {
        this.goodnum = goodnum;
    }

    public int getAllprice() {
        return allprice;
    }

    public void setAllprice(int allprice) {
        this.allprice = allprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cusname='" + cusname + '\'' +
                ", phone='" + phone + '\'' +
                ", place='" + place + '\'' +
                ", name='" + name + '\'' +
                ", goodid=" + goodid +
                ", goodnum=" + goodnum +
                ", allprice=" + allprice +
                '}';
    }
}

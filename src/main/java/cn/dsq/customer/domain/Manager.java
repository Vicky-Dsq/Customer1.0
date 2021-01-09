package cn.dsq.customer.domain;
/**
 * 管理员类
 */
public class Manager {
    private String maName;
    private String maPassword;

    public Manager() {
    }

    public Manager(String maName, String maPassword) {
        this.maName = maName;
        this.maPassword = maPassword;
    }

    public String getMaName() {
        return maName;
    }

    public void setMaName(String maName) {
        this.maName = maName;
    }

    public String getMaPassword() {
        return maPassword;
    }

    public void setMaPassword(String maPassword) {
        this.maPassword = maPassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "maName='" + maName + '\'' +
                ", maPassword='" + maPassword + '\'' +
                '}';
    }
}

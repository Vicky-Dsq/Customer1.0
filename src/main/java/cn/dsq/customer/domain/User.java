package cn.dsq.customer.domain;

/**
 * 客户类
 */
public class User {
    private String name;
    private String email;
    private int age;
    private String sex;
    private String place;
    private String phone;
    private String grade;

    public User() {
    }

    public User(String name, String email, int age, String sex, String place,
                String phone, String grade) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.place = place;
        this.phone = phone;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", place='" + place + '\'' +
                ", phone='" + phone + '\'' +
                ", grade='" + grade +'\'' +
                '}';
    }
}

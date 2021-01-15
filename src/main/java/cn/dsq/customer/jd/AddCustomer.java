/*
 * Created by JFormDesigner on Wed Jan 06 15:21:36 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.service.UserService;
import cn.dsq.customer.service.impl.UserServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * 添加客户信息界面
 * @author 1
 */
public class AddCustomer extends JFrame {

    public AddCustomer() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(addName.getText().equals("")||addAge.getText().equals("")||addSex.getText().equals("")||addPlace.getText().equals("")||addPhone.getText().equals("")||addEmail.getText().equals("")||addGrade.getText().equals("")){
            idea.setText("请输入正确信息！");
            return ;
        }
        User user = new User();
        String name=addName.getText();
       user.setName(name);
        user.setAge(Integer.parseInt(addAge.getText()));
        user.setSex(addSex.getText());
        user.setPlace(addPlace.getText());
        user.setPhone(addPhone.getText());
        user.setEmail(addEmail.getText());
        user.setGrade(addGrade.getText());
        UserService userService = new UserServiceImpl();
        if(userService.regist(user)){
            JOptionPane.showMessageDialog(null,
                    "添加成功！");
        }else {
           JOptionPane.showMessageDialog(null,
                    "添加失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        addName = new JTextField();
        addAge = new JTextField();
        addSex = new JTextField();
        addPlace = new JTextField();
        addPhone = new JTextField();
        addEmail = new JTextField();
        addGrade = new JTextField();
        button1 = new JButton();
        idea = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        setTitle(bundle.getString("this.title_8"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_5"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(150, 130), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_4"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(150, 175, 60, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_4"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label3);
        label3.setBounds(150, 220, 65, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_2"));
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label4);
        label4.setBounds(150, 260, 65, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_2"));
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(150, 305), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText(bundle.getString("label6.text_2"));
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label6);
        label6.setBounds(150, 350, 65, label6.getPreferredSize().height);

        //---- label7 ----
        label7.setText(bundle.getString("label7.text_2"));
        label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label7);
        label7.setBounds(150, 395, 65, label7.getPreferredSize().height);

        //---- label8 ----
        label8.setText(bundle.getString("label8.text_2"));
        label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        contentPane.add(label8);
        label8.setBounds(210, 60, 210, 35);
        contentPane.add(addName);
        addName.setBounds(230, 135, 170, 30);
        contentPane.add(addAge);
        addAge.setBounds(230, 180, 170, 30);
        contentPane.add(addSex);
        addSex.setBounds(230, 225, 170, 30);
        contentPane.add(addPlace);
        addPlace.setBounds(230, 265, 170, 30);
        contentPane.add(addPhone);
        addPhone.setBounds(230, 310, 170, 30);
        contentPane.add(addEmail);
        addEmail.setBounds(230, 355, 170, 30);
        contentPane.add(addGrade);
        addGrade.setBounds(230, 395, 170, 30);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(245, 480, 105, 45);
        contentPane.add(idea);
        idea.setBounds(245, 440, 105, 35);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField addName;
    private JTextField addAge;
    private JTextField addSex;
    private JTextField addPlace;
    private JTextField addPhone;
    private JTextField addEmail;
    private JTextField addGrade;
    private JButton button1;
    private JLabel idea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

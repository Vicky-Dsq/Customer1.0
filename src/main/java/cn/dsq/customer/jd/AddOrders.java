/*
 * Created by JFormDesigner on Thu Jan 07 21:21:24 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.OrderDao;
import cn.dsq.customer.domain.Order;
import cn.dsq.customer.service.OrderService;
import cn.dsq.customer.service.impl.OrderServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author 1
 */
public class AddOrders extends JFrame {
    public AddOrders() {
        initComponents();
    }

    private void addActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(cusnameField.getText().equals("")||goodidField.getText().equals("")||goodnumField.getText().equals("")){
            idea.setText("请输入正确信息！");
            return ;
        }
        String cusname = cusnameField.getText();
        int goodid = Integer.parseInt(goodidField.getText());
        int goodnum = Integer.parseInt(goodnumField.getText());
        System.out.println(cusname);
        System.out.println(goodid);
        System.out.println(goodnum);

        Order order = new Order();
        order.setCusname(cusname);
        order.setGoodid(goodid);
        order.setGoodnum(goodnum);
        OrderService orderService = new OrderServiceImpl();
        if(!orderService.regist(order)){
            JOptionPane.showMessageDialog(null,"添加失败！");
        }else {
            JOptionPane.showMessageDialog(null,"添加成功！");
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        cusnameField = new JTextField();
        goodidField = new JTextField();
        goodnumField = new JTextField();
        idea = new JLabel();
        add = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(700, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_15"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
        contentPane.add(label1);
        label1.setBounds(245, 55, 168, 37);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_10"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label2);
        label2.setBounds(180, 135, 120, 40);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_10"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label3);
        label3.setBounds(135, 210, 160, 29);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_6"));
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label4);
        label4.setBounds(135, 280, 175, 29);
        contentPane.add(cusnameField);
        cusnameField.setBounds(305, 135, 170, 35);
        contentPane.add(goodidField);
        goodidField.setBounds(305, 205, 170, 35);
        contentPane.add(goodnumField);
        goodnumField.setBounds(305, 285, 170, 35);
        contentPane.add(idea);
        idea.setBounds(290, 345, 155, 30);

        //---- add ----
        add.setText(bundle.getString("add.text_7"));
        add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        add.addActionListener(e -> addActionPerformed(e));
        contentPane.add(add);
        add.setBounds(290, 375, 125, 50);

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
    private JTextField cusnameField;
    private JTextField goodidField;
    private JTextField goodnumField;
    private JLabel idea;
    private JButton add;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

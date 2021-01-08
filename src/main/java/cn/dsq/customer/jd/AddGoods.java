/*
 * Created by JFormDesigner on Thu Jan 07 18:12:14 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.GoodDao;
import cn.dsq.customer.dao.impl.GoodDaoImpl;
import cn.dsq.customer.domain.Good;
import cn.dsq.customer.service.GoodService;
import cn.dsq.customer.service.impl.GoodServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author 1
 */
public class AddGoods extends JFrame {
    public AddGoods() {
        initComponents();
    }

    private void addActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(idField.getText().equals("")||nameField.getText().equals("")||priceField.getText().equals("")){
             idea.setText("请输入正确信息！");
            return;
        }
        int id = Integer.parseInt(idField.getText());
        String name= nameField.getText();
        int price = Integer.parseInt(priceField.getText());
        GoodService goodService = new GoodServiceImpl();
        Good g = new Good();
        g.setId(id);
        g.setName(name);
        g.setPrice(price);
       if(!goodService.register(g,id)){
           JOptionPane.showMessageDialog(null,
                   "添加失败！");
        }else {
           JOptionPane.showMessageDialog(null,
                   "添加成功！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        idField = new JTextField();
        nameField = new JTextField();
        priceField = new JTextField();
        add = new JButton();
        idea = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(700, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_13"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(245, 55), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_7"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label2);
        label2.setBounds(180, 135, 120, 40);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_7"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(180, 210), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_4"));
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(180, 280), label4.getPreferredSize()));
        contentPane.add(idField);
        idField.setBounds(305, 135, 170, 35);
        contentPane.add(nameField);
        nameField.setBounds(305, 205, 170, 35);
        contentPane.add(priceField);
        priceField.setBounds(305, 280, 170, 35);

        //---- add ----
        add.setText(bundle.getString("add.text_7"));
        add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        add.addActionListener(e -> addActionPerformed(e));
        contentPane.add(add);
        add.setBounds(290, 375, 100, 40);
        contentPane.add(idea);
        idea.setBounds(290, 335, 100, 25);

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
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JButton add;
    private JLabel idea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Thu Jan 07 20:00:43 GMT+08:00 2021
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
 * 修改商品信息界面
 * @author 1
 */
public class UpdateGoods extends JFrame {
    public UpdateGoods() {
        initComponents();
    }

    private void updategoodActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(updateId.getText().equals("")){
            idea.setText("请输入要修改的商品的编号！");
            return;
        }
        int id  = Integer.parseInt(updateId.getText());
        GoodDao goodDao = new GoodDaoImpl();
        Good good = new Good();
        good = goodDao.findById(id);
        String change = null;
        if(g1.isSelected()){
            change = "name";
        }else if(g2.isSelected()){
            change = "price";
        }
        String replace = updateField.getText();
        if(good!=null){
            goodDao.update(good,change,replace);
            JOptionPane.showMessageDialog(null,"修改成功！");
        }else{
            JOptionPane.showMessageDialog(null,"修改失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label2 = new JLabel();
        label3 = new JLabel();
        updateId = new JTextField();
        label4 = new JLabel();
        g1 = new JRadioButton();
        g2 = new JRadioButton();
        updateField = new JTextField();
        label5 = new JLabel();
        idea = new JLabel();
        updategood = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_9"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        contentPane.add(label2);
        label2.setBounds(205, 60, 200, 34);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_9"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label3);
        label3.setBounds(110, 135, 295, 24);
        contentPane.add(updateId);
        updateId.setBounds(220, 170, 140, 30);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_5"));
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label4);
        label4.setBounds(110, 220, 210, 24);

        //---- g1 ----
        g1.setText(bundle.getString("g1.text_2"));
        contentPane.add(g1);
        g1.setBounds(170, 265, 95, 19);

        //---- g2 ----
        g2.setText(bundle.getString("g2.text_2"));
        contentPane.add(g2);
        g2.setBounds(300, 265, 70, 19);
        contentPane.add(updateField);
        updateField.setBounds(225, 295, 130, 30);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_3"));
        contentPane.add(label5);
        label5.setBounds(120, 300, 105, 25);
        contentPane.add(idea);
        idea.setBounds(190, 345, 200, 30);

        //---- updategood ----
        updategood.setText(bundle.getString("updategood.text_3"));
        updategood.addActionListener(e -> updategoodActionPerformed(e));
        contentPane.add(updategood);
        updategood.setBounds(230, 375, 100, 35);

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
        ButtonGroup group = new ButtonGroup();
        group.add(g1);
        group.add(g2);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JLabel label3;
    private JTextField updateId;
    private JLabel label4;
    private JRadioButton g1;
    private JRadioButton g2;
    private JTextField updateField;
    private JLabel label5;
    private JLabel idea;
    private JButton updategood;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

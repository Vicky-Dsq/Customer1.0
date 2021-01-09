/*
 * Created by JFormDesigner on Thu Jan 07 22:14:54 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.domain.Manager;
import cn.dsq.customer.util.SetManager;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

/**
 * 添加管理员信息界面
 * @author 1
 */
public class AddManager extends JFrame {

    public AddManager() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void addActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
        if(maNameField.getText().equals("")||maPasswordField.getPassword().equals("")){
            idea.setText("请输入正确信息！");
            return ;
        }
        if(SetManager.addManager(maNameField.getText(),
                new String(maPasswordField.getPassword()))){
            JOptionPane.showMessageDialog(null,"添加成功！");
        }else{
            JOptionPane.showMessageDialog(null,"添加失败！");
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label8 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        maNameField = new JTextField();
        add = new JButton();
        idea = new JLabel();
        maPasswordField = new JPasswordField();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label8 ----
        label8.setText(bundle.getString("label8.text_3"));
        label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        contentPane.add(label8);
        label8.setBounds(210, 60, 210, 35);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_16"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label1);
        label1.setBounds(140, 150, 85, 27);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_11"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(140, 240, 80, 27);
        contentPane.add(maNameField);
        maNameField.setBounds(225, 155, 135, 30);

        //---- add ----
        add.setText(bundle.getString("add.text_7"));
        add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        add.addActionListener(e -> {
			button1ActionPerformed(e);
            try {
                addActionPerformed(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(add);
        add.setBounds(240, 340, 105, 45);
        contentPane.add(idea);
        idea.setBounds(240, 300, 105, 30);
        contentPane.add(maPasswordField);
        maPasswordField.setBounds(225, 240, 130, 30);

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
    private JLabel label8;
    private JLabel label1;
    private JLabel label2;
    private JTextField maNameField;
    private JButton add;
    private JLabel idea;
    private JPasswordField maPasswordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

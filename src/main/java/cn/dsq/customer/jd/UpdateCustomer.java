/*
 * Created by JFormDesigner on Wed Jan 06 16:37:00 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.User;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author 1
 */
public class UpdateCustomer extends JFrame {
    public UpdateCustomer() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(updateName.getText().equals("")){
            idea.setText("请输入要修改信息的客户的姓名！");
            return;
        }
        String name=updateName.getText();
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user = userDao.findByName(name);
        String change = null;
        if(rb1.isSelected()){
            change="age";
        }else if(rb2.isSelected()){
            change="place";
        }else if(rb3.isSelected()){
            change="phone";
        }else if(rb4.isSelected()){
            change="email";
        }else if(rb5.isSelected()){
            change="grade";
        }
        String replace = replaceField.getText();

        if(user!=null){
            userDao.update(user,change,replace);
            JOptionPane.showMessageDialog(null,"修改成功！");
        }else{
            JOptionPane.showMessageDialog(null,"修改失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        updateName = new JTextField();
        button1 = new JButton();
        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        rb4 = new JRadioButton();
        rb5 = new JRadioButton();
        label3 = new JLabel();
        replaceField = new JTextField();
        label4 = new JLabel();
        idea = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_9"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(210, 60), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_6"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(105, 130), label2.getPreferredSize()));
        contentPane.add(updateName);
        updateName.setBounds(215, 160, 140, 30);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_4"));
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
        contentPane.add(button1);
        button1.setBounds(245, 380, 84, 30);

        //---- rb1 ----
        rb1.setText(bundle.getString("rb1.text"));
        contentPane.add(rb1);
        rb1.setBounds(new Rectangle(new Point(120, 245), rb1.getPreferredSize()));

        //---- rb2 ----
        rb2.setText(bundle.getString("rb2.text"));
        contentPane.add(rb2);
        rb2.setBounds(new Rectangle(new Point(185, 245), rb2.getPreferredSize()));

        //---- rb3 ----
        rb3.setText(bundle.getString("rb3.text"));
        contentPane.add(rb3);
        rb3.setBounds(new Rectangle(new Point(255, 245), rb3.getPreferredSize()));

        //---- rb4 ----
        rb4.setText(bundle.getString("rb4.text"));
        contentPane.add(rb4);
        rb4.setBounds(new Rectangle(new Point(325, 245), rb4.getPreferredSize()));

        //---- rb5 ----
        rb5.setText(bundle.getString("rb5.text"));
        contentPane.add(rb5);
        rb5.setBounds(new Rectangle(new Point(395, 245), rb5.getPreferredSize()));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_6"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(110, 210), label3.getPreferredSize()));
        contentPane.add(replaceField);
        replaceField.setBounds(225, 280, 130, 30);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_3"));
        contentPane.add(label4);
        label4.setBounds(115, 285, label4.getPreferredSize().width, 25);
        contentPane.add(idea);
        idea.setBounds(200, 345, 200, 30);

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
    private JTextField updateName;
    private JButton button1;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JRadioButton rb5;
    private JLabel label3;
    private JTextField replaceField;
    private JLabel label4;
    private JLabel idea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

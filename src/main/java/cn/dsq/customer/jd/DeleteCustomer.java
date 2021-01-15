/*
 * Created by JFormDesigner on Wed Jan 06 16:16:25 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.OrderDao;
import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.OrderDaoImpl;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.Order;
import cn.dsq.customer.domain.User;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * 删除客户界面
 * @author 1
 */
public class DeleteCustomer extends JFrame {
    public DeleteCustomer() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(deleteName.getText().equals("")){
            idea.setText("请输入要删除的客户的姓名！");
            return;
        }
        String name=deleteName.getText();
        UserDao userDao = new UserDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        User user = new User();
        user = userDao.findByName(name);
        if(user!=null){
            userDao.delete(user);
            orderDao.delete(user);
            JOptionPane.showMessageDialog(null,"添加成功！");
        }else{
            JOptionPane.showMessageDialog(null,"添加失败！");
        }
    }

    private void deleteActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        deleteName = new JTextField();
        delete = new JButton();
        label3 = new JLabel();
        idea = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        setTitle(bundle.getString("this.title_11"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_8"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(210, 60), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_5"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(95, 120), label2.getPreferredSize()));
        contentPane.add(deleteName);
        deleteName.setBounds(210, 185, 165, 40);

        //---- delete ----
        delete.setText(bundle.getString("delete.text_3"));
        delete.addActionListener(e -> {
			button1ActionPerformed(e);
			deleteActionPerformed(e);
		});
        contentPane.add(delete);
        delete.setBounds(255, 275, 89, 39);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_5"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(150, 145), label3.getPreferredSize()));
        contentPane.add(idea);
        idea.setBounds(200, 240, 215, 25);

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
    private JTextField deleteName;
    private JButton delete;
    private JLabel label3;
    private JLabel idea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Thu Jan 07 18:42:55 GMT+08:00 2021
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
public class DeleteGoods extends JFrame {
    public DeleteGoods() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(deleteField.getText().equals("")){
            idea.setText("请输入要删除的商品的编号！");
            return;
        }
        int id  = Integer.parseInt(deleteField.getText());
        GoodDao goodDao = new GoodDaoImpl();
        Good good = new Good();
        good = goodDao.findById(id);
        if(good!=null){
            goodDao.delete(good);
            JOptionPane.showMessageDialog(null,"添加成功！");
        }else {
            JOptionPane.showMessageDialog(null,"添加失败！");
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        deleteField = new JTextField();
        delete = new JButton();
        idea = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(600, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_14"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
        contentPane.add(label1);
        label1.setBounds(205, 55, 190, 45);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_8"));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(115, 125), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_8"));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(155, 160, 90, label3.getPreferredSize().height);
        contentPane.add(deleteField);
        deleteField.setBounds(215, 195, 165, 40);

        //---- delete ----
        delete.setText(bundle.getString("delete.text_3"));
        delete.addActionListener(e -> {
			button1ActionPerformed(e);
			deleteActionPerformed(e);
		});
        contentPane.add(delete);
        delete.setBounds(245, 295, 95, 40);
        contentPane.add(idea);
        idea.setBounds(220, 260, 170, 25);

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
    private JTextField deleteField;
    private JButton delete;
    private JLabel idea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

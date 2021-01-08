/*
 * Created by JFormDesigner on Thu Jan 07 10:55:41 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import java.awt.event.*;

import cn.dsq.customer.dao.UserDao;
import cn.dsq.customer.dao.impl.UserDaoImpl;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.util.ShowTable;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 1
 */
public class ShowOder extends JFrame {
    public ShowOder() throws IOException {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
        String cusname=cusnameField.getText();
        if(cusname.equals("")){
            idea.setText("请输入客户姓名！");
            return ;
        }
        String sql="select cusname,phone,place,tab_good.name,goodnum," +
                "goodnum*price as allprice from tab_good, tab_order," +
                "tab_user where cusname=tab_user.name and goodid=id and " +
                "cusname='"+cusname+"'";
        //System.out.println(sql);
        Vector<Vector<Object>> contextList =ShowTable.getOrder(sql);
        Vector<Object> titileList  = ShowTable.getOrderTitile();
        show.setModel(new DefaultTableModel(
                contextList,titileList
        ));
        scrollPane1.setViewportView(show);
    }

    private void initComponents() throws IOException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        label1 = new JLabel();
        cusnameField = new JTextField();
        button1 = new JButton();
        idea = new JLabel();
        scrollPane1 = new JScrollPane();
        show = new JTable();

        //======== this ========
        setMinimumSize(new Dimension(700, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText(bundle.getString("label1.text_12"));
            panel1.add(label1);
            label1.setBounds(30, 0, 200, 30);
            panel1.add(cusnameField);
            cusnameField.setBounds(240, 5, 135, cusnameField.getPreferredSize().height);

            //---- button1 ----
            button1.setText(bundle.getString("button1.text_6"));
            button1.addActionListener(e -> {
                try {
                    button1ActionPerformed(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(540, 5), button1.getPreferredSize()));
            panel1.add(idea);
            idea.setBounds(385, 5, 125, 25);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- show ----
            String sql="select cusname,phone,place,tab_good.name,goodnum," +
                    "goodnum*price as allprice from tab_good, tab_order," +
                    "tab_user where cusname=tab_user.name and goodid=id";
            Vector<Vector<Object>> contextList = ShowTable.getOrder(sql);
            Vector<Object> titileList  = ShowTable.getGoodTitile();
            show.setModel(new DefaultTableModel(
                    contextList,titileList
            ));
            scrollPane1.setViewportView(show);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField cusnameField;
    private JButton button1;
    private JLabel idea;
    private JScrollPane scrollPane1;
    private JTable show;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

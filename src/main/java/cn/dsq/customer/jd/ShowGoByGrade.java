/*
 * Created by JFormDesigner on Thu Jan 07 10:25:22 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.GoodDao;
import cn.dsq.customer.dao.impl.GoodDaoImpl;
import cn.dsq.customer.service.GoodService;
import cn.dsq.customer.service.impl.GoodServiceImpl;
import cn.dsq.customer.util.ShowTable;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 1
 */
public class ShowGoByGrade extends JFrame {
    public ShowGoByGrade() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name = selectField.getText();
        if(name.equals("")){
            idea.setText("请输入已有的品牌名称！");
        }
String sql = "select * from tab_good where name like '"+name+"%'";
System.out.println(sql);
        Vector<Vector<Object>> contextList = ShowTable.getGoods(sql);
        Vector<Object> title = ShowTable.getGoodTitile();
        show.setModel(new DefaultTableModel(
                contextList,title
        ));
        scrollPane1.setViewportView(show);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        label1 = new JLabel();
        selectField = new JTextField();
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
            label1.setText(bundle.getString("label1.text_11"));
            panel1.add(label1);
            label1.setBounds(10, 0, 215, 55);
            panel1.add(selectField);
            selectField.setBounds(230, 15, 150, 30);

            //---- button1 ----
            button1.setText(bundle.getString("button1.text_5"));
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button1);
            button1.setBounds(540, 5, 75, 50);
            panel1.add(idea);
            idea.setBounds(385, 15, 160, 30);

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
            Vector<Vector<Object>> contextList = ShowTable.getGoods("select *" +
                    " from tab_good");
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
    private JTextField selectField;
    private JButton button1;
    private JLabel idea;
    private JScrollPane scrollPane1;
    private JTable show;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

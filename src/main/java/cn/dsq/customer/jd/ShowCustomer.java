/*
 * Created by JFormDesigner on Tue Jan 05 21:05:01 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import java.awt.event.*;
import cn.dsq.customer.domain.User;
import cn.dsq.customer.util.JDBCUtils;
import cn.dsq.customer.util.ShowTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 1
 */
public class ShowCustomer extends JFrame {
    public ShowCustomer() {
        initComponents();
    }

    private void selectActionPerformed(ActionEvent e) {
        String[] nature={"","name","age","sex","place","phone","grade","email"
                };
        String sql = "select * from tab_user where ";
        String[] n={"","","","","","","",""};

        if(!cus1.getText().equals("")){
            n[1]=nature[1]+"="+"\'"+cus1.getText()+"\'";
        }
        if(!cus2.getText().equals("")){
            n[2]=nature[2]+"="+"\'"+cus2.getText()+"\'";
        }
        if(!cus3.getText().equals("")){
            n[3]=nature[3]+"="+"\'"+cus3.getText()+"\'";
        }
        if(!cus4.getText().equals("")){
            n[4]=nature[4]+"="+"\'"+cus4.getText()+"\'";
        }
        if(!cus5.getText().equals("")){
            n[5]=nature[5]+"="+"\'"+cus5.getText()+"\'";
        }
        if(!cus6.getText().equals("")){
            n[6]=nature[6]+"="+"\'"+cus6.getText()+"\'";
        }
        if(!cus7.getText().equals("")) {
            n[7] = nature[7] + "=" + "\'" + cus7.getText() + "\'";
        }
        int j=0;
        for(int i=0;i<n.length;i++){
            if(n[i]!=""){
                if(j==0) {
                    sql += n[i];
                    j++;
                }
                else sql+=" and "+n[i];
            }
        }
        if(j==0){
            idea.setText("请输入查询信息！");
            return;
        }
//        System.out.println(sql);
        Vector<Vector<Object>> contextList = ShowTable.getCustomer(sql);
        Vector<Object> title = ShowTable.getCusTitle();
        show.setModel(new DefaultTableModel(
                contextList,title
                ));
        scrollPane1.setViewportView(show);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        cus1 = new JTextField();
        cus2 = new JTextField();
        cus4 = new JTextField();
        cus3 = new JTextField();
        cus5 = new JTextField();
        cus6 = new JTextField();
        cus7 = new JTextField();
        select = new JButton();
        label1 = new JLabel();
        idea = new JLabel();
        scrollPane1 = new JScrollPane();
        show = new JTable();

        //======== this ========
        setTitle(bundle.getString("this.title_5"));
        setMinimumSize(new Dimension(700, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText(bundle.getString("label2.text_2"));
            panel1.add(label2);
            label2.setBounds(70, 0, 50, 25);

            //---- label3 ----
            label3.setText(bundle.getString("label3.text_2"));
            panel1.add(label3);
            label3.setBounds(225, 5, 40, 20);

            //---- label4 ----
            label4.setText(bundle.getString("label4.text"));
            panel1.add(label4);
            label4.setBounds(440, 5, 36, label4.getPreferredSize().height);

            //---- label5 ----
            label5.setText(bundle.getString("label5.text"));
            panel1.add(label5);
            label5.setBounds(310, 5, label5.getPreferredSize().width, 20);

            //---- label6 ----
            label6.setText(bundle.getString("label6.text"));
            panel1.add(label6);
            label6.setBounds(70, 30, 40, 20);
            panel1.add(label7);
            label7.setBounds(310, 30, label7.getPreferredSize().width, 20);

            //---- label8 ----
            label8.setText(bundle.getString("label8.text"));
            panel1.add(label8);
            label8.setBounds(new Rectangle(new Point(225, 30), label8.getPreferredSize()));
            panel1.add(cus1);
            cus1.setBounds(125, 5, 100, 20);
            panel1.add(cus2);
            cus2.setBounds(265, 5, 40, 20);
            panel1.add(cus4);
            cus4.setBounds(345, 5, 95, 20);
            panel1.add(cus3);
            cus3.setBounds(480, 5, 30, 20);
            panel1.add(cus5);
            cus5.setBounds(125, 30, 100, 20);
            panel1.add(cus6);
            cus6.setBounds(265, 30, 40, 20);
            panel1.add(cus7);
            cus7.setBounds(345, 30, 95, 20);

            //---- select ----
            select.setText(bundle.getString("select.text"));
            select.addActionListener(e -> selectActionPerformed(e));
            panel1.add(select);
            select.setBounds(585, 5, 60, 50);

            //---- label1 ----
            label1.setText(bundle.getString("label1.text_10"));
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(310, 30), label1.getPreferredSize()));
            panel1.add(idea);
            idea.setBounds(440, 30, 140, 25);

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
            Vector<Vector<Object>> contextList = ShowTable.getCustomer("select *" +
                    " from tab_user");
            Vector<Object> titileList  = ShowTable.getCusTitle();
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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField cus1;
    private JTextField cus2;
    private JTextField cus4;
    private JTextField cus3;
    private JTextField cus5;
    private JTextField cus6;
    private JTextField cus7;
    private JButton select;
    private JLabel label1;
    private JLabel idea;
    private JScrollPane scrollPane1;
    private JTable show;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}

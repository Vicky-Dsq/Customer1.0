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
 * 查询客户信息界面
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
        cusname = new JLabel();
        cusage = new JLabel();
        cussex = new JLabel();
        cusplace = new JLabel();
        cusphone = new JLabel();
        label7 = new JLabel();
        cusgrade = new JLabel();
        cus1 = new JTextField();
        cus2 = new JTextField();
        cus4 = new JTextField();
        cus3 = new JTextField();
        cus5 = new JTextField();
        cus6 = new JTextField();
        cus7 = new JTextField();
        select = new JButton();
        cusemail = new JLabel();
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

            //---- cusname ----
            cusname.setText(bundle.getString("cusname.text_2"));
            panel1.add(cusname);
            cusname.setBounds(70, 0, 50, 25);

            //---- cusage ----
            cusage.setText(bundle.getString("cusage.text_2"));
            panel1.add(cusage);
            cusage.setBounds(225, 5, 40, 20);

            //---- cussex ----
            cussex.setText(bundle.getString("cussex.text"));
            panel1.add(cussex);
            cussex.setBounds(440, 5, 36, cussex.getPreferredSize().height);

            //---- cusplace ----
            cusplace.setText(bundle.getString("cusplace.text"));
            panel1.add(cusplace);
            cusplace.setBounds(310, 5, cusplace.getPreferredSize().width, 20);

            //---- cusphone ----
            cusphone.setText(bundle.getString("cusphone.text"));
            panel1.add(cusphone);
            cusphone.setBounds(70, 30, 40, 20);
            panel1.add(label7);
            label7.setBounds(310, 30, label7.getPreferredSize().width, 20);

            //---- cusgrade ----
            cusgrade.setText(bundle.getString("cusgrade.text"));
            panel1.add(cusgrade);
            cusgrade.setBounds(new Rectangle(new Point(225, 30), cusgrade.getPreferredSize()));
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

            //---- cusemail ----
            cusemail.setText(bundle.getString("cusemail.text_10"));
            panel1.add(cusemail);
            cusemail.setBounds(new Rectangle(new Point(310, 30), cusemail.getPreferredSize()));
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
            String sql = "select * from tab_user";
            Vector<Vector<Object>> contextList = ShowTable.getCustomer(sql);
            Vector<Object> title = ShowTable.getCusTitle();
            show.setModel(new DefaultTableModel(
                    contextList,title
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
    private JLabel cusname;
    private JLabel cusage;
    private JLabel cussex;
    private JLabel cusplace;
    private JLabel cusphone;
    private JLabel label7;
    private JLabel cusgrade;
    private JTextField cus1;
    private JTextField cus2;
    private JTextField cus4;
    private JTextField cus3;
    private JTextField cus5;
    private JTextField cus6;
    private JTextField cus7;
    private JButton select;
    private JLabel cusemail;
    private JLabel idea;
    private JScrollPane scrollPane1;
    private JTable show;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}

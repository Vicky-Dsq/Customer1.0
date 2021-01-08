/*
 * Created by JFormDesigner on Tue Jan 05 21:05:01 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.util.ShowTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * @author 1
 */
public class ShowGoods extends JFrame {
    public ShowGoods() {
        initComponents();
    }

    private void selectActionPerformed(ActionEvent e) {
        String[] nature={"","id","name","price"};
        String sql = "select * from tab_good where ";
        String[] n={"","","",""};

        if(!cus1.getText().equals("")){
            n[1]=nature[1]+"="+cus1.getText();
        }
        if(!cus2.getText().equals("")){
            n[2]=nature[2]+"="+"\'"+cus2.getText()+"\'";
        }
        if(!cus3.getText().equals("")){
            n[3]=nature[3]+"="+cus3.getText();
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
        label3 = new JLabel();
        label5 = new JLabel();
        label8 = new JLabel();
        cus2 = new JTextField();
        cus3 = new JTextField();
        cus1 = new JTextField();
        select = new JButton();
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

            //---- label3 ----
            label3.setText(bundle.getString("label3.text_2"));
            panel1.add(label3);
            label3.setBounds(180, 20, 60, 20);

            //---- label5 ----
            label5.setText(bundle.getString("label5.text"));
            panel1.add(label5);
            label5.setBounds(310, 20, label5.getPreferredSize().width, 20);

            //---- label8 ----
            label8.setText(bundle.getString("label8.text"));
            panel1.add(label8);
            label8.setBounds(new Rectangle(new Point(75, 20), label8.getPreferredSize()));
            panel1.add(cus2);
            cus2.setBounds(235, 20, 70, 20);
            panel1.add(cus3);
            cus3.setBounds(345, 20, 95, 20);
            panel1.add(cus1);
            cus1.setBounds(105, 20, 70, 20);

            //---- select ----
            select.setText(bundle.getString("select.text"));
            select.addActionListener(e -> selectActionPerformed(e));
            panel1.add(select);
            select.setBounds(575, 0, 60, 50);
            panel1.add(idea);
            idea.setBounds(445, 20, 130, 25);

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
    private JLabel label3;
    private JLabel label5;
    private JLabel label8;
    private JTextField cus2;
    private JTextField cus3;
    private JTextField cus1;
    private JButton select;
    private JLabel idea;
    private JScrollPane scrollPane1;
    private JTable show;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}

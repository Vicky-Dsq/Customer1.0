/*
 * Created by JFormDesigner on Tue Jan 05 21:05:01 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.util.ShowTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * 查询商品界面
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

        if(!good1.getText().equals("")){
            n[1]=nature[1]+"="+good1.getText();
        }
        if(!good2.getText().equals("")){
            n[2]=nature[2]+"="+"\'"+good2.getText()+"\'";
        }
        if(!good3.getText().equals("")){
            n[3]=nature[3]+"="+good3.getText();
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
        System.out.println(sql);
        Vector<Vector<Object>> contextList = ShowTable.getGoods(sql);
        Vector<String> titles = new Vector<String>();
        Collections.addAll(titles, "编号","商品名称","单价");//定义表格列头
        DefaultTableModel model1 = new DefaultTableModel(contextList,
                titles) {//使用Vector装载表格数据模型，覆写getColumnClass方法，实现按数值排序
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else { returnValue = Object.class; }
                return returnValue;
            }};// 定义表格数据模型的表格标题和行数(为0行)
        TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model1);//设置表格模型排序器
        show.setRowSorter(sorter);//设置表格排序器
        show.setModel(new DefaultTableModel(
                contextList,titles
                ));
        scrollPane1.setViewportView(show);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        panel1 = new JPanel();
        goodname = new JLabel();
        pricesigle = new JLabel();
        goodid = new JLabel();
        good2 = new JTextField();
        good3 = new JTextField();
        good1 = new JTextField();
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

            //---- goodname ----
            goodname.setText(bundle.getString("goodname.text_2"));
            panel1.add(goodname);
            goodname.setBounds(180, 20, 60, 20);

            //---- pricesigle ----
            pricesigle.setText(bundle.getString("pricesigle.text"));
            panel1.add(pricesigle);
            pricesigle.setBounds(310, 20, pricesigle.getPreferredSize().width, 20);

            //---- goodid ----
            goodid.setText(bundle.getString("goodid.text"));
            panel1.add(goodid);
            goodid.setBounds(new Rectangle(new Point(75, 20), goodid.getPreferredSize()));
            panel1.add(good2);
            good2.setBounds(235, 20, 70, 20);
            panel1.add(good3);
            good3.setBounds(345, 20, 95, 20);
            panel1.add(good1);
            good1.setBounds(105, 20, 70, 20);

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
            Vector<String> titles = new Vector<String>();
            Collections.addAll(titles, "编号","商品名称","单价");//定义表格列头
            DefaultTableModel model1 = new DefaultTableModel(contextList,
                    titles) {//使用Vector装载表格数据模型，覆写getColumnClass方法，实现按数值排序
                public Class getColumnClass(int column) {
                    Class returnValue;
                    if ((column >= 0) && (column < getColumnCount())) {
                        returnValue = getValueAt(0, column).getClass();
                    } else { returnValue = Object.class; }
                    return returnValue;
                }};// 定义表格数据模型的表格标题和行数(为0行)
            TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model1);//设置表格模型排序器
            show.setRowSorter(sorter);//设置表格排序器
            show.setModel(new DefaultTableModel(
                    contextList,titles
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
    private JLabel goodname;
    private JLabel pricesigle;
    private JLabel goodid;
    private JTextField good2;
    private JTextField good3;
    private JTextField good1;
    private JButton select;
    private JLabel idea;
    private JScrollPane scrollPane1;
    private JTable show;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}

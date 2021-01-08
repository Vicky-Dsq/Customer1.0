/*
 * Created by JFormDesigner on Wed Jan 06 11:49:56 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.dao.ManagerDao;
import cn.dsq.customer.dao.impl.ManagerDaoImpl;
import cn.dsq.customer.domain.Manager;
import cn.dsq.customer.service.ManagerService;
import cn.dsq.customer.service.impl.ManagerServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Home extends JFrame {
    public Home() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
        if(names.getText().equals("")||passwords.getPassword().equals("")){
            prompt.setText("请输入用户名/密码");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\86135\\Desktop\\Java课设\\manager.txt"));
        String row=null;
        String wname=names.getText();
        String wpassword=new String(passwords.getPassword());
        int j=0;
        while((row=bufferedReader.readLine())!=null){
            String[] nature = row.split("\t");
            String name=nature[0];
            String password=nature[1];
            if(name.equals(wname)&&password.equals(wpassword)){
                j=1;
                new Operation().setVisible(true);
               this.setVisible(false);
            }
        }
        if(j==0)prompt.setText("用户名或密码错误！");


//            String name=names.getText();
//        String password=new String(passwords.getPassword());
//        System.out.println(name);
//        System.out.println(password);
//        Manager manager = new Manager();
//        manager.setMaName(name);
//        manager.setMaPassword(password);
//        ManagerDao managerDao = new ManagerDaoImpl();
//        if(managerDao.findByNameAndPassword(name,password)!=null){
//            new Operation().setVisible(true);
//            this.setVisible(false);
//        }else{
//            prompt.setText("用户名或密码错误！");
//        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        names = new JFormattedTextField();
        passwords = new JPasswordField();
        button1 = new JButton();
        prompt = new JLabel();

        //======== this ========
        setTitle(bundle.getString("this.title_6"));
        setMinimumSize(new Dimension(400, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_4"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(125, 50), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_3"));
        contentPane.add(label2);
        label2.setBounds(75, 105, label2.getPreferredSize().width, 20);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_3"));
        contentPane.add(label3);
        label3.setBounds(75, 140, label3.getPreferredSize().width, 25);
        contentPane.add(names);
        names.setBounds(125, 105, 145, names.getPreferredSize().height);
        contentPane.add(passwords);
        passwords.setBounds(125, 140, 145, passwords.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(155, 180), button1.getPreferredSize()));

        //---- prompt ----
        prompt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        contentPane.add(prompt);
        prompt.setBounds(125, 215, 185, 45);

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
    private JFormattedTextField names;
    private JPasswordField passwords;
    private JButton button1;
    private JLabel prompt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

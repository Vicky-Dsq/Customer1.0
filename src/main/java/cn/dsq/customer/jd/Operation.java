/*
 * Created by JFormDesigner on Wed Jan 06 12:18:54 GMT+08:00 2021
 */

package cn.dsq.customer.jd;

import cn.dsq.customer.util.ExportToExl;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.*;

/**
 * 管理员操作界面
 * @author 1
 */
public class Operation extends JFrame {
    public Operation() {
        initComponents();
    }

    private void nomalSelectActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ShowCustomer().setVisible(true);
    }


    private void placeSelectActionPerformed(ActionEvent e) {
        // TODO add your code here
        new DeleteCustomer().setVisible(true);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new UpdateCustomer().setVisible(true);
    }

    private void gNomalSelectActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ShowGoods().setVisible(true);
    }

    private void exitActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.setVisible(false);
    }

    private void menuItem2ActionPerformed(ActionEvent e) throws IOException {
        // TODO add your code here
        new ShowOder().setVisible(true);
    }

    private void addGoodActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddGoods().setVisible(true);
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void orderSelectActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteGoodActionPerformed(ActionEvent e) {
        // TODO add your code here
        new DeleteGoods().setVisible(true);
    }

    private void changeGoodActionPerformed(ActionEvent e) {
        // TODO add your code here
        new UpdateGoods().setVisible(true);
    }

    private void loginManagerActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddManager().setVisible(true);
    }

    private void addOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddOrders().setVisible(true);
    }

    private void brandSelectActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ShowGoByGrade().setVisible(true);
    }

    private void addUserActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddCustomer().setVisible(true);
    }

    private void exportcusActionPerformed(ActionEvent e) {
        // TODO add your code here
        ExportToExl.writeDbtoExcel("tab_user");
        JOptionPane.showMessageDialog(null,
                "数据已导至D:/dsq/tab_user.xls!");
    }

    private void exportgoodActionPerformed(ActionEvent e) {
        // TODO add your code here
        ExportToExl.writeDbtoExcel("tab_good");
        JOptionPane.showMessageDialog(null,
                "数据已导至D:/dsq/tab_good.xls!");
    }

    private void exportorderActionPerformed(ActionEvent e) {
        // TODO add your code here
        ExportToExl.writeDbtoExcel("tab_order");
        JOptionPane.showMessageDialog(null,
                "数据已导至D:/dsq/tab_order.xls!");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        menuBar1 = new JMenuBar();
        user = new JMenu();
        nomalSelect = new JMenuItem();
        addUser = new JMenuItem();
        deleteUser = new JMenuItem();
        changeUser = new JMenuItem();
        goods = new JMenu();
        gNomalSelect = new JMenuItem();
        brandSelect = new JMenuItem();
        addGood = new JMenuItem();
        deleteGood = new JMenuItem();
        changeGood = new JMenuItem();
        order = new JMenu();
        orderSelect = new JMenuItem();
        addOrder = new JMenuItem();
        menu1 = new JMenu();
        exportcus = new JMenuItem();
        exportgood = new JMenuItem();
        exportorder = new JMenuItem();
        manager = new JMenu();
        loginManager = new JMenuItem();
        menuBar2 = new JMenuBar();
        exit = new JButton();
        back = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(500, 400));
        setTitle(bundle.getString("this.title_7"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== user ========
            {
                user.setText(bundle.getString("user.text_2"));

                //---- nomalSelect ----
                nomalSelect.setText(bundle.getString("nomalSelect.text_2"));
                nomalSelect.addActionListener(e -> nomalSelectActionPerformed(e));
                user.add(nomalSelect);

                //---- addUser ----
                addUser.setText(bundle.getString("addUser.text_2"));
                addUser.addActionListener(e -> addUserActionPerformed(e));
                user.add(addUser);

                //---- deleteUser ----
                deleteUser.setText(bundle.getString("deleteUser.text"));
                deleteUser.addActionListener(e -> placeSelectActionPerformed(e));
                user.add(deleteUser);

                //---- changeUser ----
                changeUser.setText(bundle.getString("changeUser.text_2"));
                changeUser.addActionListener(e -> menuItem1ActionPerformed(e));
                user.add(changeUser);
            }
            menuBar1.add(user);

            //======== goods ========
            {
                goods.setText(bundle.getString("goods.text"));

                //---- gNomalSelect ----
                gNomalSelect.setText(bundle.getString("gNomalSelect.text"));
                gNomalSelect.addActionListener(e -> gNomalSelectActionPerformed(e));
                goods.add(gNomalSelect);

                //---- brandSelect ----
                brandSelect.setText(bundle.getString("brandSelect.text"));
                brandSelect.addActionListener(e -> brandSelectActionPerformed(e));
                goods.add(brandSelect);

                //---- addGood ----
                addGood.setText(bundle.getString("addGood.text"));
                addGood.addActionListener(e -> {
			menuItem3ActionPerformed(e);
			addGoodActionPerformed(e);
		});
                goods.add(addGood);

                //---- deleteGood ----
                deleteGood.setText(bundle.getString("deleteGood.text"));
                deleteGood.addActionListener(e -> deleteGoodActionPerformed(e));
                goods.add(deleteGood);

                //---- changeGood ----
                changeGood.setText(bundle.getString("changeGood.text"));
                changeGood.addActionListener(e -> changeGoodActionPerformed(e));
                goods.add(changeGood);
            }
            menuBar1.add(goods);

            //======== order ========
            {
                order.setText(bundle.getString("order.text_2"));
                order.setMinimumSize(new Dimension(400, 300));
                order.addActionListener(e -> orderSelectActionPerformed(e));

                //---- orderSelect ----
                orderSelect.setText(bundle.getString("orderSelect.text"));
                orderSelect.addActionListener(e -> {
                    try {
                        menuItem2ActionPerformed(e);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                order.add(orderSelect);

                //---- addOrder ----
                addOrder.setText(bundle.getString("addOrder.text"));
                addOrder.addActionListener(e -> addOrderActionPerformed(e));
                order.add(addOrder);
            }
            menuBar1.add(order);

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("menu1.text_2"));

                //---- exportcus ----
                exportcus.setText(bundle.getString("exportcus.text_2"));
                exportcus.addActionListener(e -> exportcusActionPerformed(e));
                menu1.add(exportcus);

                //---- exportgood ----
                exportgood.setText(bundle.getString("exportgood.text"));
                exportgood.addActionListener(e -> exportgoodActionPerformed(e));
                menu1.add(exportgood);

                //---- exportorder ----
                exportorder.setText(bundle.getString("exportorder.text"));
                exportorder.addActionListener(e -> exportorderActionPerformed(e));
                menu1.add(exportorder);
            }
            menuBar1.add(menu1);

            //======== manager ========
            {
                manager.setText(bundle.getString("manager.text"));

                //---- loginManager ----
                loginManager.setText(bundle.getString("loginManager.text"));
                loginManager.addActionListener(e -> loginManagerActionPerformed(e));
                manager.add(loginManager);
            }
            menuBar1.add(manager);
            menuBar1.add(menuBar2);
        }
        setJMenuBar(menuBar1);

        //---- exit ----
        exit.setText(bundle.getString("exit.text_5"));
        exit.addActionListener(e -> {
			exitActionPerformed(e);
			exitActionPerformed(e);
		});
        contentPane.add(exit);
        exit.setBounds(380, 330, 93, 39);

        //---- back ----
        back.setBounds(0,0, 500, 400);
        String strPath="D:\\CurriculumDesign\\customer\\src\\main\\java\\cn" +
                "\\dsq\\customer\\images\\Background.jpg";
        ImageIcon icon = new ImageIcon(strPath);//你的图片地址
        icon.setImage(icon.getImage().getScaledInstance(back.getWidth(),
                back.getHeight(),Image.SCALE_DEFAULT));
        back.setIcon(icon);
        contentPane.add(back);

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
    private JMenuBar menuBar1;
    private JMenu user;
    private JMenuItem nomalSelect;
    private JMenuItem addUser;
    private JMenuItem deleteUser;
    private JMenuItem changeUser;
    private JMenu goods;
    private JMenuItem gNomalSelect;
    private JMenuItem brandSelect;
    private JMenuItem addGood;
    private JMenuItem deleteGood;
    private JMenuItem changeGood;
    private JMenu order;
    private JMenuItem orderSelect;
    private JMenuItem addOrder;
    private JMenu menu1;
    private JMenuItem exportcus;
    private JMenuItem exportgood;
    private JMenuItem exportorder;
    private JMenu manager;
    private JMenuItem loginManager;
    private JMenuBar menuBar2;
    private JButton exit;
    private JLabel back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

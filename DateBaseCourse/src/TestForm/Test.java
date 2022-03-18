/*
 * Created by JFormDesigner on Tue May 18 13:18:12 CST 2021
 */

package TestForm;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class Test extends JFrame {
    public Test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        checkBox1 = new JCheckBox();

        //======== this ========
        var contentPane = getContentPane();

        //---- radioButton1 ----
        radioButton1.setText("text");

        //---- radioButton2 ----
        radioButton2.setText("text");

        //---- checkBox1 ----
        checkBox1.setText("text");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(radioButton1)
                            .addGap(84, 84, 84)
                            .addComponent(radioButton2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(checkBox1)))
                    .addContainerGap(150, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(101, Short.MAX_VALUE)
                    .addComponent(checkBox1)
                    .addGap(46, 46, 46)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton1)
                        .addComponent(radioButton2))
                    .addGap(78, 78, 78))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

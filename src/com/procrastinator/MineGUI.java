/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MineGUI extends JFrame {

    public ButtonGroup actionGroup;
    public JRadioButton actionRadio1, actionRadio2, actionRadio3;
    public JButton backButton, turnButton;
    public JPanel contentPanel, jPanel1;
    public JLabel jLabel1, jLabel2, jLabel3, jLabel6, jLabel7;
    public JTextField xField, yField;
    public JLabel[][] gridLabels;
    
    public MineGUI(int x, int y) {
    	gridLabels = new JLabel[x][y];
        initComponents();
    }

    private void initComponents() {

        actionGroup = new ButtonGroup();
        jPanel1 = new JPanel();
        turnButton = new JButton();
        backButton = new JButton();
        jLabel1 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        xField = new JTextField();
        yField = new JTextField();
        actionRadio1 = new JRadioButton();
        actionRadio2 = new JRadioButton();
        actionRadio3 = new JRadioButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        contentPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procrastinator - Mine Sweeper");

        jPanel1.setBackground(new Color(0, 0, 0));

        turnButton.setFont(new Font("Liberation Mono", 3, 36));
        turnButton.setText("Turn");

        backButton.setFont(new Font("Liberation Mono", 3, 36));
        backButton.setText("Back");

        jLabel1.setFont(new Font("Monospaced", 1, 36));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Mine Sweeper");

        jLabel6.setFont(new Font("Monospaced", 3, 24));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("X:");

        jLabel7.setFont(new Font("Monospaced", 3, 24));
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setText("Y:");

        xField.setFont(new Font("Liberation Mono", 3, 24));

        yField.setFont(new Font("Liberation Mono", 3, 24));

        actionRadio1.setBackground(new Color(0, 0, 0));
        actionGroup.add(actionRadio1);
        actionRadio1.setFont(new Font("Monospaced", 1, 14));
        actionRadio1.setForeground(new Color(255, 255, 255));
        actionRadio1.setSelected(true);
        actionRadio1.setText("Check");

        actionRadio2.setBackground(new Color(0, 0, 0));
        actionGroup.add(actionRadio2);
        actionRadio2.setFont(new Font("Monospaced", 1, 14));
        actionRadio2.setForeground(new Color(255, 255, 255));
        actionRadio2.setText("Flag (XX left)");

        actionRadio3.setBackground(new Color(0, 0, 0));
        actionGroup.add(actionRadio3);
        actionRadio3.setFont(new Font("Monospaced", 1, 14));
        actionRadio3.setForeground(new Color(255, 255, 255));
        actionRadio3.setText("????");

        jLabel2.setFont(new Font("Monospaced", 1, 18));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Write the (x,y) coordinates");

        jLabel3.setFont(new Font("Monospaced", 1, 18));
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("and choose what to do:");

        contentPanel.setBackground(new Color(0, 0, 0));
        contentPanel.setLayout(new GridLayout(this.gridLabels.length, this.gridLabels[0].length));
        for (int i=0; i<this.gridLabels.length; i++) {
        	for (int j=0; j<this.gridLabels[i].length; j++) {
        		gridLabels[i][j] = new JLabel(" "+i+"x"+j+" ");
        		gridLabels[i][j].setForeground(Color.WHITE);
        		contentPanel.add(gridLabels[i][j]);
        	}
        }

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(backButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(turnButton)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actionRadio2)
                            .addComponent(actionRadio1)
                            .addComponent(actionRadio3))
                        .addGap(87, 87, 87))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addContainerGap())
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(actionRadio1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionRadio2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionRadio3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}

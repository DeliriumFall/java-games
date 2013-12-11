/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MagicGUI extends JFrame {

    public JButton upButton, downButton, leftButton, rightButton, backButton;
    public JPanel contentPanel;
    public JLabel jLabel1, jLabel2, jLabel3;
    public JPanel jPanel1;
    public JLabel[][] gridLabels;
    
    public MagicGUI(int x, int y) {
    	gridLabels = new JLabel[x][y];
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        upButton = new JButton();
        backButton = new JButton();
        downButton = new JButton();
        leftButton = new JButton();
        rightButton = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        contentPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procrastinator - Magic Square");

        jPanel1.setBackground(new Color(0, 0, 0));

        jLabel1.setFont(new Font("Monospaced", 1, 36));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Magic Square");

        upButton.setFont(new Font("Liberation Mono", 3, 36));
        upButton.setText("^");

        backButton.setFont(new Font("Liberation Mono", 3, 36));
        backButton.setText("Back");

        downButton.setFont(new Font("Liberation Mono", 3, 36));
        downButton.setText("v");

        leftButton.setFont(new Font("Liberation Mono", 3, 36));
        leftButton.setText("<");

        rightButton.setFont(new Font("Liberation Mono", 3, 36));
        rightButton.setText(">");

        jLabel2.setFont(new Font("Monospaced", 1, 18));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Click the direction to which");

        jLabel3.setFont(new Font("Monospaced", 1, 18));
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("you want to move the tile");

        contentPanel.setBackground(new Color(0, 0, 0));
        contentPanel.setLayout(new GridLayout(this.gridLabels.length, this.gridLabels[0].length));
        for (int i=0; i<this.gridLabels.length; i++) {
        	for (int j=0; j<this.gridLabels[i].length; j++) {
        		gridLabels[i][j] = new JLabel(" "+i+"x"+j+" ");
        		gridLabels[i][j].setForeground(Color.WHITE);
        		gridLabels[i][j].setFont(new Font("Monospaced", 1, 20));
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
                        .addGap(66, 66, 66)
                        .addComponent(backButton)
                        .addGap(75, 75, 75)
                        .addComponent(leftButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(upButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(upButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rightButton)
                            .addComponent(leftButton)
                            .addComponent(downButton))))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
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
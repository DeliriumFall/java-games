/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class TicGUI extends JFrame {

    public JButton backButton, turnButton;
    public JPanel contentPanel, jPanel1;
    public JLabel jLabel1, jLabel6, jLabel7, playerLabel;
    public JTextField xField, yField;
    public JLabel[][] gridLabels;
    
    public TicGUI(int x, int y) {
    	gridLabels = new JLabel[x][y];
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        turnButton = new JButton();
        backButton = new JButton();
        jLabel1 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        xField = new JTextField();
        yField = new JTextField();
        contentPanel = new JPanel();
        playerLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 0, 0));

        turnButton.setFont(new Font("Liberation Mono", 3, 36));
        turnButton.setText("Turn");

        backButton.setFont(new Font("Liberation Mono", 3, 36));
        backButton.setText("Back");

        jLabel1.setFont(new Font("Monospaced", 1, 36));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Tic Tac Toe");

        jLabel6.setFont(new Font("Monospaced", 3, 24));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("X:");

        jLabel7.setFont(new Font("Monospaced", 3, 24));
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setText("Y:");

        xField.setFont(new Font("Liberation Mono", 3, 24));

        yField.setFont(new Font("Liberation Mono", 3, 24));

        contentPanel.setBackground(new Color(0, 0, 0));
        contentPanel.setLayout(new GridLayout(this.gridLabels.length, this.gridLabels[0].length));
        for (int i=0; i<this.gridLabels.length; i++) {
        	for (int j=0; j<this.gridLabels[i].length; j++) {
        		gridLabels[i][j] = new JLabel(" "+i+"x"+j+" ");
        		gridLabels[i][j].setForeground(Color.WHITE);
        		gridLabels[i][j].setFont(new Font("Monospaced", 1, 30));
        		contentPanel.add(gridLabels[i][j]);
        	}
        }

        playerLabel.setFont(new Font("Monospaced", 1, 24));
        playerLabel.setForeground(new Color(255, 255, 255));
        playerLabel.setText("Player 1:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(turnButton)
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(playerLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(playerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton))
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
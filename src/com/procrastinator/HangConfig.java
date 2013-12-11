/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class HangConfig extends JFrame {

    public JButton backButton, nextButton;
    public JLabel jLabel1, jLabel2;
    public JPanel jPanel1;
    public ButtonGroup playerGroup;
    public JRadioButton playerRadio1, playerRadio2;
    
    public HangConfig() {
        initComponents();
    }

    private void initComponents() {

        playerGroup = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        playerRadio2 = new JRadioButton();
        playerRadio1 = new JRadioButton();
        jLabel2 = new JLabel();
        backButton = new JButton();
        nextButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman - Configuration");

        jPanel1.setBackground(new Color(0, 0, 0));

        jLabel1.setFont(new Font("Monospaced", 1, 24));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Hangman Configuration");

        playerRadio2.setBackground(new Color(0, 0, 0));
        playerGroup.add(playerRadio2);
        playerRadio2.setFont(new Font("Monospaced", 1, 24));
        playerRadio2.setForeground(new Color(255, 255, 255));
        playerRadio2.setText("Human");

        playerRadio1.setBackground(new Color(0, 0, 0));
        playerGroup.add(playerRadio1);
        playerRadio1.setFont(new Font("Monospaced", 1, 24));
        playerRadio1.setForeground(new Color(255, 255, 255));
        playerRadio1.setSelected(true);
        playerRadio1.setText("Computer");

        jLabel2.setFont(new Font("Monospaced", 1, 24));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Player Two?");

        backButton.setFont(new Font("Liberation Mono", 3, 36));
        backButton.setText("Back");

        nextButton.setFont(new Font("Liberation Mono", 3, 36));
        nextButton.setText("Next");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playerRadio1)
                                    .addComponent(playerRadio2))))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(140, 140, 140)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerRadio1)
                .addGap(18, 18, 18)
                .addComponent(playerRadio2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
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
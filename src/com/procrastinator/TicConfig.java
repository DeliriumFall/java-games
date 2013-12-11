/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"serial","unchecked","rawtypes"})
public class TicConfig extends JFrame {

    public JButton backButton, nextButton;
    public JComboBox difficultyCombo;
    public JLabel jLabel1, jLabel2, jLabel3;
    public JPanel jPanel1;
    public ButtonGroup playerGroup;
    public JRadioButton playerRadio1, playerRadio2;
    
    public TicConfig() {
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
        jLabel3 = new JLabel();
        difficultyCombo = new JComboBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 0, 0));

        jLabel1.setFont(new Font("Monospaced", 1, 24));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Tic Tac Toe Configuration");

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

        jLabel3.setFont(new Font("Monospaced", 1, 24));
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Difficulty:");

        difficultyCombo.setFont(new Font("Liberation Mono", 3, 18));
        difficultyCombo.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerRadio1)
                            .addComponent(playerRadio2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(difficultyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton)
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerRadio1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playerRadio2)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(difficultyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
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

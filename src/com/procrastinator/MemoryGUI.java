/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MemoryGUI extends JFrame {

	public JButton backButton;
	public JPanel contentPanel, firstPanel, secondPanel, jPanel1;
	public JLabel jLabel1, jLabel3, jLabel5, jLabel2, jLabel4, jLabel6,
			jLabel7;
	public JButton turnButton;
	public JTextField xField1, xField2, yField1, yField2;
	public JLabel[][] gridLabels;

	public MemoryGUI(int x, int y) {
		gridLabels = new JLabel[x][y];
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		backButton = new JButton();
		turnButton = new JButton();
		contentPanel = new JPanel();
		firstPanel = new JPanel();
		jLabel2 = new JLabel();
		xField1 = new JTextField();
		yField1 = new JTextField();
		jLabel7 = new JLabel();
		jLabel6 = new JLabel();
		secondPanel = new JPanel();
		jLabel4 = new JLabel();
		xField2 = new JTextField();
		yField2 = new JTextField();
		jLabel3 = new JLabel();
		jLabel5 = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Procrastinator - Memory");

		jPanel1.setBackground(new Color(0, 0, 0));

		jLabel1.setFont(new Font("Monospaced", 1, 36));
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setText("Memory");

		backButton.setFont(new Font("Liberation Mono", 3, 36));
		backButton.setText("Back");

		turnButton.setFont(new Font("Liberation Mono", 3, 36));
		turnButton.setText("Turn");

		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setLayout(new GridLayout(this.gridLabels.length,
				this.gridLabels[0].length));
		for (int i = 0; i < this.gridLabels.length; i++) {
			for (int j = 0; j < this.gridLabels[i].length; j++) {
				gridLabels[i][j] = new JLabel(" " + i + "x" + j + " ");
				gridLabels[i][j].setForeground(Color.WHITE);
				contentPanel.add(gridLabels[i][j]);
			}
		}

		firstPanel.setBackground(new Color(0, 0, 0));

		jLabel2.setFont(new Font("Monospaced", 1, 18));
		jLabel2.setForeground(new Color(255, 255, 255));
		jLabel2.setText("Write the first (x,y) coordinates:");

		xField1.setFont(new Font("Liberation Mono", 3, 24));

		yField1.setFont(new Font("Liberation Mono", 3, 24));

		jLabel7.setFont(new Font("Monospaced", 3, 24));
		jLabel7.setForeground(new Color(255, 255, 255));
		jLabel7.setText("Y:");

		jLabel6.setFont(new Font("Monospaced", 3, 24));
		jLabel6.setForeground(new Color(255, 255, 255));
		jLabel6.setText("X:");

		GroupLayout firstPanelLayout = new GroupLayout(firstPanel);
		firstPanel.setLayout(firstPanelLayout);
		firstPanelLayout
				.setHorizontalGroup(firstPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								firstPanelLayout.createSequentialGroup()
										.addComponent(jLabel2)
										.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(
								firstPanelLayout
										.createSequentialGroup()
										.addGap(26, 26, 26)
										.addGroup(
												firstPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																firstPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				yField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				37,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																firstPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel6)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				xField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				37,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		firstPanelLayout
				.setVerticalGroup(firstPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								firstPanelLayout
										.createSequentialGroup()
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												firstPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																xField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												firstPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																yField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		secondPanel.setBackground(new Color(0, 0, 0));

		jLabel4.setFont(new Font("Monospaced", 1, 18));
		jLabel4.setForeground(new Color(255, 255, 255));
		jLabel4.setText("Write the next (x,y) coordinates:");

		xField2.setFont(new Font("Liberation Mono", 3, 24));

		yField2.setFont(new Font("Liberation Mono", 3, 24));

		jLabel3.setFont(new Font("Monospaced", 3, 24));
		jLabel3.setForeground(new Color(255, 255, 255));
		jLabel3.setText("Y:");

		jLabel5.setFont(new Font("Monospaced", 3, 24));
		jLabel5.setForeground(new Color(255, 255, 255));
		jLabel5.setText("X:");

		GroupLayout secondPanelLayout = new GroupLayout(secondPanel);
		secondPanel.setLayout(secondPanelLayout);
		secondPanelLayout
				.setHorizontalGroup(secondPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								secondPanelLayout.createSequentialGroup()
										.addComponent(jLabel4)
										.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(
								secondPanelLayout
										.createSequentialGroup()
										.addGap(26, 26, 26)
										.addGroup(
												secondPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																secondPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				yField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				37,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																secondPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				xField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				37,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		secondPanelLayout
				.setVerticalGroup(secondPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								secondPanelLayout
										.createSequentialGroup()
										.addComponent(jLabel4)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												secondPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																xField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												secondPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																yField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(185, 185, 185)
										.addComponent(jLabel1)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(69, 69, 69)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				firstPanel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				363,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				68,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				backButton)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				turnButton)
																		.addGap(68,
																				68,
																				68))))
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel1Layout
														.createSequentialGroup()
														.addGap(31, 31, 31)
														.addComponent(
																contentPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap(31,
																Short.MAX_VALUE)))
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel1Layout
														.createSequentialGroup()
														.addContainerGap(79,
																Short.MAX_VALUE)
														.addComponent(
																secondPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(58, 58, 58))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												314, Short.MAX_VALUE)
										.addComponent(
												firstPanel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												110,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																turnButton,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																backButton))
										.addContainerGap())
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel1Layout
														.createSequentialGroup()
														.addGap(75, 75, 75)
														.addComponent(
																contentPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap(234,
																Short.MAX_VALUE)))
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel1Layout
														.createSequentialGroup()
														.addContainerGap(379,
																Short.MAX_VALUE)
														.addComponent(
																secondPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																110,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(71, 71, 71))));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
}
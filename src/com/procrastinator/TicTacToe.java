/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TicTacToe extends Game implements TwoPlayer {
	public TicGUI GUI;
	private int currPlayer;
	private Grid<Boolean> grid;
	/*
	 * true => X false => O
	 */

	public TicTacToe(int difficulty, boolean realPlayerFlag) {
		super("Tic Tac Toe", difficulty, 2, !realPlayerFlag);
		this.grid = new Grid<Boolean>(3, 3, "bool");
		this.GUI = new TicGUI(this.grid.getSizeY() + 1,
				this.grid.getSizeX() + 1);
		this.currPlayer = 1;
	}

	public TicTacToe() {
		this(1, false);
	}

	public void startGame() {
		this.GUI.backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end();
			}
		});
		this.GUI.turnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput();
			}
		});
		this.displayGrid();
		this.GUI.setVisible(true);
	}

	public void resetGame() {
		this.grid = new Grid<Boolean>(3, 3, "bool");
		this.currPlayer = (this.currPlayer == 1) ? 2 : 1;
		this.GUI.xField.setText("");
		this.GUI.yField.setText("");
	}

	public boolean won() {
		for (int i = 0; i < this.grid.getSizeY(); i++) {
			if (this.grid.isShown(0, i) && this.grid.isShown(1, i)
					&& this.grid.isShown(2, i)) {
				if (this.grid.getValueAt(0, i) == this.grid.getValueAt(1, i)
						&& this.grid.getValueAt(2, i) == this.grid.getValueAt(
								0, i)) {
					if (this.grid.getValueAt(0, i)) {
						JOptionPane.showMessageDialog(this.GUI,
								"X player wins!");
					} else {
						JOptionPane.showMessageDialog(this.GUI,
								"O player wins!");
					}
					addScore(this.currPlayer-1, 1);
					return true;
				}
			}
		}
		for (int i = 0; i < this.grid.getSizeX(); i++) {
			if (this.grid.isShown(i, 0) && this.grid.isShown(i, 1)
					&& this.grid.isShown(i, 2)) {
				if (this.grid.getValueAt(i, 0) == this.grid.getValueAt(i, 1)
						&& this.grid.getValueAt(i, 2) == this.grid.getValueAt(
								i, 2)) {
					if (this.grid.getValueAt(i, 0)) {
						JOptionPane.showMessageDialog(this.GUI,
								"X player wins!");
					} else {
						JOptionPane.showMessageDialog(this.GUI,
								"O player wins!");
					}
					addScore(this.currPlayer-1, 1);
					return true;
				}
			}
		}
		if (this.grid.isShown(1, 1) && this.grid.isShown(0, 0)
				&& this.grid.isShown(2, 2)) {
			if (this.grid.getValueAt(1, 1) == this.grid.getValueAt(0, 0)
					&& this.grid.getValueAt(1, 1) == this.grid.getValueAt(2, 2)) {
				if (this.grid.getValueAt(1, 1)) {
					JOptionPane.showMessageDialog(this.GUI, "X player wins!");
				} else {
					JOptionPane.showMessageDialog(this.GUI, "O player wins!");
				}
				addScore(this.currPlayer-1, 1);
				return true;
			}
		}
		if (this.grid.isShown(1, 1) && this.grid.isShown(2, 0)
				&& this.grid.isShown(0, 2)) {
			if (this.grid.getValueAt(1, 1) == this.grid.getValueAt(2, 0)
					&& this.grid.getValueAt(1, 1) == this.grid.getValueAt(0, 2)) {
				if (this.grid.getValueAt(1, 1)) {
					JOptionPane.showMessageDialog(this.GUI, "X player wins!");
				} else {
					JOptionPane.showMessageDialog(this.GUI, "O player wins!");
				}
				addScore(this.currPlayer-1, 1);
				return true;
			}
		}
		return false;
	}

	public void getInput() {
		this.displayGrid();
		// Checks if there is at least 1 free space in the Grid
		boolean flag = false;
		for (int i = 0; i < this.grid.getSizeY(); i++) {
			for (int j = 0; j < this.grid.getSizeX(); j++) {
				if (!this.grid.isShown(j, i)) {
					flag = true;
					i = this.grid.getSizeY() + 1;
					break;
				}
			}
		}
		if (flag && !won()) {
			int x, y;
			x = Integer.parseInt(this.GUI.xField.getText().toString()) - 1;
			y = Integer.parseInt(this.GUI.yField.getText().toString()) - 1;
			if (this.grid.isShown(x, y) || x < 0 || y < 0
					|| x > this.grid.getSizeX() || y > this.grid.getSizeY()) {
				JOptionPane.showMessageDialog(this.GUI, "Invalid input");
				return;
			}
			if (this.currPlayer == 1)
				this.grid.setValue(x, y, true);
			else
				this.grid.setValue(x, y, false);
			this.grid.show(x, y);
			this.displayGrid();
			if (won()) {
				saveScore();
				if (!keepPlaying()) {
					end();
				} else {
					resetGame();
				}
				return;
			}
		} else {
			// game over....
			if (won()) {
				saveScore();
			} else {
				JOptionPane.showMessageDialog(this.GUI, "It's a tie!");
			}
			if (!keepPlaying()) {
				end();
			} else {
				resetGame();
				return;
			}
		}
		this.currPlayer = (this.currPlayer == 1) ? 2 : 1;
		this.GUI.playerLabel.setText("Player " + this.currPlayer + ":");
		if (this.computerPlayerFlag && this.currPlayer == 2) {
			getComputerInput();
			this.currPlayer = (this.currPlayer == 1) ? 2 : 1;
			this.displayGrid();
		}
		if (won()) {
			saveScore();
			if (!keepPlaying()) {
				end();
			} else {
				resetGame();
				return;
			}
		}
	}

	public boolean getComputerInput() {
		switch (this.difficulty) {
		case 1:
			// Check Center
			if (!this.grid.isShown(1, 1)) {
				this.grid.setValue(1, 1, false);
				this.grid.show(1, 1);
				return true;
			}
			// Check Diagonals
			for (int i = 0; i < 3; i += 2) {
				for (int j = 0; j < 3; j += 2) {
					if (!this.grid.isShown(i, j)) {
						this.grid.setValue(i, j, false);
						this.grid.show(i, j);
						return true;
					}
				}
			}
			// Check "Cross"
			if (!this.grid.isShown(1, 0)) {
				this.grid.setValue(1, 0, false);
				this.grid.show(1, 0);
				return true;
			}
			if (!this.grid.isShown(1, 2)) {
				this.grid.setValue(1, 2, false);
				this.grid.show(1, 2);
				return true;
			}
			if (!this.grid.isShown(0, 1)) {
				this.grid.setValue(0, 1, false);
				this.grid.show(0, 1);
				return true;
			}
			if (!this.grid.isShown(2, 1)) {
				this.grid.setValue(2, 1, false);
				this.grid.show(2, 1);
				return true;
			}
			return false;
		case 2:
			// Check Diagonals
			for (int i = 0; i < 3; i += 2) {
				for (int j = 0; j < 3; j += 2) {
					if (!this.grid.isShown(i, j)) {
						this.grid.setValue(i, j, false);
						this.grid.show(i, j);
						return true;
					}
				}
			}
			// Check Center
			if (!this.grid.isShown(1, 1)) {
				this.grid.setValue(1, 1, false);
				this.grid.show(1, 1);
				return true;
			}
			// Check "Cross"
			if (!this.grid.isShown(1, 0)) {
				this.grid.setValue(1, 0, false);
				this.grid.show(1, 0);
				return true;
			}
			if (!this.grid.isShown(1, 2)) {
				this.grid.setValue(1, 2, false);
				this.grid.show(1, 2);
				return true;
			}
			if (!this.grid.isShown(0, 1)) {
				this.grid.setValue(0, 1, false);
				this.grid.show(0, 1);
				return true;
			}
			if (!this.grid.isShown(2, 1)) {
				this.grid.setValue(2, 1, false);
				this.grid.show(2, 1);
				return true;
			}
			return false;
		}
		return false;
	}

	private boolean keepPlaying() {
		int k = JOptionPane.showConfirmDialog(this.GUI, "Keep playing?",
				"Keep playing?", JOptionPane.YES_NO_OPTION);
		if (k == JOptionPane.YES_OPTION) {
			this.grid = new Grid<Boolean>(3, 3, "bool");
			return true;
		}
		return false;
	}

	public void end() {
		saveScore();
		this.GUI.setVisible(false);
		try {
			this.finalize();
		} catch (Throwable e) {
		}
	}

	public void displayGrid() {
		JLabel[][] labels = this.GUI.gridLabels;
		for (int i = 0; i < labels[0].length; i++) {
			labels[0][i].setText(i + "");
			if (i == 0)
				labels[0][i].setText(" ");
		}
		for (int i = 1; i < labels.length; i++) {
			labels[i][0].setText(i + "");
			for (int j = 1; j < labels[i].length; j++) {
				if (this.grid.isShown(j - 1, i - 1)) {
					if (this.grid.getValueAt(j - 1, i - 1)) {
						labels[i][j].setText("X");
					} else {
						labels[i][j].setText("O");
					}
				} else {
					// Empty Space 
					labels[i][j].setText("_|");
				}
			}
		}
	}
}
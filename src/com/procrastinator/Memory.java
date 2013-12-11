/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.*;

public class Memory extends Game implements TwoPlayer {
	private Grid<Integer> board;
	private int size, currPlayer, prevX, prevY;
	public MemoryGUI GUI;
	public int c = 0;

	public Memory(int difficulty, boolean playerFlag) {
		super("Memory", difficulty, 2, !playerFlag);
		switch (this.difficulty) {
		case 1:
			this.size = 4;
			break;
		case 2:
			this.size = 6;
			break;
		case 3:
			this.size = 8;
			break;
		case 4:
			this.size = 10;
			break;
		default:
			this.size = 4;
			break;
		}
		this.board = new Grid<Integer>(this.size, this.size, "int");
		this.GUI = new MemoryGUI(this.board.getSizeY() + 1,
				this.board.getSizeX() + 1);
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
		this.currPlayer = 1;
		this.prevX = -1;
		this.prevY = -1;
	}

	public Memory() {
		this(1, false);
	}

	public void startGame() {
		// this.board.setGridType("covered");
		fillBoard();
		this.displayGrid();
		this.GUI.firstPanel.setVisible(true);
		this.GUI.secondPanel.setVisible(false);
		this.GUI.setVisible(true);
	}

	private void fillBoard() {
		int n = 1;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (j + 1 < this.size) {
					this.board.setValue(i, j, n);
					this.board.setValue(i, ++j, n);
				} else {
					break;
				}
				n++;
			}
		}
		shuffleBoard();
	}

	private void shuffleBoard() {
		int totalSize = this.board.getTotalCapacity();
		for (int i = 0; i < totalSize; i++) {
			int n1 = (int) (Math.random() * ((totalSize)));
			int n2 = (int) (Math.random() * ((totalSize)));
			swap(n1, n2);
		}
	}

	private void swap(int n1, int n2) {
		int temp = this.board.getValueAt((n1 / this.size), (n1 % this.size));
		this.board.setValue((n1 / this.size), (n1 % this.size),
				this.board.getValueAt((n2 / this.size), (n2 % this.size)));
		this.board.setValue((n2 / this.size), (n2 % this.size), temp);
	}

	public void getInput() {
		if (this.computerPlayerFlag && this.currPlayer == 2) {
			getComputerInput();
			this.currPlayer = 1;
			if (won()) {
				if (this.score[0] > this.score[1])
					JOptionPane.showMessageDialog(this.GUI, "Player 1 won!");
				else if (this.score[1] > this.score[0])
					JOptionPane.showMessageDialog(this.GUI, "Player 2 won!");
				else
					JOptionPane.showMessageDialog(this.GUI, "It's a tie");
				saveScore();
				end();
			}
			this.prevX = -1;
			this.prevY = -1;
			return;
		}
		if (this.prevX < 0 && this.prevY < 0) {
			try {
				this.prevX = Integer.parseInt(this.GUI.xField1.getText()
						.toString()) - 1;
				this.prevY = Integer.parseInt(this.GUI.yField1.getText()
						.toString()) - 1;
				this.GUI.xField1.setText("");
				this.GUI.yField1.setText("");
				if (this.prevX < 0 || this.prevX >= this.size || this.prevY < 0
						|| this.prevY >= this.size)
					throw new NumberFormatException("Out of Bounds");
				this.GUI.firstPanel.setVisible(false);
				this.GUI.secondPanel.setVisible(true);
				this.board.show(this.prevX, this.prevY);
				this.displayGrid();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this.GUI, "Invalid Input");
				this.prevX = -1;
				this.prevY = -1;
				return;
			}
		} else {
			try {
				int x = Integer.parseInt(this.GUI.xField2.getText().toString()) - 1;
				int y = Integer.parseInt(this.GUI.yField2.getText().toString()) - 1;
				this.GUI.xField2.setText("");
				this.GUI.yField2.setText("");
				if (x < 0 || x >= this.size || y < 0 || y >= this.size)
					throw new NumberFormatException("Out of Bounds");
				this.GUI.firstPanel.setVisible(true);
				this.GUI.secondPanel.setVisible(false);
				this.board.show(x, y);
				this.displayGrid();
				this.currPlayer = (this.currPlayer == 1) ? 2 : 1;
				checkCoords(x, y);
				this.prevX = -1;
				this.prevY = -1;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this.GUI, "Invalid Input");
				return;
			}
		}
		if (won()) {
			if (this.score[0] > this.score[1])
				JOptionPane.showMessageDialog(this.GUI, "Player 1 won!");
			else if (this.score[1] > this.score[0])
				JOptionPane.showMessageDialog(this.GUI, "Player 2 won!");
			else
				JOptionPane.showMessageDialog(this.GUI, "It's a tie");
			saveScore();
			end();
		}
	}

	private void checkCoords(int x, int y) {
		if (this.board.getValueAt(this.prevX, this.prevY) != this.board
				.getValueAt(x, y)) {
			this.board.hide(this.prevX, this.prevY);
			this.board.hide(x, y);
		} else
			addScore(this.currPlayer - 1, 1);
	}

	public boolean won() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (!this.board.isShown(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean getComputerInput() {
		int x, y, c = 0; // check if there are available spaces
		do {
			c++;
			if (c >= this.board.getTotalCapacity())
				return false;
			do {
				this.prevX = (int) (Math.random() * this.size + 1);
			} while (this.prevX >= this.size);
			do {
				this.prevY = (int) (Math.random() * this.size + 1);
			} while (this.prevY >= this.size);
		} while (this.board.isShown(this.prevX, this.prevY));
		c = 0;
		do {
			c++;
			if (c >= this.board.getTotalCapacity())
				return false;
			do {
				x = (int) (Math.random() * this.size + 1);
			} while (x >= this.size);
			do {
				y = (int) (Math.random() * this.size + 1);
			} while (y >= this.size);
		} while (this.board.isShown(x, y));
		this.board.show(this.prevX, this.prevY);
		this.board.show(x, y);
		this.displayGrid();
		checkCoords(x, y);
		return true;
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
			if (i < 10)
				labels[0][i].setText("  " + i + " ");
			else
				labels[0][i].setText(" " + i + " ");
			if (i == 0)
				labels[0][i].setText(" ");
		}
		for (int i = 1; i < labels.length; i++) {
			labels[i][0].setText(i + "");
			for (int j = 1; j < labels[i].length; j++) {
				if (this.board.isShown(j - 1, i - 1)) {
					String temp = this.board.getValueAt(j - 1, i - 1)
							.toString();
					if (temp.length() > 1)
						labels[i][j].setText(" " + temp);
					else
						labels[i][j].setText(" " + temp + " ");
				} else {
					// Filled Rectangle
					labels[i][j].setText(" # ");
				}
			}
		}
	}
}
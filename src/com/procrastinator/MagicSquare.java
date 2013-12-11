/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.*;

public class MagicSquare extends Game {
	private Grid<Integer> square;
	private int zeroX, zeroY;
	public MagicGUI GUI;

	public MagicSquare(int difficulty) {
		super("Magic Square", difficulty, 1, false);
		switch (this.difficulty) {
		case 1:
			this.square = new Grid<Integer>(3, 3, "int");
			break;
		case 2:
			this.square = new Grid<Integer>(4, 4, "int");
			break;
		case 3:
			this.square = new Grid<Integer>(5, 5, "int");
			break;
		case 4:
			this.square = new Grid<Integer>(6, 6, "int");
			break;
		}
		this.GUI = new MagicGUI(this.square.getSizeY(), this.square.getSizeX());
		this.zeroX = 0;
		this.zeroY = 0;
		initSquare();
	}

	public MagicSquare() {
		this(1);
	}

	private void initSquare() {
		for (int i = 0; i < this.square.getTotalCapacity(); i++)
			this.square.setValue(i % this.square.getSizeX(),
					i / this.square.getSizeY(), i);
	}

	public void startGame() {
		mixNumbers();
		this.GUI.backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end();
			}
		});
		this.GUI.upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput(0);
			}
		});
		this.GUI.downButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput(1);
			}
		});
		this.GUI.leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput(2);
			}
		});
		this.GUI.rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput(3);
			}
		});
		this.GUI.setVisible(true);
		displayGrid();
	}

	private void mixNumbers() {
		int rand, x, y, cap = this.square.getTotalCapacity();
		for (int i = 0; i < cap * cap; i++) {
			do {
				rand = (int) (Math.random() * 4);
				switch (rand) {
				case 0:
					x = this.zeroX;
					y = this.zeroY - 1;
					break;
				case 1:
					x = this.zeroX;
					y = this.zeroY + 1;
					break;
				case 2:
					x = this.zeroX - 1;
					y = this.zeroY;
					break;
				case 3:
					x = this.zeroX + 1;
					y = this.zeroY;
					break;
				default: // Shouldn't happen
					x = this.zeroX;
					y = this.zeroY;
				}
			} while (!isLegal(x, y));
			swapNumber(x, y);
		}
	}

	private boolean isLegal(int x, int y) {
		if (x >= this.square.getSizeX() || y >= this.square.getSizeY())
			return false;
		if (x < 0 || y < 0)
			return false;
		if (x == this.zeroX - 1 && y == this.zeroY)
			return true;
		if (x == this.zeroX + 1 && y == this.zeroY)
			return true;
		if (x == this.zeroX && y == this.zeroY - 1)
			return true;
		if (x == this.zeroX && y == this.zeroY + 1)
			return true;
		return false;
	}

	private void swapNumber(int x, int y) {
		if (!isLegal(x, y))
			return;
		this.square.setValue(zeroX, zeroY, this.square.getValueAt(x, y));
		if (x == this.zeroX - 1 && y == this.zeroY)
			this.zeroX--;
		if (x == this.zeroX + 1 && y == this.zeroY)
			this.zeroX++;
		if (x == this.zeroX && y == this.zeroY - 1)
			this.zeroY--;
		if (x == this.zeroX && y == this.zeroY + 1)
			this.zeroY++;
		this.square.setValue(zeroX, zeroY, 0);
	}

	public boolean won() {
		int c = 1;
		for (int i = 0; i < this.square.getSizeY(); i++) {
			for (int j = 0; j < this.square.getSizeX(); j++) {
				if (this.square.getValueAt(j, i) == 0) {
					continue;
				}
				if (this.square.getValueAt(j, i) != c)
					return false;
				c++;
			}
		}
		return true;
	}

	public void getInput(int dir) {
		switch (dir) {
		case 0:
			if (this.zeroY > 0) {
				this.square.setValue(zeroX, zeroY,
						this.square.getValueAt(zeroX, zeroY - 1));
				this.zeroY--;
			} else {
				JOptionPane.showMessageDialog(this.GUI, "Invalid move");
				return;
			}
			break;
		case 1:
			if (this.zeroY < this.square.getSizeY() - 1) {
				this.square.setValue(zeroX, zeroY,
						this.square.getValueAt(zeroX, zeroY + 1));
				this.zeroY++;
			} else {
				JOptionPane.showMessageDialog(this.GUI, "Invalid move");
				return;
			}
			break;
		case 2:
			if (this.zeroX > 0) {
				this.square.setValue(zeroX, zeroY,
						this.square.getValueAt(zeroX - 1, zeroY));
				this.zeroX--;
			} else {
				JOptionPane.showMessageDialog(this.GUI, "Invalid move");
				return;
			}
			break;
		case 3:
			if (this.zeroX < this.square.getSizeX() - 1) {
				this.square.setValue(zeroX, zeroY,
						this.square.getValueAt(zeroX + 1, zeroY));
				this.zeroX++;
			} else {
				JOptionPane.showMessageDialog(this.GUI, "Invalid move");
				return;
			}
			break;
		}
		this.square.setValue(zeroX, zeroY, 0);
		displayGrid();
		if (won()) {
			displayGrid();
			JOptionPane.showMessageDialog(this.GUI, "You have won!");
			this.GUI.setVisible(false);
			this.GUI.dispose();
			try {
				this.finalize();
			} catch (Throwable e) {
			}
		}
	}

	public void end() {
		this.GUI.setVisible(false);
		try {
			this.finalize();
		} catch (Throwable e) {
		}
	}

	public void displayGrid() {
		JLabel[][] labels = this.GUI.gridLabels;
		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels[i].length; j++) {
				String temp = this.square.getValueAt(j, i).toString();
				if (temp.equals("0")) labels[i][j].setForeground(Color.RED);
				else labels[i][j].setForeground(Color.WHITE);
				if (temp.length()>1) 
					labels[i][j].setText(" "+temp+" ");
				else
					labels[i][j].setText("  "+temp+" ");
			}
		}
	}
}
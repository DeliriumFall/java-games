/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MineSweeper extends Game {
	private static final int MIN_SIZE = 3, MAX_SIZE = 21, MIN_MINES = 9,
			MAX_MINES = 50;
	private int mines, flags;
	private int[][] flagsSet;
	private double startTime, timeElapsed;
	public MineGUI GUI;
	private Grid<Integer> grid;
	/*
	 * Nothing => 0 Value => 1-8 Mine => 9 Flag => 10 Unknown => 11
	 */
	private String[][] criteria = { { "0", " " },
			{ "1", "1" }, { "2", "2" }, { "3", "3" }, { "4", "4" },
			{ "5", "5" }, { "6", "6" }, { "7", "7" }, { "8", "8" },
			{ "9", "*" }, { "10", "F" }, { "11", "?" } };
	
	public MineSweeper(int difficulty) {
		super("Mine Sweeper", difficulty, 1, false);
		setByDifficulty(difficulty, 0);
		this.timeElapsed = 0.0;
		this.startTime = 0.0;
	}

	public MineSweeper(int mines, int sizeX, int sizeY) {
		super("Mine Sweeper", 1, 1, false);
		if (mines < MIN_MINES || mines > MAX_MINES || (sizeX * sizeY) < mines)
			mines = MIN_MINES;
		if (sizeX > MIN_SIZE && sizeY > MIN_SIZE && sizeX < MAX_SIZE
				&& sizeY < MAX_SIZE) {
			this.grid = new Grid<Integer>(sizeX, sizeY, "int");
		} else {
			this.grid = new Grid<Integer>(10, 8, "int");
		}
		// Contrary to the ANSWER to everything for being unnatural
		setByDifficulty(-42, mines);
		this.timeElapsed = 0.0;
		this.startTime = 0.0;
	}

	// Should not be used with our implementation
	// just wrote it to comply with the Java doc.
	public MineSweeper() {
		this(1);
	}

	private void setByDifficulty(int difficulty, int mines) {
		switch (difficulty) {
		case 1:
			this.mines = 10;
			this.grid = new Grid<Integer>(10, 8, "int");
			break;
		case 2:
			this.mines = 20;
			this.grid = new Grid<Integer>(12, 10, "int");
			break;
		case 3:
			this.mines = 30;
			this.grid = new Grid<Integer>(15, 15, "int");
			break;
		default:
			// Should only get here if it is "Custom"
			this.mines = mines;
			break;
		}
		this.GUI = new MineGUI(this.grid.getSizeY() + 1,
				this.grid.getSizeX() + 1);
		this.flags = this.mines;
		this.flagsSet = new int[this.grid.getSizeY()][this.grid.getSizeX()];
		for (int i = 0; i < this.flagsSet.length; i++)
			for (int j = 0; j < this.flagsSet[i].length; j++)
				this.flagsSet[i][j] = -1;
	}

	public void startGame() {
		setMines();
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
		this.startTime = System.currentTimeMillis();
		this.GUI.actionRadio2.setText("Flag (" + this.flags + " left)");
		this.GUI.setVisible(true);
		displayGrid();
	}

	public boolean won() {
		for (int i = 0; i < this.grid.getSizeY(); i++)
			for (int j = 0; j < this.grid.getSizeX(); j++)
				if (this.grid.getValueAt(j, i) == 10)
					if (this.flagsSet[i][j] != 9)
						return false;
		try {
			return (this.flags == 0);
		} catch (NullPointerException e) {
			return true;
		}
	}

	private void setMines() {
		boolean[][] set = new boolean[this.grid.getSizeX()][this.grid
				.getSizeY()];
		int randX, randY;
		for (int i = 0; i < this.mines; i++) {
			randX = (int) (Math.random() * (grid.getSizeX()));
			randY = (int) (Math.random() * (grid.getSizeY()));
			// Make sure value is not already set
			while (set[randX][randY]) {
				randX = (int) (Math.random() * grid.getSizeX());
				randY = (int) (Math.random() * grid.getSizeY());
			}
			set[randX][randY] = true;
			grid.setValue(randX, randY, 9);
		}
		setValues();
	}

	private void setValues() {
		int c, x = grid.getSizeX(), y = grid.getSizeY();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				c = 0;
				if (grid.getValueAt(j, i) == 9) {
					continue;
				}
				if (i > 0) {
					if (j > 0) {
						if (grid.getValueAt(j - 1, i - 1) == 9)
							c++;
					}
					if (grid.getValueAt(j, i - 1) == 9)
						c++;
					if (j < x - 1) {
						if (grid.getValueAt(j + 1, i - 1) == 9)
							c++;
					}
				}
				if (j > 0) {
					if (grid.getValueAt(j - 1, i) == 9)
						c++;
				}
				if (j < x - 1) {
					if (grid.getValueAt(j + 1, i) == 9)
						c++;
				}
				if (i < y - 1) {
					if (j > 0) {
						if (grid.getValueAt(j - 1, i + 1) == 9)
							c++;
					}
					if (grid.getValueAt(j, i + 1) == 9)
						c++;
					if (j < x - 1) {
						if (grid.getValueAt(j + 1, i + 1) == 9)
							c++;
					}
				}
				grid.setValue(j, i, c);
			}
		}
	}

	public void getInput() {
		int x = 0, y = 0;
		this.timeElapsed = (System.currentTimeMillis() - this.startTime) / 1000;
		if (this.GUI.xField.getText().equals("")
				|| this.GUI.yField.getText().equals("")) {
			JOptionPane.showMessageDialog(this.GUI, "Invalid Coordinates");
			return;
		}
		x = Integer.parseInt(this.GUI.xField.getText()) - 1;
		y = Integer.parseInt(this.GUI.yField.getText()) - 1;
		this.GUI.xField.setText("");
		this.GUI.yField.setText("");
		if (x >= this.grid.getSizeX() || y >= this.grid.getSizeY() || x<0 || y<0) {
			JOptionPane.showMessageDialog(this.GUI, "Invalid Coordinates");
			return;
		}
		String op;
		if (this.GUI.actionRadio1.isSelected()) {
			op = "c";
		} else if (this.GUI.actionRadio2.isSelected()) {
			op = "F";
		} else {
			op = "?";
		}
		switch (op) {
		case "F":
			if (this.flagsSet[y][x] > -1) {
				if (this.grid.getValueAt(x, y) == 10)
					this.flags++;
				this.flagsSet[y][x] = -1;
				this.grid.hide(x, y);
			}
			this.flagsSet[y][x] = this.grid.getValueAt(x, y);
			this.grid.setValue(x, y, 10);
			this.grid.show(x, y);
			this.flags--;
			break;
		case "?":
			if (this.flagsSet[y][x] > -1) {
				if (this.grid.getValueAt(x, y) == 10)
					this.flags++;
				this.flagsSet[y][x] = -1;
				this.grid.hide(x, y);
			}
			this.flagsSet[y][x] = this.grid.getValueAt(x, y);
			this.grid.setValue(x, y, 11);
			this.grid.show(x, y);
			break;
		default:
			if (this.flagsSet[y][x] > -1) {
				if (this.grid.getValueAt(x, y) == 10)
					this.flags++;
				this.grid.setValue(x, y, this.flagsSet[y][x]);
				this.flagsSet[y][x] = -1;
				this.grid.hide(x, y);
			}
			if (this.grid.getValueAt(x, y) == 9) {
				// game over...
				showAllMines();
				int c = 0;
				for (int i = 0; i < this.grid.getSizeY(); i++)
					for (int j = 0; j < this.grid.getSizeX(); j++)
						if (this.grid.getValueAt(j, i) == 10)
							if (this.flagsSet[i][j] == 9)
								c++;
				addScore(0, (c * 10 - this.timeElapsed));
				saveScore();
				end();
			}
			this.grid.show(x, y);
			showNearValues(x, y); // Shows the empty spaces around tile
			break;
		}
		if (won()) {
			addScore(0, ((this.mines * 10) - this.timeElapsed));
			saveScore();
			JOptionPane.showMessageDialog(this.GUI, "You've won!");
			end();
		}
		this.GUI.actionRadio2.setText("Flag (" + this.flags + " left)");
		displayGrid();
	}

	private void showNearValues(int x, int y) {
		int cur;
		for (int i = y; i >= 0; i--) {
			for (int j = x; j >= 0; j--) {
				cur = grid.getValueAt(j, i);
				if (cur == 9)
					break;
				grid.show(j, i);
			}
			for (int j = x; j < grid.getSizeX(); j++) {
				cur = grid.getValueAt(j, i);
				if (cur == 9)
					break;
				grid.show(j, i);
			}
		}
		for (int i = y; i < grid.getSizeY(); i++) {
			for (int j = x; j >= 0; j--) {
				cur = grid.getValueAt(j, i);
				if (cur == 9)
					break;
				grid.show(j, i);
			}
			for (int j = x; j < grid.getSizeX(); j++) {
				cur = grid.getValueAt(j, i);
				if (cur == 9)
					break;
				grid.show(j, i);
			}
		}
	}

	private void showAllMines() {
		JOptionPane.showMessageDialog(this.GUI, "Game Over!");
		for (int i = 0; i < grid.getSizeY(); i++)
			for (int j = 0; j < grid.getSizeX(); j++)
				if (grid.getValueAt(j, i) == 9)
					grid.show(j, i);
		displayGrid();
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
		for (int i = 0; i < labels[0].length; i++) {
			labels[0][i].setText(i + "");
			if (i == 0)
				labels[0][i].setText(" ");
		}
		for (int i = 1; i < labels.length; i++) {
			labels[i][0].setText(i + "");
			for (int j = 1; j < labels[i].length; j++) {
				if (this.grid.isShown(j-1, i-1)) {
					for (int k = 0; k < this.criteria.length; k++) {
						if (this.grid.getValueAt(j-1, i-1).toString()
								.equals(this.criteria[k][0])) {
							labels[i][j].setText(this.criteria[k][1]);
							break;
						}
					}
				} else {
					// Filled Rectangle
					labels[i][j].setText("#");
				}
			}
		}
	}
}
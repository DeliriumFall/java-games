/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Codes extends Game {
	private int[] numbers, set;
	private int steps, maxNumber;
	public CodesGUI GUI;

	public Codes(int difficulty) {
		super("Guess the Code", difficulty, 1, false);
		this.GUI = new CodesGUI();
		switch (this.difficulty) {
		// Cases 4-6 repeat numbers
		case 1:
		case 4:
			this.maxNumber = 6;
			this.numbers = new int[4];
			this.set = new int[4];
			this.steps = 8;
			break;
		case 2:
		case 5:
			this.maxNumber = 8;
			this.numbers = new int[4];
			this.set = new int[4];
			this.steps = 10;
			break;
		case 3:
		case 6:
			this.maxNumber = 12;
			this.numbers = new int[5];
			this.set = new int[5];
			this.steps = 12;
			break;
		default: // Shouldn't happen
			this.maxNumber = 6;
			this.numbers = new int[4];
			this.set = new int[4];
			this.steps = 8;
			break;
		}
		this.GUI.backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end();
			}
		});
		this.GUI.turnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getInput();
			}
		});
		this.GUI.instLabel.setText("Write the " + this.numbers.length
				+ " numbers (1 - " + this.maxNumber + ")");
	}

	public Codes() {
		super("Guess the Code", 1, 1, false);
		this.maxNumber = 6;
		this.numbers = new int[4];
		this.set = new int[4];
		this.steps = 8;
		this.GUI = new CodesGUI();
		this.GUI.setTitle(this.name);
		this.GUI.instLabel.setText("Write the " + this.numbers.length
				+ " numbers (1 to " + this.maxNumber + ")");
	}

	public void startGame() {
		setNumbers();
		this.GUI.setVisible(true);
		display();
	}

	public boolean won() {
		for (int i = 0; i < this.numbers.length; i++) {
			if (this.numbers[i] != this.set[i])
				return false;
		}
		return true;
	}

	public void setNumbers() {
		int rand;
		if (this.difficulty <= 3) { // Not repeated numbers
			for (int i = 0; i < this.numbers.length; i++) {
				rand = 1 + (int) (Math.random() * (maxNumber - 1));
				while (isSet(rand, i)) {
					rand = 1 + (int) (Math.random() * (maxNumber - 1));
				}
				this.numbers[i] = rand;
			}
		} else {
			for (int i = 0; i < this.numbers.length; i++) {
				rand = 1 + (int) (Math.random() * (maxNumber - 1));
				this.numbers[i] = rand;
			}
		}
	}

	private boolean isSet(int col, int i) {
		for (int j = 0; j < i; j++) {
			if (this.numbers[j] == col)
				return true;
		}
		return false;
	}

	public void getInput() {
		String[] numberStr = this.GUI.answerField.getText().split(" ");
		for (int i = 0; i < this.set.length; i++) {
			if (numberStr[i].equals("") || numberStr.length < this.set.length) {
				// Empty or Incomplete Input
				JOptionPane.showMessageDialog(this.GUI, "Invalid Input");
				for (int j = 0; j < i; j++)
					this.set[j] = 0;
				return;
			}
			this.set[i] = Integer.parseInt(numberStr[i]);
		}
		this.steps--;
		display();
		if (won() || this.steps <= 0) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < this.numbers.length; i++)
				str.append(this.numbers[i] + " ");
			str.append("\n");
			if (won()) {
				str.append("You've won!\n");
				addScore(0, ((this.difficulty * 10) + this.steps));
			} else {
				str.append("You lost =/\n");
			}
			JOptionPane.showMessageDialog(this.GUI, str);
			end();
		}
	}

	public void display() {
		this.GUI.answerField.setText("");
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.set.length; i++)
			str.append(this.set[i] + " ");
		this.GUI.previousArea.setText(this.GUI.previousArea.getText() + "\n" + str);
		this.GUI.chancesField.setText(this.steps + "");
		int c = 0, p = 0;
		for (int i = 0; i < this.set.length; i++) {
			if (this.numbers[i] == this.set[i])
				p++;
			if (isSet(set[i], this.set.length))
				c++;
		}
		this.GUI.numbersField.setText(c + "");
		this.GUI.placesField.setText(p + "");
	}

	public void end() {
		saveScore();
		this.GUI.setVisible(false);
		try {
			this.finalize();
		} catch (Throwable e) {
		}
	}
}
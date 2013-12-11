/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import java.util.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class Hangman extends Game implements TwoPlayer {
	private char[] word, guess;
	private int chances, currPlayer;
	private boolean[] letters;
	public HangGUI GUI;

	public Hangman(boolean player) {
		super("Hangman", 1, 2, !player);
		this.letters = new boolean[26];
		this.GUI = new HangGUI();
	}

	public Hangman() {
		this(false);
	}

	private void getDictionaryWord() {
		// Choose the word
		int rand = (int) (Math.random() * 81536);
		Scanner in = null;
		try {
			in = new Scanner(new FileInputStream("dictionary.txt"));
			for (int i = 0; i < rand; i++) {
				in.nextLine();
			}
			this.word = in.next().toCharArray();
		} catch (FileNotFoundException e) {
			// Because of reasons
			this.word = "fortytwo".toCharArray();
		}
	}

	private void getWord() {
		try {
			this.word = JOptionPane
					.showInputDialog(this.GUI, "Write the word to guess")
					.toLowerCase().toCharArray();
			// Check that word is alphabetical only
			for (int i = 0; i < this.word.length; i++) {
				if (Character.isDigit(this.word[i])) {
					this.word = new char[0];
					break;
				}
			}
		} catch (NullPointerException e) {
			getWord();
		}
		if (this.word.length == 0)
			getWord();
	}

	public void startGame() {
		this.currPlayer = 1;
		this.GUI.setVisible(true);
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
		resetGame();
	}

	public void resetGame() {
		if (this.computerPlayerFlag && this.currPlayer == 1)
			getDictionaryWord();
		else
			getWord();
		this.guess = new char[this.word.length];
		for (int i = 0; i < this.letters.length; i++) {
			this.letters[i] = false;
		}
		// For debugging
		// System.out.println(Arrays.toString(this.word));
		this.chances = 10;
		this.GUI.chanceLabel.setText(this.chances + " chances left.");
		this.GUI.wordField.setText("");
		this.GUI.usedArea.setText("");
		setGuess();
	}

	public boolean keepPlaying() {
		int reply = JOptionPane.showConfirmDialog(this.GUI, "Keep playing?",
				"Keep playing?", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			this.currPlayer = (this.currPlayer == 1) ? 2 : 1;
			return true;
		}
		return false;
	}

	public boolean won() {
		for (int i = 0; i < this.word.length; i++)
			if (this.guess[i] != this.word[i])
				return false;
		return true;
	}

	private void displayGuess() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.letters.length; i++) {
			if (this.letters[i])
				str.append(getLetter(i) + " ");
		}
		this.GUI.usedArea.setText(str.toString());
		this.GUI.chanceLabel.setText(this.chances + " chances left.");
		str = new StringBuilder();
		for (int i = 0; i < this.guess.length; i++) {
			str.append(this.guess[i] + " ");
		}
		this.GUI.wordField.setText(str.toString());
	}

	private void displayWord() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < this.word.length; i++) {
			str.append(this.word[i]);
		}
		this.GUI.wordField.setText(str.toString());
	}

	private void setGuess() {
		for (int i = 0; i < this.guess.length; i++) {
			this.guess[i] = '_';
		}
	}

	public void getInput() {
		if (this.computerPlayerFlag && this.currPlayer == 2) {
			getComputerInput();
			if (!won() && this.chances > 0) {
				displayGuess();
			} else {
				displayWord();
				if (this.chances > 0) {
					JOptionPane.showMessageDialog(this.GUI, "Player "
							+ this.currPlayer + " wins!");
				} else {
					JOptionPane.showMessageDialog(this.GUI, "Player 1 Won!");
				}
				addScore(this.currPlayer - 1, 10);
				if (!keepPlaying()) {
					end();
				} else {
					resetGame();
				}
			}
			return;
		}
		String l = this.GUI.letterField.getText();
		if (l.equals("")) {
			JOptionPane.showMessageDialog(this.GUI, "Invalid input");
			return;
		}
		char letter = l.toLowerCase().charAt(0);
		this.GUI.letterField.setText("");
		try {
			if (this.letters[letter - 'a']) {
				JOptionPane.showMessageDialog(this.GUI, "Invalid input");
				return;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(this.GUI, "Invalid input");
			return;
		}
		checkLetter(letter);
		if (!won() && this.chances > 0) {
			displayGuess();
		} else {
			displayWord();
			if (this.chances > 0) {
				JOptionPane.showMessageDialog(this.GUI, "Player "
						+ this.currPlayer + " wins!");
			} else {
				if (this.currPlayer == 2) {
					JOptionPane.showMessageDialog(this.GUI, "Player 1 Won!");
				} else {
					JOptionPane.showMessageDialog(this.GUI, "Player 2 Won!");
				}
			}
			addScore(this.currPlayer - 1, 10);
			if (!keepPlaying()) {
				end();
			} else {
				resetGame();
			}
		}
	}

	public boolean getComputerInput() {
		int rand = (int) (Math.random() * (26));
		while (this.letters[rand]) {
			rand = (int) (Math.random() * (26));
		}
		checkLetter(getLetter(rand));
		if (this.chances == 0)
			return false;
		return true;
	}

	private char getLetter(int l) {
		switch (l) {
		case 0:
			return 'a';
		case 1:
			return 'b';
		case 2:
			return 'c';
		case 3:
			return 'd';
		case 4:
			return 'e';
		case 5:
			return 'f';
		case 6:
			return 'g';
		case 7:
			return 'h';
		case 8:
			return 'i';
		case 9:
			return 'j';
		case 10:
			return 'k';
		case 11:
			return 'l';
		case 12:
			return 'm';
		case 13:
			return 'n';
		case 14:
			return 'o';
		case 15:
			return 'p';
		case 16:
			return 'q';
		case 17:
			return 'r';
		case 18:
			return 's';
		case 19:
			return 't';
		case 20:
			return 'u';
		case 21:
			return 'v';
		case 22:
			return 'w';
		case 23:
			return 'x';
		case 24:
			return 'y';
		case 25:
			return 'z';
		default:
			return 'a';
		}
	}

	private void checkLetter(char letter) {
		boolean found = false;
		this.letters[letter - 'a'] = true;
		for (int i = 0; i < this.word.length; i++) {
			if (this.word[i] == letter) {
				this.guess[i] = letter;
				found = true;
			}
		}
		if (!found) {
			this.chances--;
		}
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
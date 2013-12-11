/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import javax.swing.JFrame;
import java.awt.event.*;

public class Procrastinator {

	public static JFrame GUI;
	public static Game game;

	public static void main(String[] args) {
		GUI = new MainGUI();
		init();
	}

	private static void init() {
		//LOOL! Wildcards!
		Class<?> c = GUI.getClass();
		GUI.addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent e) {
				Class<?> c = GUI.getClass();
				if (c != MainGUI.class && c != CodesConfig.class
						&& c != MagicConfig.class && c != MineConfig.class
						&& c != HangConfig.class && c != MemoryConfig.class
						&& c != TicConfig.class) {
					GUI.setVisible(false);
					GUI.dispose();
					game = null;
					GUI = new MainGUI();
					init();
				}
			}
			public void componentMoved(ComponentEvent arg0) {}
			public void componentResized(ComponentEvent arg0) {}
			public void componentShown(ComponentEvent arg0) {}
		});
		if (c == MainGUI.class) {
			MainGUI g = (MainGUI) GUI;
			g.exitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			g.codesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new CodesConfig();
					init();
				}
			});
			g.magicButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MagicConfig();
					init();
				}
			});
			g.mineButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MineConfig();
					init();
				}
			});
			g.hangButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new HangConfig();
					init();
				}
			});
			g.memButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MemoryConfig();
					init();
				}
			});
			g.ticButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new TicConfig();
					init();
				}
			});
		} else if (c == CodesConfig.class) {
			CodesConfig g = (CodesConfig)GUI;
			g.backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MainGUI();
					init();
				}
			});
			g.nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CodesConfig g = (CodesConfig)GUI;
					int diff = Integer.parseInt(g.difficultyCombo.getSelectedItem().toString());
					game = new Codes(diff);
					Codes t = (Codes)game;
					GUI.setVisible(false);
					GUI.dispose();
					GUI = t.GUI;
					init();
				}
			});
		} else if (c == MagicConfig.class) {
			MagicConfig g = (MagicConfig)GUI;
			g.backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MainGUI();
					init();
				}
			});
			g.nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MagicConfig g = (MagicConfig)GUI;
					int diff = Integer.parseInt(g.difficultyCombo.getSelectedItem().toString());
					game = new MagicSquare(diff);
					MagicSquare t = (MagicSquare)game;
					GUI.setVisible(false);
					GUI.dispose();
					GUI = t.GUI;
					init();
				}
			});
		} else if (c == MineConfig.class) {	
			MineConfig g = (MineConfig)GUI;
			g.backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MainGUI();
					init();
				}
			});
			g.nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MineConfig g = (MineConfig)GUI;
					int diff = Integer.parseInt(g.difficultyCombo.getSelectedItem().toString());
					if (diff==1) {
						int mines, width, height;
						mines = Integer.parseInt(g.mineSpinner.getValue().toString());
						width = Integer.parseInt(g.widthSpinner.getValue().toString());
						height = Integer.parseInt(g.heightSpinner.getValue().toString());
						game = new MineSweeper(mines, width, height);
					} else game = new MineSweeper(diff);
					MineSweeper t = (MineSweeper)game;
					GUI.setVisible(false);
					GUI.dispose();
					GUI = t.GUI;
					init();
				}
			});
		}  else if (c == HangConfig.class) {	
			HangConfig g = (HangConfig)GUI;
			g.backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MainGUI();
					init();
				}
			});
			g.nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HangConfig g = (HangConfig)GUI;
					boolean computer = g.playerRadio2.isSelected();
					game = new Hangman(computer);
					Hangman t = (Hangman)game;
					GUI.setVisible(false);
					GUI.dispose();
					GUI = t.GUI;
					init();
				}
			});
		}  else if (c == MemoryConfig.class) {	
			MemoryConfig g = (MemoryConfig)GUI;
			g.backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MainGUI();
					init();
				}
			});
			g.nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemoryConfig g = (MemoryConfig)GUI;
					int diff = Integer.parseInt(g.difficultyCombo.getSelectedItem().toString());
					boolean player = g.playerRadio2.isSelected();
					game = new Memory(diff,player);
					Memory t = (Memory)game;
					GUI.setVisible(false);
					GUI.dispose();
					GUI = t.GUI;
					init();
				}
			});
		}  else if (c == TicConfig.class) {	
			TicConfig g = (TicConfig)GUI;
			g.backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI.setVisible(false);
					GUI.dispose();
					GUI = new MainGUI();
					init();
				}
			});
			g.nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TicConfig g = (TicConfig)GUI;
					int diff = Integer.parseInt(g.difficultyCombo.getSelectedItem().toString());
					boolean player = g.playerRadio2.isSelected();
					game = new TicTacToe(diff,player);
					TicTacToe t = (TicTacToe)game;
					GUI.setVisible(false);
					GUI.dispose();
					GUI = t.GUI;
					init();
				}
			});
		}
		GUI.setVisible(true);
		if (game != null) game.startGame();
	}
}
/*
 * @author: Diego Galindez Barreda
 * Matricula: A01370815
 */

package com.procrastinator;

import java.io.*;

public abstract class Game {
	protected String name;
	protected int difficulty, players;
	protected double[] score;
	protected boolean computerPlayerFlag;
        
	public Game() {
		this.name = "";
		this.difficulty = 0;
		this.players = 1;
		this.score = new double[1];
		this.score[0] = 0.0;
		this.computerPlayerFlag = false;
	}

	public Game(String name, int difficulty, int players, boolean flag) {
		this.difficulty = difficulty;
		this.name = name;
		this.players = players;
		this.score = new double[players];
		for (int i=0; i<players; i++) this.score[i] = 0;
		this.computerPlayerFlag = flag;
	}

	/* * * * * * * *  * * * * * * * *
	 *	    ABSTRACT METHODS	    *
	 * * * * * * * *  * * * * * * * */
	public abstract boolean won();
	public abstract void startGame();
	public abstract void end();
	
	//Player passed from 0 - players-1
	protected void addScore(int player, double score) {
		this.score[player]+=score;
	}

	protected boolean saveScore() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(this.name+".txt", true));
			for (int i=0; i<players; i++) {
				out.print("\nPlayer "+(i+1)+": ");
				out.print(this.score[i]);
				out.println();
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			//File couldn't be created or opened
			return false;
		}
		return true;
	}
}
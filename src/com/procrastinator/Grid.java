/*
 * Autor: Diego Galindez Barreda
 * Matricula: A01370815
 */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * CAN ONLY BE USED WITH PRIMITVE TYPE WRAPPER CLASSES!  *
 * genericType must be int, long, double, char, byte,	 *
 * bool or String					 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.procrastinator;

@SuppressWarnings("unchecked")
public class Grid<T> {
	private Object[][] data;
	private boolean[][] shown;
	private String genericType;

	public Grid(int sizeX, int sizeY, String genType) {
		this.genericType = genType;
		this.data = new Object[sizeY][sizeX];
		initGrid();
		this.shown = new boolean[sizeY][sizeX];
	}

	public Grid(int sizeX, int sizeY, String[][] criteria, String genType) {
		this.genericType = genType;
		this.data = new Object[sizeY][sizeX];
		initGrid();
		this.shown = new boolean[sizeY][sizeX];
	}

	// Will not be used, just to comply with the java doc.
	public Grid() {
		this.genericType = "int";
		this.data = new Object[5][5];
		initGrid();
		this.shown = new boolean[5][5];
	}

	private void initGrid() {
		for (int i = 0; i < this.data.length; i++) {
			for (int j = 0; j < this.data[i].length; j++) {
				switch (this.genericType) {
				case "int":
				case "long":
				case "double":
				case "byte":
					this.data[i][j] = 0;
					break;
				case "bool":
					this.data[i][j] = false;
					break;
				case "char":
					this.data[i][j] = ' ';
					break;
				default:
					this.data[i][j] = " ";
					break;
				}
			}
		}
	}

	/* * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * All (x,y) values are read in the array as (y,x),  * 
	 * y=> Number of Rows 								 *
	 * X=> Number of Columns 							 *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * */

	// Returns false if val could not be set or an IndexOutOfBoundsException was
	// thrown
	public boolean setValue(int x, int y, T val) {
		try {
			this.data[y][x] = (Object) val;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	// Returns false if an IndexOutOfBounds exception is thrown
	public boolean show(int x, int y) {
		try {
			this.shown[y][x] = true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	// Returns false if an IndexOutOfBounds exception is thrown
	public boolean hide(int x, int y) {
		try {
			this.shown[y][x] = false;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	// Returns false if element could not be removed or an
	// IndexOutOfBoundsException was thrown
	public boolean remove(int x, int y) {
		try {
			this.data[y][x] = null;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean isSet(int x, int y) {
		if (y >= this.data.length || x >= this.data[0].length || x < 0 || y < 0)
			return false;
		return (this.data[y][x] == null);
	}

	public boolean isShown(int x, int y) {
		if (y >= this.shown.length || x >= this.shown[0].length || x < 0
				|| y < 0)
			return false;
		return (this.shown[y][x]);
	}

	// Returns null if coordinates given are out of the grid's size
	public T getValueAt(int x, int y) {
		if (y >= this.data.length || x >= this.data[0].length || x < 0 || y < 0)
			return null;
		try {
			T temp = (T) this.data[y][x];
			return temp;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public int getSizeX() {
		return this.data[0].length;
	}

	public int getSizeY() {
		return this.data.length;
	}

	public int getTotalCapacity() {
		return this.data.length * this.data[0].length;
	}
}
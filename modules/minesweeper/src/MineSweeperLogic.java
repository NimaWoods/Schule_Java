

import java.util.Random;

import javax.swing.JOptionPane;

public class MineSweeperLogic {
	private static final int MINSIZE = 10;
	private static Random rnd = new Random();
	private int size;
	private int board[][];

	public MineSweeperLogic(int size) throws IllegalArgumentException {

		if (size < MINSIZE)
			throw new IllegalArgumentException(
					"The Board is too small. A side should have a minimum length of " + MINSIZE + ".");

		this.size = size;

		board = new int[size][];
		for (int i = 0; i < size; i++) {
			board[i] = new int[size];
//			for (int j = 0; j < MINSIZE; j++) {
//				board[i][j] = 0;
//			}
		}
		placeBombs();
		calculateNeighbours();
	}

	protected void placeBombs() {
		for (int b = 0; b < MINSIZE * 2; b++) {
			board[rnd.nextInt(MINSIZE)][rnd.nextInt(MINSIZE)] = 9;
		}
	}

	protected void calculateNeighbours() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = howManyBombsinNeighbourhood(i, j);
			}
		}
	}

	private int howManyBombsinNeighbourhood(int i, int j) {
		int counter = 0;
		if (board[i][j] == 9)
			return 9;

		for (int ii = i-1; ii < i + 2; ii++)
			for (int jj = j-1; jj < j + 2; jj++)
				if (inBounds(ii)&& inBounds(jj) && board[ii][jj] == 9)
					counter++;
		return counter;
	}
	protected boolean inBounds(int i) {
		return i>=0 && i<size;
	}

	public void consoleOut() {
		for (int[] row : board) {
			for (int r : row) {
				System.out.print(" | " + r);
			}
			System.out.println(" |");
			System.out.print(" ");
			for (int i = 0; i < size; i++) {
				System.out.print("----");
			}
			System.out.println("-");
		}
	}

	public int getSize() {
		return size;
	}

	public int getField(int i, int j){
		return board[i][j];
	}
	
	private void setSize(int size) {
		if (size >= MINSIZE)
			this.size = size;
		else {
			this.size = MINSIZE;
			JOptionPane.showMessageDialog(null, "Die Groesse wurde auf das Mindestmass angehoben.");
		}
	}


}

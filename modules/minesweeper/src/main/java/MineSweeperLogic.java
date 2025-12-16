

import java.util.ArrayList;
import java.util.Random;

public class MineSweeperLogic {
	private static final int MINSIZE = 10;
	private static Random rnd = new Random();
	private int size;
	private int[][] board;
    private boolean[][] flagged;
    private boolean[][] revealed;
    private final ArrayList<int[]> moves = new ArrayList<>();
    private final ArrayList<int[]> undos = new ArrayList<>();

    public void setup(int size) throws IllegalArgumentException {

        System.out.println("Starting Game with size " + size);

        if (size < MINSIZE)
            throw new IllegalArgumentException(
                    "The Board is too small. A side should have a minimum length of " + MINSIZE + ".");

        this.size = size;

        board = new int[size][];
        for (int i = 0; i < size; i++) {
            board[i] = new int[size];
        }
        placeBombs();
        calculateNeighbours();

        flagged = new boolean[size][size];
        revealed = new boolean[size][size];
    }

    protected void placeBombs() {
        int bombCount = size * 2;
        for (int b = 0; b < bombCount; b++) {
            int x = rnd.nextInt(size);
            int y = rnd.nextInt(size);
            board[x][y] = 9;
        }
    }

    protected void calculateNeighbours() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != 9) {
                    board[i][j] = howManyBombsinNeighbourhood(i, j);
                }
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

	public int getSize() {
		return size;
	}

    public String revealCell(int row, int col) {
        revealed[row][col] = true;

        int value = board[row][col];
        if (value == 9) return "💣";
        if (value == 0) return "";
        return String.valueOf(value);
    }

    public void addToHistory(int row, int col) {
        moves.add(new int[]{row, col});
        undos.clear();
    }

    public void toggleFlag(int row, int col) {
        flagged[row][col] = !flagged[row][col];
    }

    public boolean isFlagged(int row, int col) {
        return flagged[row][col];
    }

    public boolean isGameOver(int row, int col) {
        return isBomb(row, col);
    }

    public boolean isBomb(int row, int col) {
        return board[row][col] == 9;
    }

    public void undo() {
        if (moves.isEmpty())
            return;

        int[] move = moves.remove(moves.size() - 1);
        int row = move[0];
        int col = move[1];

        revealed[row][col] = false;  // Feld wieder verstecken

        undos.add(move);
    }

    public void redo() {
        if (undos.isEmpty())
            return;

        int[] move = undos.remove(undos.size() - 1);
        int row = move[0];
        int col = move[1];

        revealed[row][col] = true;

        moves.add(move);
    }

    public boolean isRevealed(int row, int col) {
        return revealed[row][col];
    }
    
    public String getCellContent(int row, int col) {
        int value = board[row][col];
        if (value == 9) return "💣";
        if (value == 0) return "";
        return String.valueOf(value);
    }
}

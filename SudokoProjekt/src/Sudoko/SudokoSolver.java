package Sudoko;

public class SudokoSolver {
	private int[][] sudokoMatris;

	public SudokoSolver() {
		sudokoMatris = new int[9][9];

	}// constructor

	public SudokoSolver(int[][] matris) {
		sudokoMatris = matris;
	}// också constructor

	public void put(int value, int x, int y) {
		this.sudokoMatris[x][y] = value;
	}// sätter in

	public int get(int index, int indey) {
		return this.sudokoMatris[index][indey];
	}// tar ut

	private boolean checkBigBox(int i, int j, int value) { // return true om det
															// finns plats för
															// value
		int ii = (i / 3) * 3; // Högst upp i hörnet på varje bigbox
		int jj = (j / 3) * 3;
		for (int k = ii; k < ii + 3; k++) {
			for (int l = jj; l < jj + 3; l++) {
				if (value == get(k, l) && k != i && l != j) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkColumn(int a, int b, int value) { // return true om det
															// finns plats för
															// value
		int row = 0;
		int col = a;
		while (row < 9) {
			if (row != b) {
				if (get(col, row) == value) {
					return false;
				}
			}
			row++;
		}
		return true;
	}

	private boolean checkRow(int a, int b, int value) { // return true om det
														// finns plats för value
		int col = 0;
		int row = b;
		while (col < 9) {
			if (col != a) {
				if (get(col, row) == value) {
					return false;
				}
			}
			col++;
		}
		return true;
	}

	private boolean isEmpty(int i, int j) {
		if (sudokoMatris[i][j] == 0) {
			return true;
		}
		return false;
	}

	private int[] nextCell(int a, int b) {
		if (a < 8 && b < 9) {
			a++;
		} else if (b < 8) {
			a = 0;
			b++;
		} else {
			return null;
		}
		int re[] = { a, b };
		return re;
	}

	public boolean solve() {
		if (solve(0, 0)) {
			System.out.println("Det fanns en lösning!");
			return true;
		} else {
			System.out.println("Det fanns INTE en lösning!");
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.println(sudokoMatris[i][j]);
				}
			}
			return false;
		}

		/*
		 * System.out.println("jaa"); System.out.println(sudokoMatris[0][2]);
		 * System.out.println(sudokoMatris[0][3]);
		 * System.out.println(sudokoMatris[8][8]);
		 */

	}

	private boolean solve(int i, int j) {
		if (isEmpty(i, j)) {
			for (int k = 1; k < 10; k++) {
				if (checkColumn(i, j, k) && checkRow(i, j, k) && checkBigBox(i, j, k)) {
					put(k, i, j);
					int[] next = nextCell(i, j);
					if (next == null) {
						return true;
					}
					if (solve(next[0], next[1])) {
						return true;
					}
				}
			}
			put(0, i, j);
			return false;
		}
		else {
			if (checkColumn(i, j, get(i, j)) && checkRow(i, j, get(i, j)) && checkBigBox(i, j, get(i, j))) {
				int[] next = nextCell(i, j);
				if (next == null) {
					return true;
				}
				if (solve(next[0], next[1])) {
					return true;
				}
				else{
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
}

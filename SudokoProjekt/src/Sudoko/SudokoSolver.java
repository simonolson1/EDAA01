package Sudoko;

public class SudokoSolver {
	private int[][] sudokoMatris;

	public SudokoSolver() {
		sudokoMatris = new int[9][9];

	}// constructor

	public void put(int value, int x, int y) {
		this.sudokoMatris[x][y] = value;
	}// sätter in

	public int get(int index, int indey) {
		return this.sudokoMatris[index][indey];
	}// tar ut

	public void Solve() {

	}

}

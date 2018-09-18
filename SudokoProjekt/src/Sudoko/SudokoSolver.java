package Sudoko;

public class SudokoSolver {
	private int[][] sudokoMatris;

	public SudokoSolver() {
		sudokoMatris = new int[9][9];
		
	}// constructor
	
	public SudokoSolver(int[][] matris){
		sudokoMatris = matris;
	}//också constructor

	public void put(int value, int x, int y) {
		this.sudokoMatris[x][y] = value;
	}// sätter in

	public int get(int index, int indey) {
		return this.sudokoMatris[index][indey];
	}// tar ut
	
	private boolean checkBigBox(int i, int j){
		int ii = i/3;
		int jj = j/3;
	}	
	
	
	public boolean solve() {
		solve(0,0);
		
		
		System.out.println("jaa");
		System.out.println(sudokoMatris[0][2]);
		System.out.println(sudokoMatris[0][3]);
		System.out.println(sudokoMatris[8][8]);
		return true;
	}
	private boolean solve(int i, int j){
		
	}

}

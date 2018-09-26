package Sudoko;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokoSolverTest {

	/*
	 * @Before public void setUp() { SudokoSolver s = new SudokoSolver(); }
	 */

	@Test
	public void testPut() {
		SudokoSolver s = new SudokoSolver();
		s.put(5, 1, 1);
		if (s.get(1, 1) != 5) {
			fail("inte 5 i 1,1");
		}
	}

	@Test
	public void testSolveExample() {
		SudokoSolver tm = new SudokoSolver();
		tm.put(8, 0, 2);
		tm.put(9, 0, 5);
		tm.put(6, 0, 7);
		tm.put(2, 0, 8);
		tm.put(5, 1, 8);
		tm.put(1, 2, 0);
		tm.put(2, 2, 2);
		tm.put(5, 2, 3);
		tm.put(2, 3, 3);
		tm.put(1, 3, 4);
		tm.put(9, 3, 7);
		tm.put(5, 4, 1);
		tm.put(6, 4, 6);
		tm.put(6, 5, 0);
		tm.put(2, 5, 7);
		tm.put(8, 5, 8);
		tm.put(4, 6, 0);
		tm.put(1, 6, 1);
		tm.put(6, 6, 3);
		tm.put(8, 6, 5);
		tm.put(8, 7, 0);
		tm.put(6, 7, 1);
		tm.put(3, 7, 4);
		tm.put(1, 7, 6);
		tm.put(4, 8, 6);

		boolean test = tm.solve();
		if (!test) {
			fail("False");
		}
	}

	@Test
	public void testSolveEmpty() {
		SudokoSolver tm = new SudokoSolver();
		boolean test = tm.solve();
		if (!test) {
			fail("False");
		}
	}

	@Test
	public void testSolveRow() {
		SudokoSolver tm = new SudokoSolver();
		tm.put(1, 0, 0);
		tm.put(1, 0, 3);
		boolean test = tm.solve();
		if (test) {
			fail("False");
		}
	}

	@Test
	public void testSolveCol() {
		SudokoSolver tm = new SudokoSolver();
		tm.put(1, 0, 0);
		tm.put(1, 3, 0);
		boolean test = tm.solve();
		if (test) {
			fail("False");
		}
	}

	@Test
	public void testSolveBox() {
		SudokoSolver tm = new SudokoSolver();
		tm.put(1, 0, 0);
		tm.put(1, 1, 1);
		boolean test = tm.solve();
		if (test) {
			fail("False");
		}
	}
	@Test
	public void testSolveSlow(){
		SudokoSolver tm = new SudokoSolver();
		tm.put(1, 8, 8);
		tm.put(1, 8, 6);
		boolean test = tm.solve();
		if(test){
			fail("False");
		}
}
}

package Sudoko;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokoSolverTest {

	/*@Before
	public void setUp() {
		SudokoSolver s = new SudokoSolver();
	}*/

	@Test
	public void testPut() {
		SudokoSolver s = new SudokoSolver();
		s.put(5, 1, 1);
		if (s.get(1, 1) != 5) {
			fail("inte 5 i 1,1");
		}
	}

}

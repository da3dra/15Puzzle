import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class PuzzleTests {

    private Puzzle mockPuzzle;

    // tests if array is shuffled after randomize() method has been called
    @Test
    public void testRandomization() {
        mockPuzzle = new Puzzle(4);
        int[][] puzzleArr = mockPuzzle.getPuzzleMatrix();
        int size = mockPuzzle.getSize();
        int[][] initialArray = new int[size][size];
        for(int i=0; i<size; i++)
            System.arraycopy(puzzleArr[i], 0, initialArray[i], 0, size);
        mockPuzzle.randomize();
        assertThat(initialArray, not(equalTo(mockPuzzle.getPuzzleMatrix())));
    }

    // tests if isSolved flag is true after performing the last move in correct direction
    @Test
    public void testIfSolved()  {
        mockPuzzle = new Puzzle(4);
        int [][] testArr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
        mockPuzzle.setZeroColumn(2);
        mockPuzzle.setZeroRow(3);
        mockPuzzle.setPuzzleMatrix(testArr);
        mockPuzzle.moveRight();
        assertTrue(mockPuzzle.isSolved());
    }
}

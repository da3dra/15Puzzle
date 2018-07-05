import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PuzzleTests {

    Puzzle mockPuzzle = new Puzzle(4);

    // tests if array is shuffled after randomize() method has been called
    @Test
    public void testRandomizer(){
        int[][] puzzleArr = mockPuzzle.getPuzzleArray();
        int size = mockPuzzle.getSize();
        int[][] initialArray = new int[size][size];
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                initialArray[i][j]=puzzleArr[i][j];
        mockPuzzle.randomize();
        assertThat(initialArray, not(equalTo(mockPuzzle.getPuzzleArray())));
    }

    // I know that goal array and puzzle array should be read-only
    // TODO how to perform such test without violating encapsulation?
    @Test
    public void testIfSolved(){
        int [][] testArr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
        mockPuzzle.setZeroColumn(2);
        mockPuzzle.setZeroRow(3);
        mockPuzzle.setPuzzleArray(testArr);
        mockPuzzle.moveRight();
        assertEquals(true,mockPuzzle.isSolved());
    }
}

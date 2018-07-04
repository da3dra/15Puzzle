import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
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

}

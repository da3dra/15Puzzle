import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

// I used Reflection to avoid making private fields and randomize() method visible

public class PuzzleTests {

    Puzzle mockPuzzle;

    // tests if array is shuffled after randomize() method has been called
    @Test
    public void testRandomization() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        mockPuzzle = new Puzzle(4);
        Method randomizeMethod = Puzzle.class.getDeclaredMethod("randomize");
        randomizeMethod.setAccessible(true);
        int[][] puzzleArr = mockPuzzle.getPuzzleMatrix();
        int size = mockPuzzle.getSize();
        int[][] initialArray = new int[size][size];
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                initialArray[i][j]=puzzleArr[i][j];
        randomizeMethod.invoke(mockPuzzle);
        assertThat(initialArray, not(equalTo(mockPuzzle.getPuzzleMatrix())));
    }

    // tests if isSolved flag is true after performing the last move in correct direction
    @Test
    public void testIfSolved() throws NoSuchFieldException, IllegalAccessException {
        mockPuzzle = new Puzzle(4);
        int [][] testArr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
        Field zeroCol = Puzzle.class.getDeclaredField("zeroColumn");
        zeroCol.setAccessible(true);
        zeroCol.set(mockPuzzle, 2);
        Field zeroRow = Puzzle.class.getDeclaredField("zeroRow");
        zeroRow.setAccessible(true);
        zeroRow.set(mockPuzzle, 3);
        Field puzzleMatrix = Puzzle.class.getDeclaredField("puzzleMatrix");
        puzzleMatrix.setAccessible(true);
        puzzleMatrix.set(mockPuzzle, testArr);
        mockPuzzle.moveRight();
        assertEquals(true,mockPuzzle.isSolved());
    }
}

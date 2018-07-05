import java.util.Arrays;
import java.util.Random;

public class Puzzle {

    private int size;
    private int[][] puzzleArray;
    private static int[][] goalState;
    private int zeroColumn;
    private int zeroRow;
    private boolean isSolved;

    public Puzzle(int size) {
        this.size = size;
        puzzleArray = new int[size][size];
        populate();
        randomize();
    }

    // TODO может лучше передать size как аргумент?
    public void populate() {
        puzzleArray = new int[size][size];
        goalState = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                puzzleArray[i][j] = (i * size) + j + 1;
                goalState[i][j] = (i * size) + j + 1;
            }
        }
        puzzleArray[size - 1][size - 1] = 0;
        goalState[size - 1][size - 1] = 0;
        setZeroRow(size - 1);
        setZeroColumn(size - 1);
        isSolved = true;
    }

    // this method guarantees that puzzle is solvable by shuffling already solved puzzle according to the game rules
    public void randomize() {
        Random random = new Random();
        for (int i = 0; i < size * 100; i++) {
            switch (random.nextInt(4)) {
                case (0):
                    if (moveLeft()) {
                    } else {
                        i--;
                    }
                    break;
                case (1):
                    if (moveRight()) {
                    } else {
                        i--;
                    }
                    break;
                case (2):
                    if (moveUp()) {
                    } else {
                        i--;
                    }
                    break;
                case (3):
                    if (moveDown()) {
                    } else {
                        i--;
                    }
                    break;
            }
        }
        if (Arrays.equals(puzzleArray, goalState))
            randomize();
        else isSolved = false;
    }

    public boolean moveLeft() {
        if (getZeroColumn() <= 0)
            return false;
        int temp = puzzleArray[zeroRow][zeroColumn - 1];
        puzzleArray[zeroRow][zeroColumn - 1] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroColumn(getZeroColumn() - 1);
        checkIfSolved();
        return true;
    }


    public boolean moveRight() {
        if (getZeroColumn() >= getSize() - 1)
            return false;
        int temp = puzzleArray[zeroRow][zeroColumn + 1];
        puzzleArray[zeroRow][zeroColumn + 1] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroColumn(getZeroColumn() + 1);
        checkIfSolved();
        return true;
    }

    public boolean moveUp() {
        if (getZeroRow() <= 0)
            return false;
        int temp = puzzleArray[zeroRow - 1][zeroColumn];
        puzzleArray[zeroRow - 1][zeroColumn] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroRow(getZeroRow() - 1);
        checkIfSolved();
        return true;
    }

    public boolean moveDown() {
        if (getZeroRow() >= getSize() - 1)
            return false;
        int temp = puzzleArray[zeroRow + 1][zeroColumn];
        puzzleArray[zeroRow + 1][zeroColumn] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroRow(getZeroRow() + 1);
        checkIfSolved();
        return true;
    }

    private boolean checkIfSolved() {
        if (Arrays.deepEquals(puzzleArray, goalState)) {
            isSolved = true;
            return true;
        } else return false;
    }

    public int getZeroColumn() {
        return zeroColumn;
    }

    public int getZeroRow() {
        return zeroRow;
    }

    public int getSize() {
        return size;
    }

    public int[][] getPuzzleArray() {
        return puzzleArray;
    }

    public boolean isSolved() {
        return isSolved;
    }

     void setZeroColumn(int zeroColumn) {
        this.zeroColumn = zeroColumn;
    }

     void setZeroRow(int zeroRow) {
        this.zeroRow = zeroRow;
    }

     void setPuzzleArray(int[][] puzzleArray) {
        this.puzzleArray = puzzleArray;
    }

     static void setGoalState(int[][] goalState) {
        Puzzle.goalState = goalState;
    }
}
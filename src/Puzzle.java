import java.util.Arrays;
import java.util.Random;

class Puzzle {

    private int size;
    private int[][] puzzleMatrix; // randomized matrix to be solved
    private static int[][] goalMatrix; //  state we want to achieve
    private int zeroColumn; // column position of zero
    private int zeroRow;  // row position of zero
    private boolean isSolved; // indicates if we reached goalState

    Puzzle(int size) {
        this.size = size;
        puzzleMatrix = new int[size][size];
        populate();
        randomize();
    }

    // fills the matrix in correct order
    void populate() {
        puzzleMatrix = new int[size][size];
        goalMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                puzzleMatrix[i][j] = (i * size) + j + 1;
                goalMatrix[i][j] = (i * size) + j + 1;
            }
        }
        puzzleMatrix[size - 1][size - 1] = 0;
        goalMatrix[size - 1][size - 1] = 0;
        setZeroRow(size - 1);
        setZeroColumn(size - 1);
        isSolved = true;
    }

    // this method guarantees that puzzle is solvable by shuffling already solved puzzle according to the game rules
    void randomize() {
        Random random = new Random();
        int rand;
        for (int i = 0; i < size * 100; i++){
            rand = random.nextInt(4);
            if(rand==0){
                i = moveLeft() ? i : i-1;
            }
            else if(rand==1){
                i = moveRight() ? i : i-1;
            }
            else if(rand==2){
                i = moveUp() ? i : i-1;
            }
            else{
                i = moveDown() ? i : i-1;
            }
        }
        isSolved = false;
    }

    private void swapTiles(int i, int j, int k, int l){
        puzzleMatrix[i][j] = puzzleMatrix[k][l];
        puzzleMatrix[k][l] = 0;
    }

    boolean moveLeft() {
        if (getZeroColumn() <= 0)
            return false;
        swapTiles(zeroRow,zeroColumn,zeroRow,zeroColumn-1);
        setZeroColumn(getZeroColumn() - 1);
        checkIfSolved();
        return true;
    }


    boolean moveRight() {
        if (getZeroColumn() >= getSize() - 1)
            return false;
        swapTiles(zeroRow,zeroColumn,zeroRow,zeroColumn+1);
        setZeroColumn(getZeroColumn() + 1);
        checkIfSolved();
        return true;
    }

    boolean moveUp() {
        if (getZeroRow() <= 0)
            return false;
        swapTiles(zeroRow,zeroColumn,zeroRow-1,zeroColumn);
        setZeroRow(getZeroRow() - 1);
        checkIfSolved();
        return true;
    }

    boolean moveDown() {
        if (getZeroRow() >= getSize() - 1)
            return false;
        swapTiles(zeroRow,zeroColumn,zeroRow+1,zeroColumn);
        setZeroRow(getZeroRow() + 1);
        checkIfSolved();
        return true;
    }

    private boolean checkIfSolved() {
        if (Arrays.deepEquals(puzzleMatrix, goalMatrix)) {
            isSolved = true;
            return true;
        } else return false;
    }

    int getZeroColumn() {
        return zeroColumn;
    }

    int getZeroRow() {
        return zeroRow;
    }

    int getSize() {
        return size;
    }

    int[][] getPuzzleMatrix() {
        return puzzleMatrix;
    }

    boolean isSolved() {
        return isSolved;
    }

    void setZeroColumn(int zeroColumn) {
        this.zeroColumn = zeroColumn;
    }

    void setZeroRow(int zeroRow) {
        this.zeroRow = zeroRow;
    }

    void setPuzzleMatrix(int[][] puzzleMatrix) {
        this.puzzleMatrix = puzzleMatrix;
    }
}
import java.util.Random;

public class Puzzle{

    private int size;
    private int[][] puzzleArray;
    private static int[][] goalState;
    private int zeroColumn;
    private int zeroRow;
    private boolean isGoalState;

    public Puzzle(int size) {
        this.size = size;
        puzzleArray = new int[size][size];
        populate();
        randomize();
    }

    // может лучше передать size как аргумент?
    public void populate() {
        puzzleArray = new int[size][size];
        goalState = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                puzzleArray[i][j] = (i * size) + j;
                goalState[i][j] = (i * size) + j;
            }
        }
        setZeroRow(0);
        setZeroColumn(0);
        isGoalState = true;
    }

    // я думаю над тем чтобы вместо этого сделать адаптер
    public void checkCommand(String s) {
        switch (s) {
            case "a":
               moveLeft();
                break;
            case "d":
                moveRight();
                break;
            case "w":
                moveUp();
                break;
            case "s":
                moveDown();
                break;
        }
    }

    public void randomize(){
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
                    if(moveDown()){
                    } else {
                        i--;
                    }
                    break;
            }
        }
    }

    // как переписать эти методы чтобы не было повторяющегося кода
    public boolean moveLeft(){
        if (getZeroColumn() <= 0)
            return false;
        int temp = puzzleArray[zeroRow][zeroColumn - 1];
        puzzleArray[zeroRow][zeroColumn - 1] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroColumn(getZeroColumn() - 1);
        return true;
    }


    public boolean moveRight(){
        if (getZeroColumn() >= getSize() - 1)
            return false;
        int temp = puzzleArray[zeroRow][zeroColumn + 1];
        puzzleArray[zeroRow][zeroColumn + 1] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroColumn(getZeroColumn() + 1);
        return true;
    }

    public boolean moveUp(){
        if (getZeroRow() <= 0)
            return false;
        int temp = puzzleArray[zeroRow - 1][zeroColumn];
        puzzleArray[zeroRow - 1][zeroColumn] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroRow(getZeroRow() - 1);
        return true;
    }

    public boolean moveDown(){
        if(getZeroRow() >= getSize() - 1)
            return false;
        int temp = puzzleArray[zeroRow + 1][zeroColumn];
        puzzleArray[zeroRow + 1][zeroColumn] = 0;
        puzzleArray[zeroRow][zeroColumn] = temp;
        setZeroRow(getZeroRow() + 1);
        return true;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPuzzleArray(int[][] puzzleArray) {
        this.puzzleArray = puzzleArray;
    }

    public static int[][] getGoalState() {
        return goalState;
    }

    public static void setGoalState(int[][] goalState) {
        Puzzle.goalState = goalState;
    }

    public int getZeroColumn() {
        return zeroColumn;
    }

    public void setZeroColumn(int zeroColumn) {
        this.zeroColumn = zeroColumn;
    }

    public int getZeroRow() {
        return zeroRow;
    }

    public void setZeroRow(int zeroRow) {
        this.zeroRow = zeroRow;
    }

    public boolean isGoalState() {
        return isGoalState;
    }

    public void setGoalState(boolean goalState) {
        isGoalState = goalState;
    }
    public int getSize() {
        return size;
    }

    public int[][] getPuzzleArray() {
        return puzzleArray;
    }

}

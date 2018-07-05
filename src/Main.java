import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("Welcome to the 15 Puzzle game!");
        boolean isRunning = true;

        // TODO at this point size is hadcoded here, but it can be easily set from input
        Puzzle puzzle = new Puzzle(4);
        ConsoleView screen = new ConsoleView(puzzle);
        System.err.println("You will need to move zero cell with W A S D control keys");
        screen.renderPuzzle();

        while (isRunning) {
            movePuzzle(scanner.nextLine(),puzzle);
            screen.renderPuzzle();
            if(puzzle.isSolved()){
                isRunning = false;
                System.out.println("Congratulations! You won the game! :)");
            }
        }

    }

    public static void movePuzzle(String command, Puzzle puzzle) {
        switch (command) {
            case "a":
                puzzle.moveLeft();
                break;
            case "d":
                puzzle.moveRight();
                break;
            case "w":
                puzzle.moveUp();
                break;
            case "s":
                puzzle.moveDown();
                break;
        }
    }
}
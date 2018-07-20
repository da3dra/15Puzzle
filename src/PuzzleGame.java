import java.util.Scanner;

class PuzzleGame {
    private Puzzle puzzle;
    private View view;
    private Controller controller;
    private boolean isRunning = true;
    private boolean moved;

    PuzzleGame(Puzzle puzzle, View view, Controller controller) {
        this.puzzle = puzzle;
        this.view = view;
        this.controller = controller;
    }

    void run(Scanner scanner) {
        System.out.println("You will need to move zero cell with W A S D control keys.");
        view.printPuzzle();
        while (isRunning) {
            moved = controller.movePuzzle(scanner.nextLine());
            if(!moved){
                System.out.println("Invalid command! Please use W A S D keys.");
            }
            view.printPuzzle();
            if(puzzle.isSolved()){
                isRunning = false;
                System.out.println("Congratulations! You won the game! :)");
            }
        }
    }
}

import java.util.Scanner;

class ConsoleGame {
    private Puzzle puzzle;
    private View view;
    private Controller controller;
    private Scanner scanner;
    private boolean isRunning = true;
    private boolean moved;

    public ConsoleGame() {
    }

    public void run() {
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

    public void welcome(){
        System.out.println("Welcome to 15 Puzzle game!");
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getPuzzleDimension() {

        String input = "";

        while(!input.matches("[2-6]")){
            System.out.println("Please enter the whole number from 2 to 6 to set the shape of puzzle array.");
            input = scanner.nextLine();
        }

        return Integer.parseInt(input);
    }
}

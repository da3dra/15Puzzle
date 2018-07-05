import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the 15 Puzzle game!");
        String input = "";

        while(!input.matches("[2-6]")){
            System.out.println("Please enter the whole number from 2 to 6 to set the shape of puzzle array.");
            input = scanner.nextLine();
        }

        int size = Integer.parseInt(input);
        Puzzle puzzle = new Puzzle(size);
        ConsoleView screen = new ConsoleView(puzzle);
        ConsoleController controller = new ConsoleController(puzzle);
        System.out.println("You will need to move zero cell with W A S D control keys.");
        screen.printPuzzle();

        boolean isRunning = true;
        while (isRunning) {
            boolean moved = controller.movePuzzle(scanner.nextLine());
            if(!moved){
                System.out.println("Invalid command! Please use W A S D keys.");
            }
            screen.printPuzzle();
            if(puzzle.isSolved()){
                isRunning = false;
                System.out.println("Congratulations! You won the game! :)");
            }
        }

    }

}
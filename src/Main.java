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
        PuzzleGame game = new PuzzleGame(puzzle, screen, controller);

        game.run(scanner);

    }

}
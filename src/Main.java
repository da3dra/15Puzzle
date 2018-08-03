import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsoleGame game = new ConsoleGame();
        Scanner scanner = new Scanner(System.in);
        game.setScanner(scanner);

        game.welcome();

        int size = game.getPuzzleDimension();
        Puzzle puzzle = new Puzzle(size);
        game.setPuzzle(puzzle);
        View screen = new ConsoleView(puzzle);
        Controller controller = new ConsoleController(puzzle);
        game.setController(controller);
        game.setView(screen);

        game.run();

    }

}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try  {

            int size = scanner.nextInt();

            // add case for handling other stuff than integers
            if (size < 2 )  {
                throw new UnsupportedOperationException();
            }

            boolean isRunning = true;
            Puzzle puzzle = new Puzzle(size);
            ConsoleView screen = new ConsoleView(puzzle);

            while (isRunning) {
               puzzle.checkCommand(scanner.nextLine());
               screen.renderPuzzle();
            }

        } catch (UnsupportedOperationException uoe) {
            System.err.println("Arguments were entered incorrectly. Try entering args again.");
            scanner.next();
        }


    }

}
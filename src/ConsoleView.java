public class ConsoleView implements Display {

    private Puzzle puzzle;

    ConsoleView(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void renderPuzzle() {
        for (int i = 0; i < puzzle.getSize(); i++) {
            for (int j = 0; j < puzzle.getSize(); j++) {
                System.out.printf("%3d", puzzle.getPuzzleArray()[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}


class ConsoleController {

    private Puzzle puzzle;

    public ConsoleController(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    boolean movePuzzle(String command) {
        if(command.equalsIgnoreCase("w")){
            puzzle.moveUp();
        }else if(command.equalsIgnoreCase("s")){
            puzzle.moveDown();
        }else if(command.equalsIgnoreCase("d")){
            puzzle.moveRight();
        }else if(command.equalsIgnoreCase("a")){
            puzzle.moveLeft();
        }else {
            return false;
        }
        return true;
    }
}

package moa;

public abstract class Node {

    private final Board board;

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract int getLevel();

    public Integer getPeso(IHeuristic heuristic) {
        return heuristic.getHeuristic(this.board) + this.getLevel();
    }

}

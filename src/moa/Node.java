package moa;

public abstract class Node {

    private Board board;

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract int getResultado();

}

package moa;

public class Branch extends Node {
    private Node parent;

    public Branch(Board board, Node parent) {
        super(board);
        this.parent = parent;
    }
    
    
}

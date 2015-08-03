package moa;

public class Branch extends Node {

    private final int level;

    public Branch(Board board, Node parent) {
        super(board);
        this.level = parent.getLevel() + 1;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

}

package moa;

public class Root extends Node {

    public Root(Board board) {
        super(board);
    }

    @Override
    public int getLevel() {
        return 0;
    }

}

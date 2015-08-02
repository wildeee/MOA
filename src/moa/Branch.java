package moa;

import java.util.Comparator;

public class Branch extends Node implements Comparator<Node> {

    private Node parent;

    public Branch(Board board, Node parent) {
        super(board);
        this.parent = parent;
    }

    @Override
    public int getResultado() {
        return parent.getResultado() + 1;
    }

    @Override
    public int compare(Node o1, Node o2) {
        if (o2.getEstimatedRolls() > o1.getEstimatedRolls()) {
            return -1;
        } else if (o1.getEstimatedRolls() > o2.getEstimatedRolls()) {
            return 1;
        } else {
            return 0;
        }
    }

}

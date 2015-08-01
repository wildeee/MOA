package moa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeController {

    private final List<Node> nodeQueue;
    private final Map<String, Board> inativos;

    public TreeController(Root root) {
        nodeQueue = new ArrayList<>();
        nodeQueue.add(root);
        inativos = new HashMap<>();
        inativos.put(root.getBoard().getHash(), root.getBoard());

    }
    //Magic begins here!
    public int calculateMinPlays() {
        Node nodeIterator;
        while (!nodeQueue.isEmpty()) {
            nodeIterator = nodeQueue.remove(0);
            System.out.println(nodeIterator.getResultado());
            if (nodeIterator.getBoard().checkWin()) {
                return nodeIterator.getResultado();
            }

            for (EMovementType move : EMovementType.values()) {
                try {
                    Board board = nodeIterator.getBoard().movePiece(move);
                    if (inativos.get(board.getHash()) == null) {
                        inativos.put(board.getHash(), board);
                        nodeQueue.add(new Branch(board, nodeIterator));
                    }
                } catch (InvalidMovementException ex) {
                }
            }
        }

        return -1;
    }
}

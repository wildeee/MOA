package moa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TreeController {

    private final PriorityQueue<Node> nodeQueue;
    private final Map<String, Integer> inativos;

    public TreeController(Root root) {
        nodeQueue = new PriorityQueue<>(new NodeComparator());
        nodeQueue.add(root);
        inativos = new HashMap<>();

    }

    //Magic begins here!
    public int calculateMinPlays() {
        Node nodeIterator;
        while (!nodeQueue.isEmpty()) {
            nodeIterator = nodeQueue.remove();
            if (nodeIterator.getBoard().checkWin()) {
                return nodeIterator.getLevel();
            }

            inativos.put(nodeIterator.getBoard().getHash(), nodeIterator.getPeso());

            for (int move : EMovementType.values()) {
                try {
                    Board board = nodeIterator.getBoard().movePiece(move);
                    if (inativos.containsKey(board.getHash())) { // Assegurando que não hajam tabuleiros repetidos na árvore
                        if (nodeIterator.getPeso() >= inativos.get(board.getHash())) {
                            continue;
                        }
                    }
                    nodeQueue.add(new Branch(board, nodeIterator));
                } catch (InvalidMovementException ex) {
                }
            }
        }

        return -1;
    }
}

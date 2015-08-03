package moa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeController {

    private final PriorityQueue nodeQueue;
    private final Map<String, Board> inativos;

    public TreeController(Root root) {
        nodeQueue = new PriorityQueue(root);
        inativos = new HashMap<>();
        inativos.put(root.getBoard().getHash(), root.getBoard());

    }

    //Magic begins here!
    public int calculateMinPlays() {
        Node nodeIterator;
        List<Branch> addingNodes = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            nodeIterator = nodeQueue.remove();
            System.out.println(nodeIterator.getLevel());
            if (nodeIterator.getBoard().checkWin()) {
                return nodeIterator.getLevel();
            }

            addingNodes.clear();
            for (EMovementType move : EMovementType.values()) {
                try {
                    Board board = nodeIterator.getBoard().movePiece(move);
                    if (inativos.get(board.getHash()) == null) { // Assegurando que não hajam tabuleiros repetidos na árvore
                        inativos.put(board.getHash(), board);
                        addingNodes.add(new Branch(board, nodeIterator));
                    }
                } catch (InvalidMovementException ex) {
                }
            }
            nodeQueue.add(addingNodes);
        }

        return -1;
    }
}

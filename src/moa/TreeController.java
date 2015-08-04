package moa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
        List<Branch> addingNodes = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            nodeIterator = nodeQueue.remove();
            System.out.println(nodeIterator.getLevel());
            if (nodeIterator.getBoard().checkWin()) {
                return nodeIterator.getLevel();
            }
            
            inativos.put(nodeIterator.getBoard().getHash(), nodeIterator.getPeso());
            
            addingNodes.clear();
            for (EMovementType move : EMovementType.values()) {
                try {
                    Board board = nodeIterator.getBoard().movePiece(move);
                    if (inativos.containsKey(board.getHash())) { // Assegurando que não hajam tabuleiros repetidos na árvore
                        if(nodeIterator.getPeso() >= inativos.get(board.getHash())){
                            continue;
                        }
                    }
                    addingNodes.add(new Branch(board, nodeIterator));
                } catch (InvalidMovementException ex) {
                }
            }
            for (Node nude : addingNodes){
                nodeQueue.add(nude);
            }
        }

        return -1;
    }
}

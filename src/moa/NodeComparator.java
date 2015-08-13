package moa;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getPeso(Config.Heuristica), o2.getPeso(Config.Heuristica));
    }

}

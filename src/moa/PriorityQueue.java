package moa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {

    private List<Node> queue;

    public PriorityQueue(Root beginner) {
        this.queue = new LinkedList<>();
        this.queue.add(beginner);
    }

    public void add(List<Branch> node) {
        if (!node.isEmpty()) {

            Node[] n = new Node[node.size()];
            n = node.toArray(n);
            Branch anyNode = node.get(0);
            Arrays.sort(n, anyNode);
            for (Node nodeit : n) {
                queue.add(nodeit);
            }

//        this.queue.add(node);
//        Node[] n = new Node[queue.size()];
//        n = this.queue.toArray(n);
//        Arrays.sort(n, node);
//        this.queue = new LinkedList<>(Arrays.asList(n));
        }
    }

    public Node remove() {
        return this.queue.remove(0);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

}

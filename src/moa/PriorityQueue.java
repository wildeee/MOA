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
            for (Node nodeIt : node) {
                queue.add(nodeIt);
            }
            this.queue = this.sort(this.queue);

//            Node[] n = new Node[node.size()];
//            n = queue.toArray(n);
//            Arrays.sort(n, node.get(0));
//            this.queue = new LinkedList<>(Arrays.asList(n));
        }

//        this.queue.add(node);
//        Node[] n = new Node[queue.size()];
//        n = this.queue.toArray(n);
//        Arrays.sort(n, node);
//        this.queue = new LinkedList<>(Arrays.asList(n));
    }

    public Node remove() {
        return this.queue.remove(0);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    private List<Node> sort(List<Node> notSorted) {
        Node[] n = new Node[notSorted.size()];
        n = notSorted.toArray(n);
        Arrays.sort(n, notSorted.get(0));
        return new LinkedList<>(Arrays.asList(n));
    }

}

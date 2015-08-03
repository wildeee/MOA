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
        }
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

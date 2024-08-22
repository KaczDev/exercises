package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.*;

public class LC_133 implements Solution {
    @Override
    public void solve() {
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        System.out.println("Old graph mem addr: "+n1);
        System.out.println("Solution: " + this.cloneGraph(n1));

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }
        Map<Node, Node> oldNewMapping = new HashMap<>();
        return clone(node, oldNewMapping);
    }

    private Node clone(Node node, Map<Node, Node> oldNewMapping) {
        if (node == null) {
            return null;
        }
        if (oldNewMapping.containsKey(node)) {
            return oldNewMapping.get(node);
        }
        Node n = new Node(node.val);
        oldNewMapping.put(node, n);
        for (Node neighbor : node.neighbors) {
            Node clonedN = this.clone(neighbor, oldNewMapping);
            n.neighbors.add(clonedN);
        }
        return n;
    }
}

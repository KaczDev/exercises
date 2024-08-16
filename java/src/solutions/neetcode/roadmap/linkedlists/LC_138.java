package solutions.neetcode.roadmap.linkedlists;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC_138 implements Solution {
    @Override
    public void solve() {
        Node n = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n.random = null;
        n2.random = n;
        n3.random = n5;
        n4.random = n3;
        n5.random = n;
        System.out.println("Solution: " + this.copyRandomList(n));
        System.out.println("Solution: " + this.copyRandomListNeetCode(n));
    }

    //Time: O(n)
    //Space: O(n)
    private Node copyRandomListNeetCode(Node head) {
        Node oldHead = head;
        //Two Passes
        Map<Node, Node> oldNewMapping = new HashMap<>();
        //First pass is just going to create the deep copies
        // and create a hashmap where we map
        // the original nodes to the new nodes
        while (oldHead != null) {
            oldNewMapping.put(oldHead, new Node(oldHead.val));
            oldHead = oldHead.next;
        }
        //Second pass is where we do node connecting
        Node dummy = new Node(1);
        Node tail = dummy;
        while (head != null) {
            tail.next = oldNewMapping.get(head);
            tail = tail.next;
            tail.random = oldNewMapping.get(head.random);
            head = head.next;
        }
        return dummy.next;
    }

    //Time: O(2n) = O(n)
    //Space: O(2n) = O(n) //Do we count the new list as extra space? Because the new list is the second N
    private Node copyRandomList(Node head) {
        Node tmp = head;
        int i = 0;
        Map<Node, Integer> oldList = new HashMap<>();
        while (tmp != null) {
            oldList.put(tmp, i);
            tmp = tmp.next;
            i += 1;
        }
        // Dummy is ahead of our list
        Node dummy = new Node(-1);
        Node tail = dummy;
        Map<Integer, Node> randomNodes = new HashMap<>();
        i = 0;
        while (head != null) {
            // check if i is in the map
            if (randomNodes.containsKey(i)) {
                // if it is pull it out of the map
                Node node = randomNodes.get(i);
                // update tail.next
                tail.next = node;
                // check random and link it
            } else {
                // create new node
                Node tmp2 = new Node(head.val);
                tail.next = tmp2;
                randomNodes.put(i, tmp2);
            }
            // move tail to the new node
            tail = tail.next;
            if (head.random == null) {
                tail.random = null;
            } else {
                // check index of corresponding random node.
                if (oldList.get(head.random) > i) {
                    // if it's higher than i
                    if (randomNodes.containsKey(oldList.get(head.random))) {
                        //if the node is already there (referred by the previous nodes)
                        //just pullit out from the list to not overwrite it!
                        tail.random = randomNodes.get(oldList.get(head.random));
                    } else {
                        // craete node and store in the map <i, node>
                        Node aheadNode = new Node(head.random.val);
                        randomNodes.put(oldList.get(head.random), aheadNode);
                        tail.random = aheadNode;
                    }
                } else {
                    // head.random refers to already created node
                    tail.random = randomNodes.get(oldList.get(head.random));
                }
            }
            // increment
            i += 1;
            head = head.next;
        }
        return dummy.next;
    }

}

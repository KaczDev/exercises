package solutions.neetcode.roadmap.linkedlists;

public class Node {
    int val;
    public Node next;
    public Node random;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        if (this.next != null) {
            if (this.random != null) {
                return String.format("(%d).next-> %s\n\t(%d).random -> (%d)", val, next, val, random.val);
            }
            return String.format("(%d).next-> %s\n\t(%d).random -> null", val, next, val);
        }
        if (this.random != null) {
            return String.format("(%d).next-> %s\n\t(%d).random -> (%d)", val, next, val, random.val);
        }
        return String.format("(%d).next-> %s\n\t(%d).random -> (%d)", val, next, val);
    }
}

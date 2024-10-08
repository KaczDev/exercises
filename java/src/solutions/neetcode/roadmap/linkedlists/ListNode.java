package solutions.neetcode.roadmap.linkedlists;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next != null) {
            return String.format("(%d) -> %s", val, next.toString());
        }
        return String.format("(%d)", val);
    }
}
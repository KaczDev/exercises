package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_590 implements Solution {
    @Override
    public void solve() {
        List<NTreeNode> children3 = List.of(new NTreeNode(5), new NTreeNode(6));
        List<NTreeNode> children1 = List.of(new NTreeNode(3, children3), new NTreeNode(2), new NTreeNode(4));
        NTreeNode n = new NTreeNode(1, children1);
        System.out.println("Solution: " + this.postorder(n));
    }

    private List<Integer> postorder(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        this.construct(root, res);
        return res;
    }

    private void construct(NTreeNode root, List<Integer> res) {
        if (root == null)
            return;
        for (NTreeNode c : root.children) {
            this.construct(c, res);
        }
        res.add(root.val);
    }
}

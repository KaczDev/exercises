package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_235 implements Solution {
    @Override
    public void solve() {

    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) { //We're guaranteed that there's a solution
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}

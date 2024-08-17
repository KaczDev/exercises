package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LC_572 implements Solution {
    @Override
    public void solve() {

    }
    private boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot==null) return true;
        if (root==null) return false;
        if (this.isSameTree(root,subRoot)){
            return true;
        }
        return this.isSubtree(root.left,subRoot) ||
                this.isSubtree(root.right,subRoot);
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
    }

}

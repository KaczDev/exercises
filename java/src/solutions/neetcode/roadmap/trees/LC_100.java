package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_100 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        TreeNode t2 = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        System.out.println("Solution: "+this.isSameTree(t,t2));
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q == null){
            return true;
        }
        if (p==null || q ==null){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

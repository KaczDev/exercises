package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_1448 implements Solution {
    @Override
    public void solve() {

        TreeNode t = new TreeNode(3,new TreeNode(3,new TreeNode(4),new TreeNode(2)),null);//3
        System.out.println("Solution: "+this.goodNodes(t));

    }
    private int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        return dfsPre(root,Integer.MIN_VALUE);
    }

    private int dfsPre(TreeNode root, int pathMaximum) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.val >= pathMaximum) {
            pathMaximum = root.val;
            count += 1;
        }
        count+=dfsPre(root.left, pathMaximum);
        count+=dfsPre(root.right, pathMaximum);
        return count;
    }
}

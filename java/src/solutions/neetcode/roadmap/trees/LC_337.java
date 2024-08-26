package solutions.neetcode.roadmap.trees;

import solutions.Solution;

public class LC_337 implements Solution {
    @Override
    public void solve() {
        TreeNode t =new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, new TreeNode(1), null));
        System.out.println("Solution: " + this.rob(t));
    }

    //Time: O(n)
    private int rob(TreeNode root) {
        int[] res = this.dfs(root);
        return Math.max(res[0], res[1]);
    }

    // post order
    // cases: [includeSelfButNoChildren, maxOfBothChildren]
    // cases: [withRoot, withoutRoot]
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = this.dfs(root.left);
        int[] right = this.dfs(root.right);
        int withRoot = root.val + left[1] + right[1];
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{withRoot, withoutRoot};

    }
}

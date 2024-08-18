package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.Arrays;

public class LC_105 implements Solution {
    @Override
    public void solve() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(("Solution: " + this.buildTree(preorder, inorder)));
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        while (inorder[mid] != preorder[0]) {
            mid += 1;
        }
        //We copy arrays here, we could also create a separate function where we pass start and end of arrays
        root.left = this.buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = this.buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }
}

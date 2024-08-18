package solutions.neetcode.roadmap.trees;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_297 implements Solution {
    @Override
    public void solve() {
        TreeNode t = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String ser = this.serialize(t);
        System.out.println("Serialized: " + ser);
        System.out.println("Deserialized: " + this.deserialize(ser));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return this.serDfs(root, sb).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return this.deserDfs(new Deser(data.split(","), 0));
    }

    class Deser {
        String[] data;
        int i;

        Deser(String[] data, int i) {
            this.data = data;
            this.i = i;
        }
    }

    ;

    private TreeNode deserDfs(Deser d) {
        if (d.data[d.i].equals("N")) {
            d.i += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(String.valueOf(d.data[d.i])));
        d.i += 1;
        node.left = this.deserDfs(d);
        node.right = this.deserDfs(d);
        return node;
    }

    // preorder
    private StringBuilder serDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            if (sb.isEmpty()) {
                sb.append(String.format("N"));
            } else {
                sb.append(String.format(",N"));
            }
            return sb;
        }
        if (sb.isEmpty()) {
            sb.append(String.format("%d", root.val));
        } else {
            sb.append(String.format(",%d", root.val));
        }
        this.serDfs(root.left, sb);
        this.serDfs(root.right, sb);
        return sb;
    }

}
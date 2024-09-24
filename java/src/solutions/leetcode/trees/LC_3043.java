package solutions.leetcode.trees;

import solutions.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC_3043 implements Solution {
    @Override
    public void solve() {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println("Solution: " + this.longestCommonPrefixHashSet(arr1, arr2));
        arr1 = new int[]{1, 2, 3};
        arr2 = new int[]{4, 4, 4};
        System.out.println("Solution: " + this.longestCommonPrefixHashSet(arr1, arr2));
    }

    //Time: O(m*log10 M+ n*log10 N)
    private int longestCommonPrefixHashSet(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            int[] t = arr1;
            arr1 = arr2;
            arr2 = t;
        }
        Set<Integer> prefixes = new HashSet<>();
        for (int n : arr1) {
            while (n > 0 && !prefixes.contains(n)) {
                prefixes.add(n);
                n = n / 10;
            }
        }
        int res = 0;
        for (int n : arr2) {
            while (n > 0 && !prefixes.contains(n)) {
                n = n / 10;
            }
            if (n != 0) {
                res = Math.max(res, String.valueOf(n).length());
            }
        }
        return res;
    }

//    class TrieNode {
//        int value;
//        Set<Integer> children;
//
//        TrieNode(int val) {
//            this.value = val;
//            this.children = new HashSet<>();
//        }
//    }
//
//    class Trie {
//        TrieNode root;
//
//        Trie(int[] arr) {
//            for (int n : arr) {
//
//            }
//        }
//    }
//
//    private int longestCommonPrefix(int[] arr1, int[] arr2) {
//
//    }
}

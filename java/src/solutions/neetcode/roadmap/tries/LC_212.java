package solutions.neetcode.roadmap.tries;

import solutions.Solution;

import java.util.*;

public class LC_212 implements Solution {
    @Override
    public void solve() {
        char[][] board = new char[][]{new char[]{'o', 'a', 'a', 'n'}, new char[]{'e', 't', 'a', 'e'}, new char[]{'i', 'h', 'k', 'r'}, new char[]{'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println("Solution: " + this.findWords(board, words));
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    record RowCols(int r, int c) {
    }

    private TrieNode root;
    private Set<RowCols> visit;
    private Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        this.visit = new HashSet<>();
        this.res = new HashSet<>();
        // Put all words into a Trie
        this.root = new TrieNode();
        for (String word : words) {
            this.addWord(word);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                this.dfs(board, root, new RowCols(row, col), "");

            }
        }
        return this.res.stream().toList();
    }

    private void addWord(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    private void dfs(char[][] board, TrieNode trie, RowCols rowCols, String wordSoFar) {
        if (rowCols.r < 0 || rowCols.c < 0 ||
                rowCols.r >= board.length ||
                rowCols.c >= board[0].length) {

            return;
        }
        if (this.visit.contains(rowCols)) {
            return;
        }
        if (!trie.children.containsKey(board[rowCols.r][rowCols.c])) {
            return;
        }
        this.visit.add(rowCols);
        trie = trie.children.get(board[rowCols.r][rowCols.c]);
        wordSoFar += board[rowCols.r][rowCols.c];
        if (trie.isWord) {
            this.res.add(wordSoFar);
        }
        this.dfs(board, trie, new RowCols(rowCols.r - 1, rowCols.c), wordSoFar);
        this.dfs(board, trie, new RowCols(rowCols.r + 1, rowCols.c), wordSoFar);
        this.dfs(board, trie, new RowCols(rowCols.r, rowCols.c - 1), wordSoFar);
        this.dfs(board, trie, new RowCols(rowCols.r, rowCols.c + 1), wordSoFar);
        this.visit.remove(rowCols);
    }
}

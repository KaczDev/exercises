package solutions.neetcode.roadmap.stacks;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class LC_20 implements Solution {
    @Override
    public void solve() {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "[";
        String s5 = "((";
        String s6 = "(])";


        System.out.println("Solution: " + this.isValidWithMap(s1));
        System.out.println("Solution: " + this.isValidWithMap(s2));
        System.out.println("Solution: " + this.isValidWithMap(s3));
        System.out.println("Solution: " + this.isValidWithMap(s4));
        System.out.println("Solution: " + this.isValidWithMap(s5));
        System.out.println("Solution: " + this.isValidWithMap(s6));
    }

    //Time: O(n)
    //Space: O(n)
    private boolean isValidWithMap(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> validator = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!validator.isEmpty()) {
                    if (validator.peek() == map.get(c)) {
                        validator.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                validator.push(c);
            }
        }
        return validator.isEmpty();
    }


    //    1. Push characters onto stack until middle.
//    2. when middle pop from the stack and check if (int) of the char - (int) of the popped char == 1 (EDIT: I thought that those characters are next to each other. THey aren't so it's better to use the map.)
//    3. if not => return false;
    private boolean isValid(String s) {
        Stack<Character> validator = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.isOpening(c)) {
                validator.push(c);
                continue;
            }
            if (validator.isEmpty()) {
                return false;
            }
            char opener = validator.pop();
            int target = switch (opener) {
                case '{', '[' -> 2;
                case '(' -> 1;
                default -> 0;
            };
            if ((int) c - (int) opener != target) {
                return false;
            }
        }
        return validator.isEmpty();
    }

    private boolean isOpening(char c) {
        return c == '[' || c == '{' || c == '(';
    }


}

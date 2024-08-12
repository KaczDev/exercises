package solutions.neetcode.roadmap.stacks;

import solutions.Solution;

import java.util.Set;
import java.util.Stack;

public class LC_150 implements Solution {
    @Override
    public void solve() {
        String[] tokens1 = new String[]{"2", "1", "+", "3", "*"};
        String[] tokens2 = new String[]{"4", "13", "5", "/", "+"};
        String[] tokens3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println("Solution: " + this.evalRPN(tokens1));
        System.out.println("Solution: " + this.evalRPN(tokens2));
        System.out.println("Solution: " + this.evalRPN(tokens3));
    }

    //Time: O(n)
    //Space: O(n)
    private int evalRPN(String[] tokens) {
        Set<String> operands = Set.of("+", "-", "/", "*");
        Stack<String> stack = new Stack<>();
        //    So I think. We go over the character.
        for (String token : tokens) {
            if (operands.contains(token)) {
                //    When we meet an operand.
                //    We pop twice and do the operation and put the result onto the stack
                //Remember that  we pop in reverse order so the first number in operation
                // is second
                int n = this.operation(stack.pop(), stack.pop(), token);
                stack.push(String.valueOf(n));
            } else {
                stack.push(token);
            }
        }
        //    After the whole loop `stacks.size()` should be 1
        //    The last item in the stack will be the result
        return Integer.parseInt(stack.pop());
    }

    private int operation(String s2, String s1, String operation) {
        int n2 = Integer.parseInt(s2);
        int n1 = Integer.parseInt(s1);
        return switch (operation) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new RuntimeException("Invalid string");
        };

    }
}

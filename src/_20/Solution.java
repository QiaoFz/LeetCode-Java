package _20;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        } else if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        char c;
        char popC;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (!stack.empty()) {
                popC = stack.peek();
                switch (c) {
                    case ')' :
                        if (popC == '(') {
                            stack.pop();
                            continue;
                        }
                        break;
                    case ']' :
                        if (popC == '[') {
                            stack.pop();
                            continue;
                        }
                        break;
                    case '}' :
                        if (popC == '{') {
                            stack.pop();
                            continue;
                        }
                        break;
                    default:
                }
            }
            stack.push(c);
        }

        return stack.empty();
    }
}

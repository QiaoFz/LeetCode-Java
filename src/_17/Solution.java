package _17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {

    public static char[] two = {'a', 'b', 'c'};
    public static char[] three = {'d', 'e', 'f'};
    public static char[] four = {'g', 'h', 'i'};
    public static char[] five = {'j', 'k', 'l'};
    public static char[] six = {'m', 'n', 'o'};
    public static char[] seven = {'p', 'q', 'r', 's'};
    public static char[] eight = {'t', 'u', 'v'};
    public static char[] nine = {'w', 'x', 'y', 'z'};

    private static char[] getRelateCharList(char c) {
        switch (c) {
            case '2':
                return two;
            case '3':
                return three;
            case '4':
                return four;
            case '5':
                return five;
            case '6':
                return six;
            case '7':
                return seven;
            case '8':
                return eight;
            case '9':
                return nine;
            default:
                return null;
        }
    }

    // 用一个先进先出队列，每次操作一个字符，都将之前的删掉重进
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList();
        }
        int len = digits.length();
        char[] cl;
        LinkedList<String> sl = new LinkedList<>();
        sl.add("");
        while (sl.peek().length() != len) {
            String remove = sl.remove();
            cl = getRelateCharList(digits.charAt(remove.length()));
            for (int i = 0; i < cl.length; i++) {
                sl.add(remove + cl[i]);
            }
        }
        return sl;
    }
}

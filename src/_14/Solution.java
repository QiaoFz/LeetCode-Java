package _14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {

        int arrLen = strs.length;
        if (arrLen == 0) {
            return "";
        }
        if (arrLen == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        int len = strs[0].length();
        for (int i = 1, j; i < arrLen; i++) {
            len = Math.min(len, strs[i].length());
            if (len == 0) {
                return "";
            }
            for (j = 0; j < len; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    len = j;
                    break;
                }
            }
        }
        return prefix.substring(0, len);
    }
}

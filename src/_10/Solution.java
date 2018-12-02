package _10;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean dp[][] = new boolean[lenS+1][lenP+1];
        dp[0][0] = true;

        /* 情况分一下几种：
         * 1。s.charAt(i) == p.charAt(j)，那么dp[i][j] = dp[i-1][j-1]
         * 2。p.charAt(j) == '.'，那么dp[i][j] = dp[i-1][j-1]
         * 3。p.charAt(j) == '*'：
         *      1) p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)，那么dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j]
         *      2) p.charAt(j-1) != s.charAt(i)，那么dp[i][j] = dp[i][j-2]
         */

        // 第0位元素单独匹配
        for (int i = 0;i < lenP; i++) {
            dp[0][i+1] = p.charAt(i) == '*' && dp[0][i - 1];
        }

        for (int i = 0, j; i < lenS; i++) {
            for (j = 0; j < lenP; j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)) {
                        dp[i+1][j+1] = dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1];
                    } else if (p.charAt(j-1) != s.charAt(i)) {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }
}

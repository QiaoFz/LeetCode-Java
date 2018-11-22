package _5;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class Solution {

    /**
     * Manacher算法
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder("$#");
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i) + "#");
        }
        String newS = sb.append("@").toString();
        len = newS.length() - 1;
        int[] p = new int[len];
        int id = 1;
        int mx = 1;
        int maxLen = 1;
        p[1] = 1;
        for (int i = 2; i < len; i++) {
            if (i < mx) {
                p[i] = p[2*id - i] > mx - i ? mx - i : p[2*id - i];
            } else {
                p[i] = 1;
            }
            while (newS.charAt(i-p[i]) == newS.charAt(i+p[i])) {
                p[i]++;
            }
            if (p[i]-1 >= maxLen) {
                maxLen = p[i] - 1;
                id = i;
                mx = i + p[i] - 1;
            }
        }
        int startIdx = (id - p[id])/2;
        return s.substring(startIdx, startIdx + maxLen);
    }
}

package _3;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("cdd");
    }

    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;
        int maxLen = 0;
        int[] map = new int[128];

        while (end < s.length()) {
            // 判断这个char是否出现过
            if (map[s.charAt(end++)]++ == 0) {
                // 如果没有出现过，判断是否需要更新最长长度
                maxLen = Math.max(maxLen, end - start);
            } else {
                // 出现过，因为前面end自加过，这里减1，然后start加1，再把对应的start位置的char对应的数组位置置为0
                // 但因为出现第二次的字符串值为2，故用while循环给start++，直到到了end—1相同char处，使其值为1
                while (map[s.charAt(end-1)] > 1) {
                    map[s.charAt(start++)]--;
                }
            }
        }

        return maxLen;
    }
}

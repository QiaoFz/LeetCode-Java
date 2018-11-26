package _6;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Solution {


    /**
     * 可以看出每2n-2个数一个循环，收尾两行就一个，别的两个，看出规律即可
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int size = 2 * numRows - 2;
        int tmpIdx;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += size) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1) {
                    tmpIdx = j + size - 2 * i;
                    if (tmpIdx < len) {
                        sb.append(s.charAt(tmpIdx));
                    }
                }
            }
        }
        return sb.toString();
    }
}

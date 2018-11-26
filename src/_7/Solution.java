package _7;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed
 * integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns
 * 0 when the reversed integer overflows.
 */
public class Solution {

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        long i;
        long tmp = Math.abs(x);
        long tmpX = 0;
        while (tmp > 0) {
            i = tmp % 10;
            tmp /= 10;
            tmpX = tmpX * 10 + i;
        }
        if (x > 0) {
            return tmpX > Integer.MAX_VALUE ? 0 : Long.valueOf(tmpX).intValue();
        } else  {
            return -tmpX < Integer.MIN_VALUE ? 0 : -Long.valueOf(tmpX).intValue();
        }
    }
}

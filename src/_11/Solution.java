package _11;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        solution.maxArea(height);
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int maxH = Math.min(height[0], height[len-1]);;
        int maxV = (len - 1) * maxH;
        int tmpV;
        int i = 0, j = len - 1;
        while (i < j) {
            if (maxH == height[i]) {
               for (i++; i < j; i++) {
                   if (maxH < height[i]) {
                       maxH = Math.min(height[i], height[j]);
                       tmpV = maxH * (j - i);
                       if (tmpV > maxV) {
                           maxV = tmpV;
                       }
                       break;
                   }
               }
            } else {
                for (j--; i < j; j--) {
                    if (maxH < height[j]) {
                        maxH = Math.min(height[i], height[j]);
                        tmpV = maxH * (j - i);
                        if (tmpV > maxV) {
                            maxV = tmpV;
                        }
                        break;
                    }
                }
            }
        }
        return maxV;
    }
}

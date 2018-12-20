package _16;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int val, sum;
        int len = nums.length;

        Arrays.sort(nums);
        val = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0, j, k; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                j = i + 1;
                k = len - 1;
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(val - target) > Math.abs(sum - target)) {
                        val = sum;
                        if (sum == target) {
                            return target;
                        }
                    }
                    if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return val;
    }
}

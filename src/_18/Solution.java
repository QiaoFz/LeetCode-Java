package _18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        fourSum(nums, -1);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (nums.length < 4) {
            return ansList;
        }
        Arrays.sort(nums);

        int i, j, k, l, sum;
        int len = nums.length;
        for (i = 0; i < len - 3; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (j = i + 1; j < len -2; j++) {
                    if (j == i + 1 || nums[j] != nums[j-1]) {
                        k = j + 1;
                        l = len - 1;
                        while (k < l) {
                            sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if (target == sum) {
                                ansList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                k++;
                                l--;
                                while (k < l && nums[k] == nums[k - 1]) {
                                    k++;
                                }
                                while (k < l && nums[l] == nums[l + 1]) {
                                    l--;
                                }
                            } else if (target > sum) {
                                k++;
                            } else {
                                l--;
                            }
                        }
                    }
                }
            }
        }
        return ansList;
    }
}

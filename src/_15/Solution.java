package _15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4, 0, 0};
        Solution solution = new Solution();
        Arrays.sort(nums);
        List<List<Integer>> answer = solution.threeSum(nums);
        for (List<Integer> list : answer) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int i, j, k, target;
        for (i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                j = i + 1;
                k = len - 1;
                target = -nums[i];
                while (j < k) {
                    if (target == nums[j] + nums[k]) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j-1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k+1]) {
                            k--;
                        }
                    } else if (nums[j] + nums[k] > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return answer;
    }

}

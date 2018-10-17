package fourth;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean sign = (len1 + len2)%2 == 0;
        int totalLen = (len1 + len2)/2 + 1;
        int[] sortedNum = new int[totalLen];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (idx < totalLen) {
            if (i >= len1) {
                sortedNum[idx++] = nums2[j++];
            } else if (j >= len2) {
                sortedNum[idx++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sortedNum[idx++] = nums2[j++];
            } else {
                sortedNum[idx++] = nums1[i++];
            }
        }
        if (totalLen == 1) {
            return sortedNum[0];
        } else if (sign) {
            return (sortedNum[totalLen - 2] + sortedNum[totalLen - 1]) / 2.0;
        } else {
            return sortedNum[totalLen - 1];
        }
    }

}

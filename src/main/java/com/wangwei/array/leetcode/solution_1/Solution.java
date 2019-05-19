package com.wangwei.array.leetcode.solution_1;

/**
 * @auther wangwei
 * @date 2019-05-18 23:23
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{3,2,4};

        int[] ints = new Solution().twoSum(nums2, 6);

        System.out.print("[");

        for (int i = 0; i < ints.length; i++) {
            if (i < ints.length-1)
                System.out.print(ints[i] + ",");
            else
                System.out.println(ints[i] + "]");
        }
    }
}

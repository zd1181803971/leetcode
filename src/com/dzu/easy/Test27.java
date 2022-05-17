package com.dzu.easy;

import java.util.Arrays;

/**
 * @author ZhaoDong
 * @date 2022/5/17 10:00
 * @description 27. 移除元素
 */
public class Test27 {
    public static void main(String[] args) {
        int[] arrs = {3, 2, 2, 3};
        removeElement(arrs, 3);
        System.out.println(Arrays.toString(arrs));

    }

    /**
     * 双指针优化
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }


    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                if (nums[left] != nums[right]) {
                    nums[left] = nums[right];
                }
                left++;
            }
        }
        return left;
    }
}

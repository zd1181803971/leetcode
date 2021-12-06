package com.dzu.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author by ZhaoDong
 * @Classname TwoSum
 * @Description 两数之和
 * @Date 2021/12/6 22:01
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 5, 4, 2}, 6);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * 通过哈希表映射。时间复杂度O(n)、空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}

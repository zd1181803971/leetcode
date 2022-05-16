package com.dzu.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoDong
 * @date 2022/5/16 9:54
 * @description 1004. 最大连续1的个数 III
 * <p>
 * 给定一个二进制数组nums和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 */
public class Test1004 {

    public static void main(String[] args) {
        int i = longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        System.out.println(i);

    }

    public static int longestOnes(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < nums.length; end++) {
            int tail = nums[end];
            map.put(tail, map.getOrDefault(tail, 0) + 1);
            if (map.getOrDefault(0, 0) <= k) {
                max = Math.max(max, end - start + 1);
            }

            while (map.getOrDefault(0, 0) > k) {
                int head = nums[start];
                map.put(head, map.get(head) - 1);
                start++;
            }
        }
        return max;

    }
}

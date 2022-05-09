package com.dzu.slidingwindow;

/**
 * @author ZhaoDong
 * @date 2022/5/9 11:25
 * @description 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test209 {
    public static void main(String[] args) {
        int i = minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }

    // 180 ms
    public static int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int num = 0;
        int rest = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            num += nums[end];
            if (num >= target) {
                rest = Math.min(rest, end - start + 1);
            }
            // 不需要重新加，求和，删除第一个就行，见优化
            if (num >= target) {
                num = 0;
                end = start;
                start++;
            }
        }
        return rest == Integer.MAX_VALUE ? 0 : rest;
    }

    // 优化 1ms
    public static int minSubArrayLen2(int target, int[] nums) {

        int start = 0;
        int num = 0;
        int rest = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            num += nums[end];

            while (num >= target) {
                rest = Math.min(rest, end - start + 1);
                num -= nums[start];
                start++;
            }
        }
        return rest == Integer.MAX_VALUE ? 0 : rest;
    }

    // 1ms official
    public static int test2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

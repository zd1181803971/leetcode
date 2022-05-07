package com.dzu.slidingwindow;

/**
 * @author ZhaoDong
 * @date 2022/5/7 9:51
 * @description 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test643 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1};
        double maxAverage = findMaxAverage(arr, 1);
        System.out.println("maxAverage = " + maxAverage);

    }

    // 7ms
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int length = nums.length;
        for (int end = 0; end < length; end++) {
            sum += nums[end];
            if (end - start + 1 == k) {
                maxAvg = Math.max(maxAvg, sum / (double) k);
                sum -= nums[start];
                start++;
            }

        }
        return maxAvg;
    }

    // 2ms
    public static double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

}

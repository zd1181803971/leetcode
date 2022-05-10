package com.dzu.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoDong
 * @date 2022/5/10 9:52
 * @description 1695. 删除子数组的最大得分
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-erasure-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test1695 {

    public static void main(String[] args) {
        int i = maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5});
        System.out.println(i);
    }

    // 48ms
    public static int maximumUniqueSubarray(int[] nums) {

        // 5,2,1,2,5,2,1,2,5
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (map.containsKey(nums[end])) {
                sum -= nums[start];
                map.remove(nums[start]);
                start++;
            }

            map.put(nums[end], end);
            max = Math.max(max, sum);
        }
        return max;
    }

}

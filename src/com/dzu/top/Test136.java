package com.dzu.top;

import java.util.Arrays;

/**
 * @author ZhaoDong
 * @date 2022/5/18 9:35
 * @description 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？!!!!!!!!!!!!!!!!!
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test136 {
    public static void main(String[] args) {
        int i = singleNumber3(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);

    }

    /**
     * 	4 ms
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }

    /**
     * 异或 相同0 不同1
     * 1 ms
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }



    /**
     * 暴力查找
     * 210 ms
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                return nums[i];
            }
        }
        return 0;
    }
}

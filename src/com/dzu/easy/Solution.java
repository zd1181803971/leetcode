package com.dzu.easy;

import java.util.Arrays;

/**
 * @author ZhaoDong
 * @date 2022/4/25 9:46
 * @description 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 9, 9};
        int[] ints = plusOne(arr);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            int temp = digits[i] + 1;
            if (temp < 10) {
                digits[i] = temp;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;


    }

    public static int[] pulsOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}

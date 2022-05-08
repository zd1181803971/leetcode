package com.dzu.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoDong
 * @date 2022/5/8 21:11
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test3 {
    public static void main(String[] args) {

        int i = lengthOfLongestSubstring("pwwpkpew");
        test2("abcabcbb");
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char str = s.charAt(end);
            if (map.containsKey(str)) {
                start = Math.max(start, map.get(str) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(str, end);
        }

        return maxLength;
    }

    public static int test2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];

        int maxLength = 0;
        int start = 0; // 窗口开始位置
        for (int end = 0; end < s.length(); end++) {
            int index = s.charAt(end);
            start = Math.max(start, last[index]);
            maxLength = Math.max(maxLength, end - start + 1);
            last[index] = end + 1;
        }

        return maxLength;
    }
}

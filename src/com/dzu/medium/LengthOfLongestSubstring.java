package com.dzu.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoDong
 * @date 2022/4/20 17:05
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        int count = lengthOfLongestSubstring("abcaerti");
        System.out.println(count);
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                temp = Math.max(map.get(c) + 1, temp);
            }
            max = Math.max(max, i - temp + 1);
            map.put(c, i);
        }
        return max;
    }
}

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

        int count = lengthOfLongestSubstring("abba");
        System.out.println(count);
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (map.containsKey(str)) {
                // abba
                // 判断当前start和原先start的大小，否则会出现start比以前小的情况
                start = Math.max(map.get(str) + 1, start);
            }
            // 判断当前max与原来max的值
            // 当前max为 i-start+1, 如果没有重复的，start相当于0，所以最长字串就是s的长度
            // 如果有重复的，就找出上次重复的字符，然后从上次重复的字符的下一个开始算start，所以不含重复字符的字串，就是从上次重复的字符的下一个，到当前遍历的字符，中间那一块
            // 如果有多个重复的，每一次中间的字串长度都要和max进行对比，一直保留最长的
            max = Math.max(max, i - start + 1);
            map.put(str, i);
        }
        return max;
    }
}

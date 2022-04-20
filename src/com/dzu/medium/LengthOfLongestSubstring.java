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

        int count = lengthOfLongestSubstring("dvdf");
        System.out.println(count);
    }


    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int respCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int tempI = i;
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < s.length(); j++) {
                String si = String.valueOf(s.charAt(j));
                if (map.containsKey(si)) {
                    if (count > respCount) {
                        respCount = count;
                    }
                    count = 1;
                } else {
                    map.put(si, 1);
                    count++;
                }
            }
            s = s.substring(++tempI);
        }
        return Math.max(respCount, count);
    }
}

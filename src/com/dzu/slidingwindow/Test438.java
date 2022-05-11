package com.dzu.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhaoDong
 * @date 2022/5/11 11:06
 * @description 438. 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test438 {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);

    }


    public static List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> map_p = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            map_p.put(s.charAt(i), 1);

        }
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        String res = null;
        int start = 0;
        //s = "cbaebabacd", p = "abc"
        for (int end = 0; end < s.length(); end++) {
            char str = s.charAt(end);
            map.put(str, map.get(str) == null ? 1 : map.get(str) + 1);
            if (map.equals(map_p)) {
                list.add(start);
            }

            if (end >= p.length() - 1) {
                char key = s.charAt(start);

                map.put(key,  map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
                start++;
            }

        }
        return list;
    }

    public static List<Integer> findAnagrams2(String s, String p) {

        List<Integer> list = new ArrayList<>();

        Map<Character, Integer> map_p = new HashMap<>();
        for (char c : p.toCharArray()) {

            /**
             * 解决 重复的情况
             * "baa"
             * "aa"
             */
            map_p.put(c, map_p.get(c) == null ? 1 : map_p.get(c) + 1);
        }

        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int end = 0; end < length; end++) {
            char str = s.charAt(end);
            map.put(str, map.get(str) == null ? 1 : map.get(str) + 1);

            if (map_p.equals(map)) {
                list.add(start);
            }

            // 每次向右滑动,并且更新变量
            if (end - start >= p.length() - 1) {
                char key = s.charAt(start);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
                start++;
            }
        }
        return list;
    }

}

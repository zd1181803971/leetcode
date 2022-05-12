package com.dzu.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoDong
 * @date 2022/5/12 9:50
 * @description 567. 字符串的排列
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test567 {
    public static void main(String[] args) {
        boolean b = checkInclusion("ab", "eid1aooo");
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            char str = s2.charAt(end);
            map.put(str, map.getOrDefault(str, 0) + 1);

            if (map.equals(map1)) {
                return true;
            }

            if (end - start >= s1.length() - 1) {

                char key = s2.charAt(start);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
                start++;
            }
        }
        return false;
    }

}

package com.dzu.easy;

import sun.print.PeekGraphics;

/**
 * @author by ZhaoDong
 * @Classname RuoMaParseInteger
 * @Description 13. 罗马数字转整数
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000

 * @Date 2021/10/12 22:33
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *

 */
public class RuoMaParseInteger {
    public static void main(String[] args) {
        RuoMaParseInteger ruoMaParseInteger = new RuoMaParseInteger();
        System.out.println(ruoMaParseInteger.romanToInt("MCMXCIVI"));
    }
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            // 如果前面的数小于后面的数，应该减去
            if (preNum < num) {
                sum -= preNum;
            } else {
                // 否则加上
                sum += preNum;
            }
            // 让要处理的数 向前移动
            preNum = num;
        }
        // 最后剩余一个 不能跟下一个比较的 ，直接加上
        sum += preNum;
        return sum;
    }

    private int getValue(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

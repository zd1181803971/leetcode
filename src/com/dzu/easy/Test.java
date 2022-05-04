package com.dzu.easy;


/**
 * @author by ZhaoDong
 * @Classname Test
 * @Description TODO
 * @Date 2021/10/30 1:15
 */
public class Test {
    public static void main(String[] args) {
        hammingWeight(8);
    }
    public static int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int as = n >> i;
            int res = as & 1;
            ans += res;
        }
        return ans;
    }
}

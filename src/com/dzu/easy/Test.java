package com.dzu.easy;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author by ZhaoDong
 * @Classname Test
 * @Description TODO
 * @Date 2021/10/30 1:15
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("123", null);
        map.put("q", new BigDecimal("23"));
        String q12 = (String) map.get("q");

        if (map.get("q") instanceof String) {
            String q = (String) map.get("q");
            System.out.println(q);
        }
        if (map.get("q") instanceof BigDecimal) {
            BigDecimal q = (BigDecimal) map.get("q");
            System.out.println(q);
        }
    }
}

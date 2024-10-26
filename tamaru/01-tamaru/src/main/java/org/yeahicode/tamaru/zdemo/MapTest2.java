package org.yeahicode.tamaru.zdemo;

import java.util.*;

public class MapTest2 {
    public static void main(String[] args) {
        Map<String, Map<String, Object>> max = new HashMap<>();
        Map<String, Object> eaMap = max.get("EA");
        /**
         * 下面打印结果为null，
         */
//        eaMap = Optional.ofNullable(eaMap).orElse(new HashMap<>());
//        eaMap.put("GEA3020Dto", "123");
//        System.out.println(max.get("EA")); // null

        /**
         * 需要再放进put一次
         */
        eaMap = Optional.ofNullable(eaMap).orElse(new HashMap<>());
        eaMap.put("GEA3020Dto", "123");
        max.put("EA", eaMap);
        System.out.println(max.get("EA")); // {GEA3020Dto=123}
    }
}

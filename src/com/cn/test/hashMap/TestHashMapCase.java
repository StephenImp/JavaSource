package com.cn.test.hashMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMapCase {

    public static void main(String[] args) {

        Map<String,Double> map = new HashMap<>();

        map.put("K1",1D);
        map.put("K2",2D);


        System.out.println(map.get("K1"));
    }
}

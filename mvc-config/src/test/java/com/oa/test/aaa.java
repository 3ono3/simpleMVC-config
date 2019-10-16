package com.oa.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuoJingyuan
 * @date 2019/9/12
 */
public class aaa {
    public static void main(String[] args) {
        int aHundredMillion = 1000000;



        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        long s1 = System.currentTimeMillis();
        for (int i=0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("未初始化容量，耗时：" + (s2 - s1));
        map.clear();
        map=null;

        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>(aHundredMillion/2);
        long s3 = System.currentTimeMillis();
        for (int i=0; i < aHundredMillion; i++) {
            map1.put(i, i);
        }
        long s4 = System.currentTimeMillis();
        System.out.println("初始化容量500000，耗时：" + (s4 - s3));
        map1.clear();
        map1 = null;

        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(aHundredMillion);
        long s5 = System.currentTimeMillis();
        for (int i=0; i < aHundredMillion; i++) {
            map2.put(i, i);
        }
        long s6 = System.currentTimeMillis();
        System.out.println("初始化容量1000000，耗时：" + (s6 - s5));
        map2.clear();
        map2=null;

        int ll = (int) ((aHundredMillion/0.75)+1);

        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>(ll);
        long s7 = System.currentTimeMillis();
        for (int i=0; i < aHundredMillion; i++) {
            map3.put(i, i);
        }
        long s8 = System.currentTimeMillis();
        long dd = s8 - s7;
        System.out.println("初始化+"+ll+"，耗时：" + dd);
        map3.clear();
        map3 = null;
    }

}

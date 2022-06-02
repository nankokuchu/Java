package com.atzzazz.colection;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map map = new HashMap();

        //map.put(..,..)省略
        System.out.println("map的所有key:");

        Set keys = map.keySet();// HashSet
        for (Object key : keys) {
            System.out.println(key + "->" + map.get(key));
        }

        System.out.println("map的所有的value：");
        Collection values = map.values();
        Iterator iter = values.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("map所有的映射关系：");
// 映射关系的类型是Map.Entry类型，它是Map接口的内部接口
        Set mappings = map.entrySet();
        for (Object mapping : mappings) {
            Map.Entry entry = (Map.Entry) mapping;
            System.out.println("key是：" + entry.getKey() + "，value是：" + entry.getValue());
        }
    }
}

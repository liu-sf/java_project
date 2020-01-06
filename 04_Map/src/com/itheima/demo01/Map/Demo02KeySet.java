package com.itheima.demo01.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    Map集合的第一种遍历方式：通过键找值的方式
 */
public class Demo02KeySet {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        //1获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示:`keyset()`
        Set<String> set = map.keySet();

        //2遍历键的Set集合，得到每一个键。
        //迭代器
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            //3根据键，获取键所对应的值。方法提示:`get(K key)`
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }

        System.out.println("-------------------");
        //使用增强for遍历set集合
        for (String key: set) {
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }


    }
}






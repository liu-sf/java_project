package com.itheima.demo02.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    HashMap存储自定义类型键值
 */
public class Demo01HashMapSavePerson {
    public static void main(String[] args) {
        show02();
    }

    /*
    HashMap存储自定义类型
    key:Person类型
        Person类型就必须重写hashcode方法和equals方法，以保证key唯一
    value：String类型
        可以重复
     */
    private static void show02() {
        //创建HashMap集合
        HashMap<Person,String> map = new HashMap<>();
        //添加元素
        map.put(new Person("张三",18),"北京");
        map.put(new Person("李四",18),"上海");
        map.put(new Person("王五",18),"广州");
        map.put(new Person("张三",18),"深圳");
        //使用entrySet和增强for遍历Map集合
        Set<Map.Entry<Person, String>> set = map.entrySet();
        for (Map.Entry<Person,String> entry:set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"---"+value);
        }
    }

    /*
    HashMap存储自定义类型
    key:String 类型
        String类型重写hashcode方法和equals方法，可以保证key唯一
    value：Person类型
        value可重复
     */
    private static void show01() {
        //创建HashMap集合
        HashMap<String,Person> map = new HashMap<>();
        //添加元素
        map.put("北京",new Person("张三",18));
        map.put("上海",new Person("李四",19));
        map.put("广州",new Person("王五",20));
        map.put("北京",new Person("赵六",18));

        //使用keySet和增强for遍历Map集合
        Set<String> set = map.keySet();
        for(String key :set){
            Person value = map.get(key);
            System.out.println(key+"---"+value);
        }
    }
}







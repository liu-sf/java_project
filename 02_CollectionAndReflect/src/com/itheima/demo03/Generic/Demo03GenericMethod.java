package com.itheima.demo03.Generic;
/*

 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        //创建GenericMehtod对象
        GenericMethod gm = new GenericMethod();

        /*
        调用含有泛型的方法method01
         */
        gm.method01(10);
        gm.method01("abc");
        gm.method01(true);

        //静态方法
        GenericMethod.method02("静态方法");
        GenericMethod.method02(1);
    }
}

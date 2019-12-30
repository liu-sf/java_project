package com.itheima.demo03.Generic;

public class GenericClass<E> {
    private E name;

    public E getName(){
        return name;
    }

    public void setName(E name){
        this.name = name;
    }
}

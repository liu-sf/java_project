package com.itheima.demo07.Synchronized;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

/*
    卖票案例出现了线程安全问题
    卖出了不存在的票和重复的票


 */
public class RunnableImpl implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;

    //锁对象
    Object obj = new Object();
    //设置线程任务
    @Override
    public void run() {
        //使用死循环，让卖票操作重复执行
        while(true){
            synchronized (obj){
                //先判断票是否存在
                if(ticket > 0){
                    //提高安全问题出现的概率，让程序睡眠
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //票存在，卖票
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }
    }
}

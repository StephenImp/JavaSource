package com.cn.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLockCase {


    // 这个例子是有问题的
    // lock.lockInterruptibly();//响应打断 这个还需要再写一下
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket,"t1");
        Thread t2 = new Thread(){
            @Override
            public void run() {
                testSync();
            }
        };

        t1.start();//t1 睡眠时间很长
        t2.start();

        t2.interrupt();//t2 长时间拿不到锁，想中断这个线程



        System.out.println("test");
    }


    public static void testSync(){

        try {
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName());

        } catch (InterruptedException e) {
        }

    }


}

class Ticket implements Runnable {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {

            lock.lock(); //上锁

            try {
                lock.lockInterruptibly();//响应打断
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                try {
                    Thread.sleep(2000000000);
                    System.out.println(Thread.currentThread().getName());

                } catch (InterruptedException e) {
                }


            } finally {
                lock.unlock(); //释放锁
            }
        }
    }
}

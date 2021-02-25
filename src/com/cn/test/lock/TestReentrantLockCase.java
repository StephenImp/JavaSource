package com.cn.test.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLockCase {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }
}

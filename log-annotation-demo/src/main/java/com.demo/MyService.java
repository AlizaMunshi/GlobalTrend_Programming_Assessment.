package com.logdemo;

import org.springframework.stereotype.Service;

@Service
class MyService {

    @LogExecutionTime
    public void doSomething() throws InterruptedException {
        Thread.sleep(2000);
    }
}
package com.huj.Interface.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author xuanwo
 * @date 2021/8/21
 * @description:
 */
public class FutureTest {
    public static void main(String[] args) {

        Callable<String> callableJob = new Callable<String>() {
            public String call() throws Exception {
                return "任务结束";
            }
        };
        FutureTask<String> task = new FutureTask<String>(callableJob);

        new Thread(task).start();


    }
}

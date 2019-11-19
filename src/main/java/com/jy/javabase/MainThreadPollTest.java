package com.jy.javabase;

import java.util.concurrent.*;

/**
 * Created by jiangyang on 2019/11/19.
 */
public class MainThreadPollTest {
//    public static void main(String[] args) {
//        ExecutorService e = new ThreadPoolExecutor(0, 2, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
//        e.submit(new A());
//        //5+3=8秒后main退出，因为ThreadPoolExecutor中没有线程main函数才会退出
//        //5秒后A运行结束，3秒后线程池清空，没有子线程存在，main函数退出
//        //如果不用线程池且A为后台线程则，main直接停止，不会等A执行完
//        System.out.println("main");
//    }

    public static void main(String[] args) {
        ExecutorService e = new ThreadPoolExecutor(0, 2, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new TaskDaemonFactory());
        e.submit(new A());
        //main函数运行结束则整个程序结束，不会等待A运行完，因为线程池中的线程都是后台线程
        System.out.println("main");
    }

    private static class A implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 5);
            } catch (Exception e) {

            }
            System.out.println("A t");
        }
    }
}


class TaskDaemonFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}

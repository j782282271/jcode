package com.jy.javabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by jiangyang on 2019/11/19.
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(a);
        Thread t = new Thread(new Runnable() {
            int count = -1;

            @Override
            public void run() {
                while (true) {
                    list.add(count++ + "");
                }
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.sleep(3);
        for (String s : list) {
            System.out.println(list.hashCode());
            System.out.println(s);
        }
    }
}

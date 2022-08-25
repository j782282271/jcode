
package com.jy.javabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by za-jiangyang on 2020/3/21.
 */

public class CopyOnWriteArrayListTest1 {
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
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.hashCode());
            System.out.println(list.get(i));
        }
    }
}

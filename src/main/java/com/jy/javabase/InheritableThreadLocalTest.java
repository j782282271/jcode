
package com.jy.javabase;

/**
 * Created by za-jiangyang on 2020/3/21.
 */

public class InheritableThreadLocalTest {
    public static void main(String[] args) {
        InheritableThreadLocal inheritableThread = new InheritableThreadLocal();
        inheritableThread.set("a");
        System.out.println(inheritableThread.get());

        Thread t = new Thread(() -> {
            inheritableThread.set("b");
            System.out.println(inheritableThread.get());
        });
        t.start();
    }
}

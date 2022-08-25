
package com.jy.javabase;

/**
 * Created by za-jiangyang on 2020/3/21.
 */

public class ThreadLocalTest {
    private static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        threadLocal.set("");
    }
}

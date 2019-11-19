package com.jy.javabase;

/**
 * Created by jiangyang on 2019/11/15.
 */
public class NULL {
    public static void fff() {
        System.out.println("fa");
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        ((NULL) null).fff();
        int x = 4;
        System.out.println("value is " + 9);
        System.out.println("value is " + ((x > 4) ? 99.9 : 9));
        Object obj = new Object() {
            public int hashCode() {
                return 42;
            }

        };
        System.out.println(obj.hashCode());
    }

}

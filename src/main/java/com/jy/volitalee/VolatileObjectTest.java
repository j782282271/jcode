
package com.jy.volitalee;

/**
 * Created by za-jiangyang on 2020/11/21.
 */

public class VolatileObjectTest implements Runnable {
    private volatile ObjectA a;

    public VolatileObjectTest(ObjectA a) {
        this.a = a;
    }

    public ObjectA getA() {
        return a;
    }

    public void setA(ObjectA a) {
        this.a = a;
    }

    @Override
    public void run() {
        long i = 0;
        while (a.isFlag() ) {
            i++;
        }
        System.out.println("stop My Thread " + i + a.isFlag());
    }

    public void stop() {
        a.setFlag(false);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
        System.out.println(System.getProperty("java.vm.name"));
        VolatileObjectTest test = new VolatileObjectTest(new ObjectA());
        Thread t = new Thread(test);
//        t.setDaemon(true);//2
        t.start();
        Thread.sleep(1000);
        test.stop();
        Thread.sleep(1000);
        System.out.println("Main Thread " + test.getA().isFlag());
    }

    static class ObjectA {
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }
}

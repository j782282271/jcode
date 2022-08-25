
package com.jy.reactor;

import java.io.IOException;

/**
 * Created by za-jiangyang on 2020/12/5.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            TCPReactor reactor = new TCPReactor(8080);
            reactor.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

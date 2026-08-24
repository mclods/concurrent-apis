package org.mclods.exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {
    private final Exchanger<String> exchanger;

    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String str;

        for (int i = 0; i<3; i++) {
            try {
                str = exchanger.exchange("");
                System.out.println("Received: " + str);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Thrown: " + e);
            }
        }
    }
}

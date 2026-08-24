package org.mclods.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void run() {
        Exchanger<String> exchanger = new Exchanger<>();

        var makeStrThread = new Thread(new MakeString(exchanger), "Make String");
        var useStringThread = new Thread(new UseString(exchanger), "Use String");

        makeStrThread.start();
        useStringThread.start();

        try {
            makeStrThread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        try {
            useStringThread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }
    }
}

package org.mclods.exchanger;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable {
    private final Exchanger<String> exchanger;

    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        char c = 'A';
        StringBuilder sb = new StringBuilder();
        String received;

        for(int i=0; i<3; ++i) {
            received = "";

            for(int j=0; j<5; ++j) {
                sb.append(c++);
            }

            try {
                received = exchanger.exchange(sb.toString());
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Thrown: " + e);
            }

            sb.setLength(0);
            sb.append(received);
        }

    }
}

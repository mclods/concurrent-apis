package org.mclods.executors;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
    private final int n;

    public Sum(int n) {
        this.n = n;
    }

    @Override
    public Integer call() {
        int sum = 0;

        for(int i=1; i<=n; i++) {
            sum += i;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }


        return sum;
    }
}

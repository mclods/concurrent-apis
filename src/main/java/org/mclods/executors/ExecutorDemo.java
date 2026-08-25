package org.mclods.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void run() {
        int sumOf = 1000, factorialOf = 10;
        double base = 10.0, height = 20.0;

        try (ExecutorService es = Executors.newFixedThreadPool(2)) {
            System.out.println("Starting Tasks");
            var sumTask = es.submit(new Sum(sumOf));
            var hypotenuseTask = es.submit(new Hypotenuse(base, height));
            var factorialTask = es.submit(new Factorial(factorialOf));

            var sum = sumTask.get();
            var hypotenuse = hypotenuseTask.get();
            var factorial = factorialTask.get();

            System.out.printf("Sum of first %d numbers is %d%n", sumOf, sum);
            System.out.printf("Hypotenuse of a right triangle with " +
                    "Base: %f, Height: %f is %f%n", base, height, hypotenuse);
            System.out.printf("Factorial of %d is %d%n", factorialOf, factorial);

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception Thrown: " + e);
        }
    }
}

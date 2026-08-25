package org.mclods.executors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecutorDemoTests {
    private final ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutputStream = System.out;

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(testOutputStream));
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOutputStream);
    }

    private String getConsoleOutput() {
        return testOutputStream.toString().replaceAll(System.lineSeparator(), "\n");
    }

    @Test
    @DisplayName("Test Executors")
    void testExecutors() {
        String expectedOutput = """
                Starting Tasks
                Sum of first 1000 numbers is 500500
                Hypotenuse of a right triangle with Base: 10.000000, Height: 20.000000 is 22.360680
                Factorial of 10 is 3628800
                """;

        ExecutorDemo.run();
        assertThat(getConsoleOutput()).isEqualTo(expectedOutput);
    }
}

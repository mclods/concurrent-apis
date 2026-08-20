package org.mclods.producer_consumer_semaphore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PCSemDemoTests {
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
    @DisplayName("Test producer consumer problem using semaphores")
    void testProducerConsumerProblemUsingSemaphores() {
        String expectedOutput = """
                Put 0
                Got 0
                Put 1
                Got 1
                Put 2
                Got 2
                Put 3
                Got 3
                Put 4
                Got 4
                Put 5
                Got 5
                Put 6
                Got 6
                Put 7
                Got 7
                Put 8
                Got 8
                Put 9
                Got 9
                """;

        PCSemDemo.run();
        assertThat(getConsoleOutput()).isEqualTo(expectedOutput);
    }
}

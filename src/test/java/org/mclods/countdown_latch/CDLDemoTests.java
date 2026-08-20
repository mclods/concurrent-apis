package org.mclods.countdown_latch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CDLDemoTests {
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
    @DisplayName("Test Countdown Latch")
    void testCountdownLatch() {
        String expectedOutput = """
                MyThread counting i=0
                MyThread counting i=1
                MyThread counting i=2
                MyThread counting i=3
                MyThread counting i=4
                Latch Opened
                """;

        CDLDemo.run();
        assertThat(getConsoleOutput()).isEqualTo(expectedOutput);
    }
}

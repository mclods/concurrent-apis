package org.mclods.phaser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhaserDemoTests {
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
    @DisplayName("Test Phaser")
    void testPhaser() {
        PhaserDemo.run();

        String output = getConsoleOutput();
        List<String> lines = List.of(
                "main beginning phase 0",
                "Thread 1 beginning phase 0",
                "Thread 2 beginning phase 0",
                "Thread 3 beginning phase 0",
                "main beginning phase 1",
                "Thread 1 beginning phase 1",
                "Thread 2 beginning phase 1",
                "Thread 3 beginning phase 1",
                "main beginning phase 2",
                "Thread 1 has completed all phases.",
                "Thread 2 has completed all phases.",
                "Thread 2 is completing execution.",
                "Thread 3 has completed all phases.",
                "Thread 3 is completing execution.",
                "Thread 1 is completing execution.",
                "main has completed all phases.",
                "Phaser is terminated: true"
        );

        lines.forEach(line -> assertThat(output).contains(line));
        assertThat(output.indexOf(lines.get(0))).isLessThan(output.indexOf(lines.get(4)));
        assertThat(output.indexOf(lines.get(1))).isLessThan(output.indexOf(lines.get(4)));
        assertThat(output.indexOf(lines.get(2))).isLessThan(output.indexOf(lines.get(4)));
        assertThat(output.indexOf(lines.get(3))).isLessThan(output.indexOf(lines.get(4)));

        assertThat(output.indexOf(lines.get(4))).isLessThan(output.indexOf(lines.get(8)));
        assertThat(output.indexOf(lines.get(5))).isLessThan(output.indexOf(lines.get(8)));
        assertThat(output.indexOf(lines.get(6))).isLessThan(output.indexOf(lines.get(8)));
        assertThat(output.indexOf(lines.get(7))).isLessThan(output.indexOf(lines.get(8)));

        assertThat(output.indexOf(lines.get(9))).isLessThan(output.indexOf(lines.get(15)));
        assertThat(output.indexOf(lines.get(10))).isLessThan(output.indexOf(lines.get(15)));
        assertThat(output.indexOf(lines.get(12))).isLessThan(output.indexOf(lines.get(15)));

        assertThat(output.indexOf(lines.get(15))).isLessThan(output.indexOf(lines.get(16)));
    }
}

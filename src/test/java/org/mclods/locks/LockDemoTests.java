package org.mclods.locks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mclods.utils.AssertHelper.assertContainsTimes;

public class LockDemoTests {
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
    @DisplayName("Test Lock")
    void testLock() {
        LockDemo.run();

        assertContainsTimes(getConsoleOutput(), "A is locking count.", 2);
        assertContainsTimes(getConsoleOutput(), "B is locking count.", 2);
        assertContainsTimes(getConsoleOutput(), "A has locked count.", 2);
        assertContainsTimes(getConsoleOutput(), "B has locked count.", 2);
        assertContainsTimes(getConsoleOutput(), "A is sleeping.", 2);
        assertContainsTimes(getConsoleOutput(), "B is sleeping.", 2);
        assertContainsTimes(getConsoleOutput(), "A is unlocking count.", 2);
        assertContainsTimes(getConsoleOutput(), "B is unlocking count.", 2);

        assertThat(getConsoleOutput()).satisfiesAnyOf(
                s -> assertThat(s).contains("A has updated count to 1"),
                s -> assertThat(s).contains("B has updated count to 1")
        );

        assertThat(getConsoleOutput()).satisfiesAnyOf(
                s -> assertThat(s).contains("A has updated count to 2"),
                s -> assertThat(s).contains("B has updated count to 2")
        );

        assertThat(getConsoleOutput()).satisfiesAnyOf(
                s -> assertThat(s).contains("A has updated count to 3"),
                s -> assertThat(s).contains("B has updated count to 3")
        );

        assertThat(getConsoleOutput()).satisfiesAnyOf(
                s -> assertThat(s).contains("A has updated count to 4"),
                s -> assertThat(s).contains("B has updated count to 4")
        );
    }
}

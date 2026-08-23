package org.mclods.cyclic_barrier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CBRDemoTests {
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
    @DisplayName("Test cyclic barrier")
    void testCyclicBarrier() {
        CBRDemo.run();

        var str1 = "MyThread1 waiting at barrier";
        var str2 = "MyThread2 waiting at barrier";
        var str3 = "MyThread3 waiting at barrier";
        var str4 = "Barrier Completed!";
        var str5 = "MyThread1 went past barrier";
        var str6 = "MyThread2 went past barrier";
        var str7 = "MyThread3 went past barrier";

        int indexOfStr4 = getConsoleOutput().indexOf(str4);

        assertThat(getConsoleOutput()).contains(str1, str2, str3, str4, str5, str6, str7);
        assertThat(getConsoleOutput().indexOf(str1)).isLessThan(indexOfStr4);
        assertThat(getConsoleOutput().indexOf(str2)).isLessThan(indexOfStr4);
        assertThat(getConsoleOutput().indexOf(str3)).isLessThan(indexOfStr4);
        assertThat(getConsoleOutput().indexOf(str5)).isGreaterThan(indexOfStr4);
        assertThat(getConsoleOutput().indexOf(str6)).isGreaterThan(indexOfStr4);
        assertThat(getConsoleOutput().indexOf(str7)).isGreaterThan(indexOfStr4);
    }
}

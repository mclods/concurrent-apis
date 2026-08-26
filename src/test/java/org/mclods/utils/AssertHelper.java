package org.mclods.utils;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertHelper {
    public static void assertContainsTimes(String actual, String expected, int times) {
        assertThat(actual).contains(expected);

        int count=0, idx=0;
        while ((idx = actual.indexOf(expected, idx)) != -1) {
            count++;
            idx += expected.length();
        }

        assertThat(count)
                .as("Expected '%s' to occur %d times in " +
                        "'%s' but occurred %d times", expected, times, actual, count)
                .isEqualTo(times);
    }
}

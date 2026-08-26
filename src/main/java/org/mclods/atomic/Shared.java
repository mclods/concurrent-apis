package org.mclods.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Shared {
    public static AtomicInteger count = new AtomicInteger(0);
}

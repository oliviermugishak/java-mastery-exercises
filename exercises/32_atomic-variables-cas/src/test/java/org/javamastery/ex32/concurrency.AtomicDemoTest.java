package org.javamastery.ex32;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.AtomicDemoTest {
    @Test
    public void providedCases() {
        assertEquals(4000, concurrency.AtomicDemo.atomicCount(4, 1000));
    }
}

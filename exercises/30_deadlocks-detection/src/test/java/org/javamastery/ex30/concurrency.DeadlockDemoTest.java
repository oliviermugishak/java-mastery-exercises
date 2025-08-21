package org.javamastery.ex30;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.DeadlockDemoTest {
    @Test
    public void providedCases() {
        assertTrue(concurrency.DeadlockDemo.detectDeadlock());
    }
}

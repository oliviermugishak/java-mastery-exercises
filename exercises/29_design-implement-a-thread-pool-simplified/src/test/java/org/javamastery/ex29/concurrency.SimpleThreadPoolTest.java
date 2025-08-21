package org.javamastery.ex29;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.SimpleThreadPoolTest {
    @Test
    public void providedCases() {
        assertEquals(10, concurrency.SimpleThreadPool.completedTasks(10, 2));
    }
}

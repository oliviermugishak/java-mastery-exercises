package org.javamastery.ex35;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.ParallelSumTest {
    @Test
    public void providedCases() {
        assertEquals(10, concurrency.ParallelSum.parallelSum(new int[]{1,2,3,4}));
    }
}

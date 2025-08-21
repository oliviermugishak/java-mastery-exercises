package org.javamastery.ex27;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.ExecDemoTest {
    @Test
    public void providedCases() {
        assertEquals(6, concurrency.ExecDemo.sumResults(new int[]{1,2,3}));
    }
}

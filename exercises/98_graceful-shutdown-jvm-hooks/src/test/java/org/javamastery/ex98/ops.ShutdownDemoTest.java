package org.javamastery.ex98;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ops.ShutdownDemoTest {
    @Test
    public void providedCases() {
        assertTrue(ops.ShutdownDemo.gracefulStop());
    }
}

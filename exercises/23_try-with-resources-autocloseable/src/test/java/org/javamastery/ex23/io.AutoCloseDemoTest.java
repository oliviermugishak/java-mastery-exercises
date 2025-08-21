package org.javamastery.ex23;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class io.AutoCloseDemoTest {
    @Test
    public void providedCases() {
        assertTrue(io.AutoCloseDemo.closedAfterTry());
    }
}

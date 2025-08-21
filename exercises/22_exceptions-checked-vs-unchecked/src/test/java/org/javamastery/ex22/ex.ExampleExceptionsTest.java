package org.javamastery.ex22;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ex.ExampleExceptionsTest {
    @Test
    public void providedCases() {
        assertEquals("ok", ex.ExampleExceptions.safeCall(false));
        assertEquals("error", ex.ExampleExceptions.safeCall(true));
    }
}

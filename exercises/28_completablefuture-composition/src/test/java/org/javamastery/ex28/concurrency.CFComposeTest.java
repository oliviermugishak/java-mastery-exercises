package org.javamastery.ex28;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.CFComposeTest {
    @Test
    public void providedCases() {
        assertEquals("xy", concurrency.CFCompose.composeAsync("x", "y"));
    }
}

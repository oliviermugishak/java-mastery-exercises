package org.javamastery.ex71;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class di.DemoTest {
    @Test
    public void providedCases() {
        assertEquals("Hello Oli", di.Demo.greeter("Oli"));
    }
}

package org.javamastery.ex25;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class net.NioEchoTest {
    @Test
    public void providedCases() {
        assertTrue(net.NioEcho.echoes("hello"));
    }
}

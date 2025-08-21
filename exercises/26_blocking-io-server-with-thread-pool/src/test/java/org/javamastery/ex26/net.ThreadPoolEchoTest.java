package org.javamastery.ex26;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class net.ThreadPoolEchoTest {
    @Test
    public void providedCases() {
        assertEquals(3, net.ThreadPoolEcho.concurrentResponses(3));
    }
}

package org.javamastery.ex73;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class reactive.FlowDemoTest {
    @Test
    public void providedCases() {
        assertTrue(reactive.FlowDemo.backpressureWorks());
    }
}

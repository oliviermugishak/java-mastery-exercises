package org.javamastery.ex17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class apt.AutoToStringDemoTest {
    @Test
    public void providedCases() {
        assertTrue(apt.AutoToStringDemo.processorGenerated());
    }
}

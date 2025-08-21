package org.javamastery.ex03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class access.VisibilityDemoTest {
    @Test
    public void providedCases() {
        assertEquals("allowed", access.VisibilityDemo.accessibleFrom("api"));
    }
}

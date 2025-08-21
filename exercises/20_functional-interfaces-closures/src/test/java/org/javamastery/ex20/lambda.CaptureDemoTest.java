package org.javamastery.ex20;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class lambda.CaptureDemoTest {
    @Test
    public void providedCases() {
        assertEquals(6, lambda.CaptureDemo.applyAndSum(new int[]{1,2,3}));
    }
}

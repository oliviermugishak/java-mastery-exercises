package org.javamastery.ex96;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class bytebuddy.ProxyDemoTest {
    @Test
    public void providedCases() {
        assertTrue(bytebuddy.ProxyDemo.intercepts());
    }
}

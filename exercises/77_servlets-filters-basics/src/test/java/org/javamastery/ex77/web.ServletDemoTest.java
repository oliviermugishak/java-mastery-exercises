package org.javamastery.ex77;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class web.ServletDemoTest {
    @Test
    public void providedCases() {
        assertEquals("Hello", web.ServletDemo.handle("/hello"));
    }
}

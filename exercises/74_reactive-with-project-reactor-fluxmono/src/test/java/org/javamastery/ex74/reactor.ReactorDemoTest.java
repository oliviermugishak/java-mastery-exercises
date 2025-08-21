package org.javamastery.ex74;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class reactor.ReactorDemoTest {
    @Test
    public void providedCases() {
        assertEquals(new String[]{"A","B"}, reactor.ReactorDemo.process(new String[]{"a","b"}));
    }
}

package org.javamastery.ex02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class jpms.ApiTest {
    @Test
    public void providedCases() {
        assertEquals("Hello Olivier", jpms.Api.greet("Olivier"));
    }
}

package org.javamastery.ex16;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class reflect.MethodHandleDemoTest {
    @Test
    public void providedCases() {
        assertTrue(reflect.MethodHandleDemo.handlesInvoke("x"));
    }
}

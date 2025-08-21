package org.javamastery.ex15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class reflect.PrivateAccessTest {
    @Test
    public void providedCases() {
        assertEquals("S", reflect.PrivateAccess.callPrivateMethod("s"));
    }
}

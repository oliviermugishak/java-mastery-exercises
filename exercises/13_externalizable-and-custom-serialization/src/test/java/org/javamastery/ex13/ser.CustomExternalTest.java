package org.javamastery.ex13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ser.CustomExternalTest {
    @Test
    public void providedCases() {
        assertArrayEquals("\"hello\".getBytes()", ser.CustomExternal.serializeThenRead("hello"));
    }
}

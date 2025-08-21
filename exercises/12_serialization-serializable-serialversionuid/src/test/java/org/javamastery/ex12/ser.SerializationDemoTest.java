package org.javamastery.ex12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ser.SerializationDemoTest {
    @Test
    public void providedCases() {
        assertFalse(ser.SerializationDemo.deserializeOld(new int[]{}));
    }
}

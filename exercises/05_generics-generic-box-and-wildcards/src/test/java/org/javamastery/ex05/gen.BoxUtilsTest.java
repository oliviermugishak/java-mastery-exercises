package org.javamastery.ex05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class gen.BoxUtilsTest {
    @Test
    public void providedCases() {
        assertEquals(6, gen.BoxUtils.sumInts(new int[]{1,2,3}));
    }
}

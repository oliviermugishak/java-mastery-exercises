package org.javamastery.ex07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class arrays.GenericArraysTest {
    @Test
    public void providedCases() {
        assertArrayEquals(new String[]{"","",""}, arrays.GenericArrays.makeStringArray(3));
    }
}

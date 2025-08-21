package org.javamastery.ex09;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ds.SimpleHashMapTest {
    @Test
    public void providedCases() {
        assertEquals(3, ds.SimpleHashMap.sizeAfterOperations(new String[]{"a","b","c"}, new String[]{"1","2","3"}));
    }
}

package org.javamastery.ex55;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class res.ResourceLoaderTest {
    @Test
    public void providedCases() {
        assertEquals("content", res.ResourceLoader.load("data.txt"));
    }
}

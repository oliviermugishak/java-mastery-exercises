package org.javamastery.ex04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class cl.CustomLoaderDemoTest {
    @Test
    public void providedCases() {
        assertTrue(cl.CustomLoaderDemo.distinctClassIdentities("./sample-versions"));
    }
}

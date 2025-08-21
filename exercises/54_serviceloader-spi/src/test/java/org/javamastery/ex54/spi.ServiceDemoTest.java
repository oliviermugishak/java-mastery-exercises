package org.javamastery.ex54;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class spi.ServiceDemoTest {
    @Test
    public void providedCases() {
        assertTrue(spi.ServiceDemo.loadsService());
    }
}

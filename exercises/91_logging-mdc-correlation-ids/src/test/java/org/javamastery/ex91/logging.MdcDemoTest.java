package org.javamastery.ex91;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class logging.MdcDemoTest {
    @Test
    public void providedCases() {
        assertEquals("ok", logging.MdcDemo.process("cid"));
    }
}

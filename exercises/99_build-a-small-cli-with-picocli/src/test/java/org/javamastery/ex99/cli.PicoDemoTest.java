package org.javamastery.ex99;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class cli.PicoDemoTest {
    @Test
    public void providedCases() {
        assertEquals("Usage", cli.PicoDemo.run(new String[]{"--help"}));
    }
}

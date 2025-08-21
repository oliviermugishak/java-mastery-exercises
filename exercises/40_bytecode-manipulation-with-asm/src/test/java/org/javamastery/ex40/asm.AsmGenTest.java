package org.javamastery.ex40;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class asm.AsmGenTest {
    @Test
    public void providedCases() {
        assertTrue(asm.AsmGen.generateClass("com.example.Gen"));
    }
}

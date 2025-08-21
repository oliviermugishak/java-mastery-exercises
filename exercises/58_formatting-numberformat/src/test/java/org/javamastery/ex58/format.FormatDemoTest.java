package org.javamastery.ex58;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class format.FormatDemoTest {
    @Test
    public void providedCases() {
        assertEquals("$1,234.50", format.FormatDemo.formatCurrency(1234.5, "en-US"));
    }
}

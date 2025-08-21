package org.javamastery.ex81;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class plugin.MavenReportTest {
    @Test
    public void providedCases() {
        assertTrue(plugin.MavenReport.generate("."));
    }
}

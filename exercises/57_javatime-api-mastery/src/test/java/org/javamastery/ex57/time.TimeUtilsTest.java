package org.javamastery.ex57;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class time.TimeUtilsTest {
    @Test
    public void providedCases() {
        assertEquals("2020-01-01T09:00:00Z", time.TimeUtils.toUtcIso("2020-01-01T12:00:00", "Europe/Kigali"));
    }
}

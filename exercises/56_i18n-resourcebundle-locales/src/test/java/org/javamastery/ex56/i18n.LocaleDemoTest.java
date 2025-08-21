package org.javamastery.ex56;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class i18n.LocaleDemoTest {
    @Test
    public void providedCases() {
        assertEquals("Jan 1, 2020", i18n.LocaleDemo.formatDate("2020-01-01T00:00:00Z", "en-US"));
    }
}

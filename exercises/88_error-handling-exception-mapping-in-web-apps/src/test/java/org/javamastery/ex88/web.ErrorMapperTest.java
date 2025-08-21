package org.javamastery.ex88;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class web.ErrorMapperTest {
    @Test
    public void providedCases() {
        assertEquals("BAD_REQUEST", web.ErrorMapper.map("java.lang.IllegalArgumentException"));
    }
}

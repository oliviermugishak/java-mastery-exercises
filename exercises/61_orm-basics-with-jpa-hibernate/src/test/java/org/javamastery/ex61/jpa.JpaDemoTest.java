package org.javamastery.ex61;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class jpa.JpaDemoTest {
    @Test
    public void providedCases() {
        assertEquals(1, jpa.JpaDemo.persistAndCount());
    }
}

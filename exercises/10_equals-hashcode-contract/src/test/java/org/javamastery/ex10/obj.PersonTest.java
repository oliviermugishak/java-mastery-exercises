package org.javamastery.ex10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class obj.PersonTest {
    @Test
    public void providedCases() {
        assertTrue(obj.Person.equalByFields("x", "x"));
    }
}

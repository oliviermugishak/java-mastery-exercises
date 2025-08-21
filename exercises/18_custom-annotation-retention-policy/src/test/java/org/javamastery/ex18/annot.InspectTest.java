package org.javamastery.ex18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class annot.InspectTest {
    @Test
    public void providedCases() {
        assertTrue(annot.Inspect.hasAnnotation("annot.SomeAnnotated"));
    }
}

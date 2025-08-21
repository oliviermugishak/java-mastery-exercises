package org.javamastery.ex24;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class nio.FileWatcherTest {
    @Test
    public void providedCases() {
        assertTrue(nio.FileWatcher.detectsCreation("./tmp"));
    }
}

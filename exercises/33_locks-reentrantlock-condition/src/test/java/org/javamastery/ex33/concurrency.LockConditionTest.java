package org.javamastery.ex33;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class concurrency.LockConditionTest {
    @Test
    public void providedCases() {
        assertEquals(100, concurrency.LockCondition.producedConsumed(100));
    }
}

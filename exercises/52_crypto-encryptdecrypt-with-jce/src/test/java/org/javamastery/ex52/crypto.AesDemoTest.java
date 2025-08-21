package org.javamastery.ex52;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class crypto.AesDemoTest {
    @Test
    public void providedCases() {
        assertTrue(crypto.AesDemo.roundTrip(new int[]{1,2,3}));
    }
}

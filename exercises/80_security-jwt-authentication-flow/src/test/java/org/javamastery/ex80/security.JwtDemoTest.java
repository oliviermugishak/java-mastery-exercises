package org.javamastery.ex80;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class security.JwtDemoTest {
    @Test
    public void providedCases() {
        assertTrue(security.JwtDemo.verifyToken("user1"));
    }
}

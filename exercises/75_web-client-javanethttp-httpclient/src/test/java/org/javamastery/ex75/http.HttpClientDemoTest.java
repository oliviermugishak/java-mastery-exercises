package org.javamastery.ex75;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class http.HttpClientDemoTest {
    @Test
    public void providedCases() {
        assertEquals(200, http.HttpClientDemo.statusCode("https://example.com"));
    }
}

package org.javamastery.ex48;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class jmh.BenchmarkDemoTest {
    @Test
    public void providedCases() {
        assertTrue(jmh.BenchmarkDemo.runBench());
    }
}

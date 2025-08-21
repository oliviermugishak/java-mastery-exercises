package org.javamastery.ex41;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class agent.AgentDemoTest {
    @Test
    public void providedCases() {
        assertTrue(agent.AgentDemo.agentCounts());
    }
}

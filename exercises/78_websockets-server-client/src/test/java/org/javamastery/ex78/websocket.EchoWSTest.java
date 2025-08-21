package org.javamastery.ex78;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class websocket.EchoWSTest {
    @Test
    public void providedCases() {
        assertTrue(websocket.EchoWS.echo("ping"));
    }
}

package org.javamastery.ex59;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class db.JdbcDemoTest {
    @Test
    public void providedCases() {
        assertEquals(1, db.JdbcDemo.insertedRows());
    }
}

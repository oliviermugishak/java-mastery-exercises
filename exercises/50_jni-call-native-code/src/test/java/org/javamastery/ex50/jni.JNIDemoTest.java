package org.javamastery.ex50;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class jni.JNIDemoTest {
    @Test
    public void providedCases() {
        assertEquals("native", jni.JNIDemo.callNative());
    }
}

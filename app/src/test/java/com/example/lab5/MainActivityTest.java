package com.example.lab5;

import static junit.framework.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

public class MainActivityTest {

    @Test
    public void testAsyncTask() {
        DataLoader dataLoader = null;

        assertNull(dataLoader);
    }

    @Test
    public void testNodeValue() {
        assertNull(XmlParser.getNodeValue("", null));
    }
}

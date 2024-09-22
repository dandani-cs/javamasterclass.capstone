package com.capstone.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CSVHelperTest {
    @Test
    public void shouldGenerateData() {
        String filename = "userstemp.csv";
        List<String> data = CSVHelper.getData(filename);
        Assertions.assertEquals(20, data.size());
    }

    @Test
    public void shouldGetExistingData() {
        String filename = "usersExistingTemp.csv";
        List<String> data = CSVHelper.getData(filename);
        Assertions.assertEquals(1, data.size());
    }
}

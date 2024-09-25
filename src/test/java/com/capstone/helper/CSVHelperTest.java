package com.capstone.helper;

import com.capstone.helper.faker.DataFaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;


public class CSVHelperTest {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd:HHmmss");

    @Test
    public void shouldGenerateData() {
        String expected = "uuid,firstname lastname";
        String filename = "users" + format.format(new Date()) +  ".csv";
        DataFaker faker = mock(DataFaker.class);
        when(faker.getData()).thenReturn(expected);
        List<String> data = CSVHelper.getData(filename, faker);
        Assertions.assertEquals(1, data.size());
        Assertions.assertEquals(expected, data.get(0));

        //cleanup
        File temp = new File(filename);
        temp.delete();
    }

    @Test
    public void shouldGetExistingData() {
        String filename = "userstemp.csv";
        DataFaker faker = mock(DataFaker.class);
        List<String> data = CSVHelper.getData(filename, faker);
        Assertions.assertEquals(20, data.size());
        verify(faker, never()).getData();
    }

    @Test
    public void shouldCreateFileAndWriteData() {
        Date date = new Date();
        String filename = CSVHelper.RESOURCES_DIR + "writeTemp" + format.format(date)+ ".csv";
        String expected = "foo";

        CSVHelper.writeData(filename, expected);

        File tempFile = new File(filename);
        Assertions.assertTrue(tempFile.exists());

        String result;
        try (Scanner reader = new Scanner(new FileReader(tempFile))) {
            result = reader.next();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(expected, result);

        //cleanup
        File temp = new File(filename);
        temp.delete();
    }
}

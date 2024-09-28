package com.capstone.helper;

import com.capstone.helper.faker.DataFaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVHelper {
    public static final String RESOURCES_DIR = System.getProperty("user.dir") + "\\capstone\\";

    public static List<String> getData(String filename, DataFaker faker) {
        String finalFilename = RESOURCES_DIR + filename;
        File file = validateFile(finalFilename);
        if (file.length() == 0)
        {
            generateFile(filename, faker);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + finalFilename + " cannot be found", e);
        } catch (IOException e) {
            throw new RuntimeException("File cannot be opened");
        }
    }

    public static void writeData(String path, String data) {
        validateFile(path);
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.append(data);
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be opened", e);
        }
    }

    private static File validateFile(String filename) {
        File file = getFileIfExists(filename);
        if (file == null) {
            file = new File(filename);
            try {
                if (file.createNewFile()) {
                    file = getFileIfExists(filename);
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                throw new IllegalStateException("File " + filename + " does not exist and cannot be created" );
            }
        }
        return file;
    }

    private static File getFileIfExists(String filename) {
        File file = new File(filename);
        return file.exists() ? file : null;
    }

    private static void generateFile(String filename, DataFaker faker) {
        String data = faker.getData();
        writeData(RESOURCES_DIR + filename, data);
    }

    public static boolean compareWithLine(String value, String line, int index)
    {
        return value.equals(line.split(",")[index]);
    }
}

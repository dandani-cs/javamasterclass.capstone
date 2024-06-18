package com.capstone.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVHelper {
    public static List<String> getData(String path) {
        ArrayList<String> data = new ArrayList<>();
        validateFile(path);
        try (Scanner csvScanner = new Scanner(new File(path))) {
            while (csvScanner.hasNextLine()) {
                data.add(csvScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + path + " cannot be found", e);
        }
        return data;
    }

    public static void writeData(String path, String data) {
        validateFile(path);
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.append(data);
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be opened", e);
        }
    }

    private static void validateFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new IllegalStateException("File " + path + "cannot be created" + e);
        }
    }
}

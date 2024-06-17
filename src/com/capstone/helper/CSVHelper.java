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
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.append(data);
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be opened", e);
        }
    }
}

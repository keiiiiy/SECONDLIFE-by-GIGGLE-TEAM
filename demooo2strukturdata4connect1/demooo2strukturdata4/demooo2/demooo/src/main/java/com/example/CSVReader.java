package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static String[] readLastLine(String filePath) throws IOException {
        String lastLine = "";
        String currentLine;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((currentLine = br.readLine()) != null) {
                lastLine = currentLine;
            }
        }

        return lastLine.split(",");
    }
}

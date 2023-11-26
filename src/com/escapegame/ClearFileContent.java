package com.escapegame;

import java.io.*;

public class ClearFileContent {

    public static void clearContent(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(""); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


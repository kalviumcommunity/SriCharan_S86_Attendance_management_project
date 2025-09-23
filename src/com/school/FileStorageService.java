package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileStorageService {
    public void saveData(List<? extends Storable> items, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Storable item : items) {
                pw.println(item.toDataString());
            }
            System.out.println("Saved " + items.size() + " records to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving to " + filename + ": " + e.getMessage());
        }
    }
}

package com.semyon.filtertool.io;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterService {

    public static <T> void writeToFile(String path, List<T> data, boolean isAppendMode) {

        Path filePath = Path.of(path);
        if(!isAppendMode){
            try {
                if (Files.exists(filePath)) {
                    Files.delete(filePath);
                }
                Files.createFile(filePath);
                // System.out.println("File recreated: " + filePath);
            } catch (IOException err) {
                System.err.println("Error: cannot create file is " + filePath + " - " + err.getMessage());
                return;
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(Path.of(filePath.toUri()).toFile(), isAppendMode))) {
            for (T item : data) {
                writer.println(item);
            }
            // System.out.println("Data has successfully written to: " + filePath);
        } catch (IOException err) {
            System.err.println("Error writing to file " + filePath + " - " + err.getMessage());
        }
    }
}

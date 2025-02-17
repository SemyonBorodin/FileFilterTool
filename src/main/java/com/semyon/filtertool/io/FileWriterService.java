package com.semyon.filtertool.io;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterService {

    // private final static String DEFAULT_PATH = System.getProperty("user.dir") + "/";


    public static <T> void writeToFile(String path, List<T> data, boolean isAppendMode) {

        Path filePath = Path.of(path);
        try {
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile(), isAppendMode))) {
                for (T item : data) {
                    writer.println(item);
                }
                System.out.println("Data successfully written to the file: " + path);
            }
            } catch (IOException err) {
                System.err.println("Error: could not write to file: " + path + " " + err.getMessage());
            }
    }
}

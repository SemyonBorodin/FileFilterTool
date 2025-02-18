package com.semyon.filtertool.io;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterService {

    // private final static String DEFAULT_PATH = System.getProperty("user.dir") + "/";


    public static <T> void writeToFile(String path, List<T> data, boolean isAppendMode) {

        Path filePath = Path.of(path);
        if(isAppendMode == false){
            try {
                if (Files.exists(filePath)) {
                    Files.delete(filePath);
                    System.out.println("File " + filePath + " was deleted for overwrite\n" +
                            " -a option is set false.");
                }
                Files.createFile(filePath);
                System.out.println("File recreated: " + filePath);
            } catch (IOException err) {
                System.err.println("Error: cannot create file is " + filePath + " - " + err.getMessage());
                return;
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(Path.of(filePath.toUri()).toFile(), isAppendMode))) {
            for (T item : data) {
                writer.println(item);
            }
            System.out.println("Data has successfully written to: " + filePath);
        } catch (IOException err) {
            System.err.println("Error writing to file " + filePath + " - " + err.getMessage());
        }

//            try {
//            if (Files.notExists(filePath)) {
//                Files.createFile(filePath);
//            }
//
//            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile(), isAppendMode))) {
//                for (T item : data) {
//                    writer.println(item);
//                }
//                System.out.println("Data successfully written to the file: " + path);
//            }
//            } catch (IOException err) {
//                System.err.println("Error: could not write to file: " + path + " " + err.getMessage());
//            }
    }
}

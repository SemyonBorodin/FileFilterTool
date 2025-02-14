package com.semyon.filtertool.io;
import java.io.BufferedReader;
import java.nio.file.*;

public class FileReader {
//    private final String outputPath;
//    private final String outputPrefix;
//    private final Boolean AddingMode;

    public static void readFile(String[] inputFiles){
        List<BufferedReader> bufferedReaders= new ArrayList<>();

        for (String inputFileName : inputFiles){
            BufferedReader bufferedReader = Files.newBufferedReader(Path.get(inputFileName));
            bufferedReaders.add(bufferedReader);
        }
    }
}

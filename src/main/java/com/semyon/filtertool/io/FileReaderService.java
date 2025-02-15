package com.semyon.filtertool.io;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
//    private final String outputPath;
//    private final String outputPrefix;
//    private final Boolean AddingMode;
    public static void readFile(String[] inputFileNames) throws IOException{
        List<String> lines = new ArrayList<>();
        List<BufferedReader> bufferedReaders = new ArrayList<>();
        try {
            for(String inputFileName: inputFileNames){
                try{
                    BufferedReader bufferedReader;
                    bufferedReader =  Files.newBufferedReader(Path.of(inputFileName));
                    bufferedReaders.add(bufferedReader);
                } catch (IOException err){
                    System.out.println("Opening file problem:" + err.getMessage());
                }
            }
            //file reading: to do
        } finally {
            //close files: to do
        }
    }
}

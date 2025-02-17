package com.semyon.filtertool.io;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {

    public static List<String> readFile(String[] inputFileNames){
        List<String> linesFromFiles = new ArrayList<>();
        List<BufferedReader> bufferedReaders = new ArrayList<>();
        try {
            for (String inputFileName : inputFileNames) {
                Path pathToCurrFile = Paths.get(inputFileName);
                if (Files.exists(pathToCurrFile) == false){
                    System.out.println("Error: there is no " + inputFileName
                            + "in " + pathToCurrFile);
                    continue;
                }
                try {
                    BufferedReader bufferedReader;
                    bufferedReader = Files.newBufferedReader(Path.of(inputFileName));
                    bufferedReaders.add(bufferedReader);
                } catch (IOException err) {
                    System.err.println("Opening file problem:" + err.getMessage());
                }
                // TO DO: other exceptions shoud be handled
            }
        boolean hasReadAnyLine = true;

        while (hasReadAnyLine) {
            hasReadAnyLine = false;
            for (BufferedReader bufferedReader : bufferedReaders) {
                try {
                    String curLine = bufferedReader.readLine();
                    if (curLine != null) {
                        linesFromFiles.add(curLine);
                        hasReadAnyLine = true;
                    }
                } catch (IOException err) {
                    System.err.println("Error: cannot read line from file:" + err.getMessage());
                }
            }
        }
    } finally {
        for (BufferedReader bufferedReader : bufferedReaders) {
            try {
                bufferedReader.close();
            } catch (IOException err) {
                System.err.println("Error: " + err.getMessage());
            }
        }
    }
    return linesFromFiles;
    }
}

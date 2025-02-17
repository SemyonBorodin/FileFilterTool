package com.semyon.filtertool.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirCreator {
    // creates dir if not exists and do nothing if already exists
    public void createDir(String pathDir) throws IOException {
        if (pathDir == null || pathDir.isBlank()){
            System.out.println("Output dir is set default:" + System.getProperty("user.dir"));
            return;
        }
        if(Files.exists(Path.of(pathDir)) == false){
            try {
                Files.createDirectories(Path.of(pathDir));
                System.out.println("Output dir " + pathDir + " is successfully created.");
            } catch (IOException err){
                System.err.println("Error: can't create directory " + pathDir);
            }
        }
        else {
            System.out.println("Output dir" + pathDir + " is already exists.");
        }
    }
}

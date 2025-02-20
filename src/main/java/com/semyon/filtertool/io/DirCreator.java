package com.semyon.filtertool.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirCreator {
    // creates dir if not exists and do nothing if already exists
    private static Path defaultPath = Paths.get(System.getProperty("user.dir")).toAbsolutePath();
    public static Path createDir(String pathDir) throws IOException {
        if (pathDir == null || pathDir.isBlank()){
            System.out.println("Output dir is set default:" + System.getProperty("user.dir"));
            return defaultPath;
        }

        Path path = Path.of(pathDir);

        try {
            // If relative path passed
            if(pathDir.startsWith("/") == false){
                path = Paths.get(System.getProperty("user.dir")).resolve(path).toAbsolutePath();
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                    // System.out.println("Output dir " + path + " is successfully created.");
                    return path;
                }
                else {
                    Files.createDirectories(path);
                    // System.out.println("Output dir is " + path);
                    return path;
                }
            }
            // If absolute path passed
            else {
                path = Paths.get(pathDir).toAbsolutePath();
                //WSL case
                if(Files.exists(Paths.get("/mnt/")) && !path.startsWith("/mnt")){
                    path = Paths.get("/mnt/c/" + pathDir).toAbsolutePath();
                    System.out.println("Fixed absolute path for WSL: " + path);
                    if (!Files.exists(path)) {
                        Files.createDirectories(path);
                        System.out.println("Output dir " + path + " is successfully created.");
                        return path;
                    }
                    else {
                        Files.createDirectories(path);
                        System.out.println("Output dir is " + path);
                        return path;
                    }
                }
                // Linux case
                else {
                    if (!Files.exists(path)) {
                        Files.createDirectories(path);
                        System.out.println("Output dir " + path + " is successfully created.");
                        return path;
                    }
                    else {
                        Files.createDirectories(path);
                        System.out.println("Output dir is " + path);
                        return path;
                    }
                }

                // TO DO: WINDOWS CASE
            }
        } catch (IOException err){
            System.err.println("Error: can't create directory " + pathDir +
                        ". Output dir is set default: " + System.getProperty("user.dir"));
                return defaultPath;
        }
    }
}

package com.semyon.filtertool.optionsParser;

public class OptionValidator {
    // & ; | * ? ' " ` [ ] ( ) $ < > { } ^ # \ / % ! cannot be in file name in linux
    private static final String bannedSymbols = "[&;~\\\\|.,\\\\*\\\\?'\"\\\\`\\\\\\\\\\\\(\\\\)\\\\$<>\\\\{\\\\}\\\\^#\\\\\\\\/%!]";

    public static boolean isValidPathFormat(String path){
        // if path invalid or empty we use default path
        if (path == null || path.isEmpty() ) { return false;}

        String[] pathParts = path.split("/");

        for (String part: pathParts){
            if (part.matches(".*" + bannedSymbols + ".*" )){
                System.err.println("Error: invalid path contains banned symbols here: " + part);
                return false; // path is invalid because contains banned symbol
            }
        }
        return true;
    }

    public static boolean isValidPrefixFormat(String prefix){
        if (prefix == null){
            return false;
        }
        if (prefix.isBlank()){
            return true;
        }
        return !prefix.matches(".*" + bannedSymbols + ".*");
    }

}

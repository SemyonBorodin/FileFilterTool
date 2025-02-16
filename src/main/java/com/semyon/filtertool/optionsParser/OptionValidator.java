package com.semyon.filtertool.optionsParser;

public class OptionValidator {
    // & ; | * ? ' " ` [ ] ( ) $ < > { } ^ # \ / % ! cannot be in file name in linux
    private static final String bannedSymbols = "[&;\\\\|\\\\*\\\\?'\"\\\\`\\\\\\\\\\\\(\\\\)\\\\$<>\\\\{\\\\}\\\\^#\\\\\\\\/%!]";

    public static boolean isValidPathFormat(String path){
        // if path invalid or empty we use default path
        String[] pathParts = path.split("/");
        for (String part: pathParts){
            // ? case when starts with something/lala
            // need to check  part.isEmpty()) => continue or smt like that?
            // case .. ?
            // if we have // in path .split will create "" in path
            // so if we consider nonempty path I think pathParts cannot contain ""
            if (part.matches(".*" + bannedSymbols + ".*" ) == true){
                return false; // path is invalid because contains banned symbol
            }
            else {return true;}
        }
        return false;
    }

    public static boolean isValidPrefixFormat(String prefix){
        if (prefix == null){
            return false;
        }
        if (prefix.isBlank()){
            return true;
        }
        if (prefix.matches(".*" + bannedSymbols + ".*" ) == false){
            return true;
        }
        else {
            return false;
        }
    }

}

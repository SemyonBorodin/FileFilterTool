package com.semyon.filtertool.optionsParser;

public class OptionValidator {

    public static boolean isValidPathFormat(String path){
        if(path.startsWith("/")){
            return true;
        }
        else {return false;}
    }

    public static boolean isValidPrefixFormat(String path){
        // & ; | * ? ' " ` [ ] ( ) $ < > { } ^ # \ / % ! cannot be in file name in linux
        System.out.println('a');
        return true;
    }

}

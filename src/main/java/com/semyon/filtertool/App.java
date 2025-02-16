package com.semyon.filtertool;

import com.semyon.filtertool.optionsParser.OptionParser;
import com.semyon.filtertool.dataSplitter.DataTypeSplitter;
import org.apache.commons.cli.ParseException;

import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main(String[] args) throws ParseException {
        OptionParser options = new OptionParser(args);
        String[] inputFilesNames = options.getInputFilesNames();
        String outputPath = options.getOutputPath();
        System.out.println(Arrays.toString(inputFilesNames));
//        System.out.println( "Hello World!" + args.length + outputPath
//                + Arrays.toString(inputFilesNames) +"3" + (inputFilesNames[1] instanceof String) + "4");
//        System.out.println("текущая директория " + System.getProperty("user.dir"));
//        DataTypeSplitter splitter = new DataTypeSplitter();
//        splitter.splitByType(List.of("__", "10E-1", "____", "bottom_Text", "__"));
//
//        System.out.println("Integers size (0 => needn't create or adding to file): "
//                + splitter.getIntegers().size());
    }

}

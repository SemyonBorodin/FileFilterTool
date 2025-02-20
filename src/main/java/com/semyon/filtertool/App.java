package com.semyon.filtertool;

import com.semyon.filtertool.io.FileCreator;
import com.semyon.filtertool.io.FileWriterService;
import com.semyon.filtertool.optionsParser.OptionParser;
import com.semyon.filtertool.dataSplitter.DataTypeSplitter;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static com.semyon.filtertool.io.DirCreator.createDir;
import static com.semyon.filtertool.optionsParser.OptionValidator.isValidPathFormat;
import static com.semyon.filtertool.statistics.Statistics.getFullStatistics;
import static com.semyon.filtertool.statistics.Statistics.getShortStatistics;

public class App
{
    public static void main(String[] args) throws ParseException, IOException {
        OptionParser options = new OptionParser(args);
        String[] inputFilesNames = options.getInputFilesNames();
        String outputPath = options.getOutputPath();
        System.out.println(Arrays.toString(inputFilesNames));
        System.out.println( "Hello World!" + args.length + outputPath
                + Arrays.toString(inputFilesNames) +"3" + (inputFilesNames[1] instanceof String) + "4");
        System.out.println("текущая директория " + System.getProperty("user.dir") + "/");
        DataTypeSplitter splitter = new DataTypeSplitter();
        splitter.splitByType(List.of("1000000000", "10E-1", "2", "333", "bottom_Text", "__"));
        List<Integer> testList = splitter.getIntegers();
        System.out.println("Integers size (0 => needn't create or adding to file): "
                + splitter.getIntegers() + isValidPathFormat(options.getOutputPath()) + options.getOutputPath());
        try {
            Path papap = createDir(options.getOutputPath());
            //System.out.println("Created " + options.getOutputPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path papap = createDir(options.getOutputPath());
        System.out.println(papap.toAbsolutePath() + " " + papap);
        String testOutputFileIntegers = papap.toString();
        testOutputFileIntegers = String.valueOf(papap.resolve("integers.txt"));
        System.out.println("testOutputFileIntegers: " + testOutputFileIntegers);
        // Append mode works well
        FileWriterService.writeToFile(testOutputFileIntegers, splitter.getIntegers(), options.isAddingMode());
        if(options.isShortStatistics()){
            getShortStatistics(testList);
            System.out.println("in " + testOutputFileIntegers + "!");
        }
        else {
            getFullStatistics(testList);
        }
    }

}

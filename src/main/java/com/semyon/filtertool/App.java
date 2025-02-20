package com.semyon.filtertool;

import com.semyon.filtertool.io.FileWriterService;
import com.semyon.filtertool.optionsParser.OptionParser;
import com.semyon.filtertool.dataSplitter.DataTypeSplitter;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.semyon.filtertool.io.DirCreator.createDir;
import static com.semyon.filtertool.io.FileReaderService.readFile;
import static com.semyon.filtertool.optionsParser.OptionValidator.isValidPathFormat;
import static com.semyon.filtertool.optionsParser.OptionValidator.isValidPrefixFormat;
import static com.semyon.filtertool.statistics.Statistics.getFullStatistics;
import static com.semyon.filtertool.statistics.Statistics.getShortStatistics;

public class App
{
    public static void main(String[] args) throws ParseException, IOException {

        OptionParser options = new OptionParser(args);
        String[] inputFilesNames = options.getInputFilesNames();
        String prefix = "";

        List<String> uniqueInputFilesNames = new ArrayList<>();
        for (String item : inputFilesNames) {
            if (!uniqueInputFilesNames.contains(item)) {
                uniqueInputFilesNames.add(item);
            }
        }
        String[] uniqueInputs = uniqueInputFilesNames.toArray(new String[0]);
        if (options.isUniqMode()){
            inputFilesNames = uniqueInputs;
        }
        String outputPath = options.getOutputPath();
        List<String> data = readFile(inputFilesNames);
        if(data.isEmpty()){
            System.out.println("Nothing to do: data is empty");
            return;
        }
        if(!isValidPathFormat(options.getOutputPath())){
            outputPath = createDir("").toString();
        }
        else {
            outputPath = createDir(outputPath).toString();
        }

        DataTypeSplitter splitter = new DataTypeSplitter();
        splitter.splitByType(data);

        List<Integer> intsList = splitter.getIntegers();
        List<Float> floatstList = splitter.getFloats();
        List<String> stringsList = splitter.getStrings();

        if(isValidPrefixFormat(options.getOutputPrefix())){
            prefix = options.getOutputPrefix();
        }
        else {
            prefix = "";
        }
        if(!intsList.isEmpty()){
            String intsOutputPath = Path.of(outputPath).resolve(prefix+"integers.txt").toString();
            FileWriterService.writeToFile(intsOutputPath, intsList, options.isAddingMode());

            if(options.isShortStatistics()){
                getShortStatistics(intsList);
                System.out.println("in " + prefix + "integers.txt" + "!");
            }
            else {
                getFullStatistics(intsList);
            }
        }
        if(!floatstList.isEmpty()){
            String floatsOutputPath = Path.of(outputPath).resolve(prefix+"floats.txt").toString();
            FileWriterService.writeToFile(floatsOutputPath, floatstList, options.isAddingMode());

            if(options.isShortStatistics()){
                getShortStatistics(floatstList);
                System.out.println("in " + prefix + "floats.txt" + "!");
            }
            else {
                getFullStatistics(floatstList);
            }
        }
        if(!stringsList.isEmpty()){
            String stringsOutputPath = Path.of(outputPath).resolve(prefix+"strings.txt").toString();
            FileWriterService.writeToFile(stringsOutputPath, stringsList, options.isAddingMode());

            if(options.isShortStatistics()){
                getShortStatistics(stringsList);
                System.out.println("in " + prefix + "strings.txt" + "!");
            }
            else {
                getFullStatistics(stringsList);
            }
        }
    }
}

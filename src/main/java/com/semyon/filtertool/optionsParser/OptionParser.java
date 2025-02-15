package com.semyon.filtertool.optionsParser;
import org.apache.commons.cli.*;

public class OptionParser {

    private final CommandLine cmd;

    public  OptionParser(String[] args) throws ParseException{

        Options options = new Options();
        options.addOption("o", true,"Path to output files.");
        options.addOption("p", true,"Prefix for output file names.");
        options.addOption("a", false,"Adding to existing files mode: " +
                "if the files exist, they will be expanded.");
        options.addOption("s", false,"Short statistics: " +
                "number of items written to the output files.");
        options.addOption("f", false,"Full statistics: " +
                "number of items written to the output files," +
                " minimum and maximum values, sum and average.");

        CommandLineParser parser = new DefaultParser();

        cmd = parser.parse(options, args);
    }
    // Read names of input files; i.e. read all the data without flags with args
    public String[] getInputFilesNames() {
        return cmd.getArgs();
    }

    public String getOutputPath(){
        return cmd.getOptionValue("o", System.getProperty("user.dir"));
    }

    public  String getOutputPrefix(){
        return  cmd.getOptionValue("p", "");
    }

    public  Boolean isAddingMode(){
        return  cmd.hasOption("a");
    }

    public  Boolean isShortStatistics(){
        return  cmd.hasOption("s");
    }

    public  Boolean isFullStatistics(){
        return  cmd.hasOption("f");
    }
}

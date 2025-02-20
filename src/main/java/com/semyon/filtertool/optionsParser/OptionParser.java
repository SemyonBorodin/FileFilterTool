package com.semyon.filtertool.optionsParser;
import org.apache.commons.cli.*;

import java.io.IOException;

import static com.semyon.filtertool.optionsParser.OptionValidator.isValidPathFormat;

public class OptionParser {

    private CommandLine cmd;
    private boolean atLeastInputFiles = false;
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
        options.addOption("u", false,"Unique input files: " +
                "-u remove duplicate input file names.\n" +
                "If the same file is passed multiple times,\n" +
                "it will not be processed an appropriate number of times.");

        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);
            if (cmd.getArgs().length > 0) {
                atLeastInputFiles = true;
            }
        }catch (ParseException err1){
            System.err.println("Error: incorrect arguments passed. " + err1.getMessage());
            // Form here -- we consider all the args as input files
            try {
                cmd = parser.parse(new Options(), args);
                atLeastInputFiles = true;
            } catch (ParseException err2) {
                System.err.println("Error during fallback parsing: " + err2.getMessage());
                cmd = new DefaultParser().parse(new Options(), new String[]{});
            }
            cmd = new DefaultParser().parse(new Options(),
                    new String[]{});
        }

    }

        // Read names of input files; i.e. read all the data without flags with args
        public String[] getInputFilesNames() {
            if(cmd.getArgs().length > 0 ){
                // System.out.println(cmd.getArgs().length + "cmd.getArgs().length");
                return cmd.getArgs();
            }
            else {
                System.err.println("Error: input files aren't specified.");
                System.exit(1);
            }
            return cmd.getArgs();
        }

    public String getOutputPath(){
        // Value of the argument after -o, null otherwise
        return cmd.getOptionValue("o", System.getProperty("user.dir"));
    }

    public String getOutputPrefix(){
        return  cmd.getOptionValue("p", "");
        // TO DO -- handling invalid format
    }

    public boolean isAddingMode(){
        return  cmd.hasOption("a");
    }

    public boolean isShortStatistics(){
        return  cmd.hasOption("s");
    }

    public boolean isFullStatistics(){
        return  cmd.hasOption("f");
    }

    public boolean isDuplicatesMode(){
        return  cmd.hasOption("f");
    }

}

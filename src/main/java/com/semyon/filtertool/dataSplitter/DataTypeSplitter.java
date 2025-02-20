package com.semyon.filtertool.dataSplitter;
import java.util.ArrayList;
import java.util.List;

public class DataTypeSplitter {
    private final List<Integer> integersList = new ArrayList<Integer>();
    private final List<Float> floatsList = new ArrayList<Float>();
    private final List<String> stringsList = new ArrayList<String>();

    public void splitByType(List<String> data) {
        for (String line : data) {
            try {
                integersList.add(Integer.parseInt(line));
            } catch (NumberFormatException err1) {
                try {
                    floatsList.add(Float.parseFloat(line));
                } catch (NumberFormatException err2) {
                    stringsList.add(line);
                }
            }
        }
    }
    public List<Integer> getIntegers() {
        return integersList;
    }
    public List<Float> getFloats() {
        return floatsList;
    }
    public List<String> getStrings() {
        return stringsList;
    }
}

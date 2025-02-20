package com.semyon.filtertool.dataSplitter;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class DataTypeSplitter {
    private final List<BigInteger> integersList = new ArrayList<BigInteger>();
    private final List<Float> floatsList = new ArrayList<Float>();
    private final List<String> stringsList = new ArrayList<String>();

    public void splitByType(List<String> data) {
        for (String line : data) {
            try {
                integersList.add(new BigInteger(line));
            } catch (NumberFormatException err1) {
                try {
                    floatsList.add(Float.parseFloat(line));
                } catch (NumberFormatException err2) {
                    stringsList.add(line);
                }
            }
        }
    }
    public List<BigInteger> getIntegers() {
        return integersList;
    }
    public List<Float> getFloats() {
        return floatsList;
    }
    public List<String> getStrings() {
        return stringsList;
    }
}

package com.semyon.filtertool.statistics;

import java.util.List;

public class Statistics {

    public static <T> void getShortStatistics(List<T> data) {

        System.out.print(data.size() + " elements successfully written ");
    }

    public static <T> void getFullStatistics(List<T> data) {

        T firstElem = data.get(0);
        String type = (firstElem instanceof Integer) ? "integers" : "floats";
        if (firstElem instanceof Number) {
            float min = Float.MAX_VALUE;
            float max = Float.MIN_VALUE;
            float sum = 0;

            for (T item : data) {
                float value = ((Number) item).floatValue();
                min = Math.min(min, value);
                max = Math.max(max, value);
                sum += value;
            }
            float average = sum / data.size();
            System.out.println("Full statistics for " + type + ":\n"
                    + "Elements successfully written: " + data.size() + "\n"
                    + "Min value: " + min + "\n"
                    + "Max value: " + max + "\n"
                    + "Sum equals: " + sum + "\n"
                    + "Average value equals: " + average + "\n");

        }
        else if(firstElem instanceof String) {
            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            for (T item : data) {
                int length = ((String) item).length();
                minLength = Math.min(minLength, length);
                maxLength = Math.max(maxLength, length);
            }
            System.out.println("Full statistics for " + type + ":\n"
                    + "Elements successfully written: " + data.size() + "\n"
                    + "Shortest string has length: " + minLength + ";\n"
                    + "Longest string has length: " + maxLength + ";\n");
        }
    }
}

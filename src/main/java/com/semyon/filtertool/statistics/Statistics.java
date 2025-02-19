package com.semyon.filtertool.statistics;

import java.util.List;

public class Statistics {

    public static <T> void getShortStatistics(List<T> data) {
        // Num elements written in file
        System.out.print(data.size() + " elements successfully written ");
    }

    public static <T> void getFullStatistics(List<T> data) {
        //Полная статистика для чисел
        //дополнительно содержит минимальное и максимальное значения, сумма и среднее.
        //Полная статистика для строк, помимо их количества, содержит также размер самой
        //короткой строки и самой длинной.

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
        System.out.println("Заглушка -- тест полной статистики");
    }
}

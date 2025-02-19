package com.semyon.filtertool.statistics;

import java.util.List;

public class Statistics {

    public static <T> void getShortStatistics(List<T> data){
        // Num elements written in file
        System.out.print(data.size() + " elements successfully written ");
    }
    public static <T> String getFullStatistics(List<T> data){
        //Полная статистика для чисел
        //дополнительно содержит минимальное и максимальное значения, сумма и среднее.
        //Полная статистика для строк, помимо их количества, содержит также размер самой
        //короткой строки и самой длинной.
        System.out.println("Заглушка -- тест полной статистики");
        return "test smt";
    }
}

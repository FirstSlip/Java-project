package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task_3 {
    private static Double start;
    private static Double max;
    private static Double min;

    public static void doTask3() throws SQLException {

        getMaxMin("Select Data_value From Offers Where Period BETWEEN '2014-01-01' AND '2016-12-31'");
        System.out.println("Максимальный перевод за период с 2014 по 2016 год: " + max + ", минимальный перевод: " + min);
        getMaxMin("Select Data_value From Offers Where Period BETWEEN '2016-01-01' AND '2020-12-31'");
        System.out.println("Максимальный перевод за период с 2016 по 2020 год: " + max + ", минимальный перевод: " + min);

    }

    private static void getMaxMin(String command) throws SQLException {
        ResultSet res = Database_our.getData(command);
        start = res.getDouble(1);
        max = start;
        min = start;
        while(res.next()) {
            Double number = res.getDouble(1);
            if (number>max){
                max=number;
            }
            if(number<min || number!=0){
                min = number;
            }
        }
    }
}

package com.company;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task_2 {
    private static Map<String, Integer> sum = new HashMap<>();
    private static Double median;

    public static void setMap() throws IOException, SQLException {
        ResultSet res = Database_our.getData("Select Period, Data_value From Offers");
        int count = 0;
        Double sumAll = 0.0;
        while(res.next()) {
            String date = res.getString(1);
            if (sum.containsKey(date)) {
                int value = sum.get(date) + 1;
                sum.put(date, value);
            } else {
                sum.put(date, 1);
            }
            count+=1;
            sumAll+=res.getDouble(2);
        }
        median=sumAll/count;
    }
    public static void doTask2(){
        System.out.println("Средний размер перевода в Долларах: " + median);
        System.out.println("Количество переводов за каждый уникальный период:");
        for (String i:sum.keySet()){
            System.out.println(i + " - " + sum.get(i));
        }
    }


    public static Map<String, Integer> getSum() {
        return sum;
    }
}

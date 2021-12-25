package com.company;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class Task_1 {
    private static Map<String, Double> sum = new HashMap<>();

    public static void setMap() throws IOException, ParseException, SQLException {
        ResultSet res = Database_our.getData("Select Period, Data_value From Offers");
        while(res.next()) {
            int year = Integer.parseInt(res.getString(1).split("-")[0]);
            String month = res.getString(1).split("-")[1];
            if (year==2020 && !res.getString(2).equals("")) {
                if (sum.containsKey(month)) {
                    double value = sum.get(month) + res.getDouble(2);
                    sum.put(month, value);
                } else {
                    sum.put(month, res.getDouble(2));
                }
            }
        }
    }




    public static Map<String, Double> getSum() {
        return sum;
    }
}


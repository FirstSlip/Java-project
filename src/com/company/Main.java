package com.company;

import org.jfree.chart.ui.ApplicationFrame;

import java.awt.*;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main{

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, ParseException {
        Database_our.connect();
        Task_1.setMap();
        ApplicationPanel panel = new ApplicationPanel();
        ApplicationFrame app= new ApplicationFrame("Task1");
        app.setMinimumSize(new Dimension(800, 800));
        app.add(panel.createDemoPanel(Task_1.getSum()));
        app.setVisible(true);

        Task_2.setMap();
        Task_2.doTask2();

        Task_3.doTask3();
    }
}


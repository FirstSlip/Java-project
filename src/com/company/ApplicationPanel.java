package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ApplicationPanel {

    private CategoryDataset createDataset(Map<String, Double> map)
    {
        Set<String> set = map.keySet();
        String[] months = {"Jan01", "Feb02", "Mar03", "Apr04", "May05", "Jun06", "Jul07", "Aug08", "Sep09", "Oct10", "Nov11", "Dec12"};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String i: months) {
            dataset.addValue(map.get(i.substring(3))/1000000000, "Сумма переводов за месяц", i.substring(0,3));
        }
        return dataset;
    }
    private JFreeChart createChart(CategoryDataset dataset)
    {
        JFreeChart chart = ChartFactory.createBarChart(
                "Сумма всех переводов за 2020 год",
                null,                   // x-axis label
                "Сумма переводов в млрд. долларов",                // y-axis label
                dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);

        return chart;
    }

    public JPanel createDemoPanel(Map<String, Double> map)
    {
        JFreeChart chart = createChart(createDataset(map));
        chart.setPadding(new RectangleInsets(4, 8, 2, 2));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        return panel;
    }
}
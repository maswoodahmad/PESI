package project;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class JFreeChartExample extends JFrame {
    private XYSeries dataSeries;

    public JFreeChartExample() {
        super("JFreeChart Example");

        // Create a new XYSeries to hold the data
        dataSeries = new XYSeries("Data");

        // Add some sample data to the series
        dataSeries.add(1.0, 1.0);
        dataSeries.add(2.0, 3.0);
        dataSeries.add(3.0, 2.0);
        dataSeries.add(4.0, 4.0);
        dataSeries.add(5.0, 3.5);

        // Create a new XYSeriesCollection to hold the series
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(dataSeries);

        // Create the chart using the dataset
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Current vs battery voltage", // Chart title
                "Voltage", // X-axis label
                "Current", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                true, // Show legend
                true, // Use tooltips
                false // Generate URLs
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();


        xAxis.setRange(-8.0, 8.0);
        yAxis.setRange(0.0, 10.0);
        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(true);
        plot.setDomainCrosshairValue(0.0);
        plot.setRangeCrosshairVisible(true);
        plot.setRangeCrosshairLockedOnData(true);
        plot.setRangeCrosshairValue(0.0);

        // Customize the chart appearance
        chart.setBackgroundPaint(Color.white);

        // Create a new ChartPanel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));

        // Add the chart panel to the frame
        add(chartPanel);

        // Set the size and visibility of the frame
        setSize(600, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFreeChartExample();
    }
}

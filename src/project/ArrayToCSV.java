package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class ArrayToCSV {

    private static final String[] COLUMN_NAMES = {"Metal Name", "Work Function", "Energy", "Voltage", "Current", "Intensity"};
    private static final Path FILE_PATH = Path.of("/Users/maswoodahmad/Desktop/PhotoElectric_Simulator/","data.csv");
    private static ArrayList<ArrayList<String>> dataList = new ArrayList<>();
    private static CSVWriter writer = null;

    public static void dataAdder(String metalName, String workFunction, String energy, String voltage, String current, String intensity) {
        ArrayList<String> data = new ArrayList<>();
        data.add(metalName);
        data.add(workFunction);
        data.add(energy);
        data.add(voltage);
        data.add(current);
        data.add(intensity);
        dataList.add(data);
    }

    public static void writeCsv() {
        try {
            // Check if the file already exists
            File file = FILE_PATH.toFile();
            boolean fileExists = file.exists();

            // Create the writer
            if (writer == null) {
                writer = new CSVWriter(new FileWriter(file, true));
            }

            // Write column names if file doesn't exist
            if (!fileExists) {
                writer.writeNext(COLUMN_NAMES);
            }

            // Write the data
            for (ArrayList<String> data : dataList) {
                String[] dataArray = data.toArray(new String[0]);
                writer.writeNext(dataArray);
            }

            // Clear the data list
            dataList.clear();

            // Clear the writer's buffer and close it
            writer.flush();
            writer.close();
            writer = null;

            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}

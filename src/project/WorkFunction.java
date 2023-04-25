package project;

import javax.swing.*;

public class WorkFunction {
    public JComboBox<String> workFunction() {
        String[][] metals = {
                {"Aluminum", "4.08"},
                {"Beryllium", "4.65"},
                {"Cesium", "2.14"},
                {"Copper", "4.7"},
                {"Gold", "5.1"},
                {"Iridium", "5.16"},
                {"Iron", "4.5"},
                {"Lead", "4.14"},
                {"Lithium", "2.9"},
                {"Magnesium", "3.68"},
                {"Molybdenum", "4.17"},
                {"Nickel", "5.01"},
                {"Niobium", "4.3"},
                {"Osmium", "5.1"},
                {"Platinum", "5.65"},
                {"Potassium", "2.24"},
                {"Rubidium", "2.1"},
                {"Silver", "4.73"},
                {"Sodium", "2.28"},
                {"Strontium", "2.59"},
                {"Tantalum", "4.12"},
                {"Thorium", "3.5"},
                {"Tin", "4.3"},
                {"Titanium", "4.33"},
                {"Tungsten", "4.5"},
                {"Uranium", "3.4"},
                {"Vanadium", "4.0"},
                {"Yttrium", "3.2"},
                {"Zinc", "4.3"},
                {"Zirconium", "4.1"}
        };
        JComboBox<String> workF= new JComboBox<>();

        for (int i = 0; i < metals.length; i++) {
            workF.addItem(metals[i][0]);
        }
        return workF;
    }

}
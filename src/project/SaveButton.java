package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static project.ArrayToCSV.writeCsv;

public class SaveButton {


    public JButton saveButton(){

        JButton JB= new JButton("Save data");

        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeCsv();

            }
        });
        return JB;
    }
}

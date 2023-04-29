package project;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class FileChooser    {


static public Path storagepath;
        public static void createUI(JPanel frame) {
            JPanel panel = new JPanel();
            LayoutManager layout = new FlowLayout();
            panel.setLayout(layout);
            String desktopPath = System.getProperty("user.home") + "/Desktop";
            Path directoryPath = Paths.get(desktopPath, "PhotoElectric_Simulator");

            if (!Files.exists(directoryPath)) {
                try {
                    Files.createDirectory(directoryPath);
                    System.out.println("Directory created at: " + directoryPath);
                } catch (Exception e) {
                    System.out.println("Error creating directory: " + e.getMessage());
                }
            } else {
                System.out.println("Directory already exists at: " + directoryPath);
            }

            JButton button = new JButton("Click Me!");
            final JLabel label = new JLabel();

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser( FileSystemView.getFileSystemView());
                    fileChooser.setCurrentDirectory(new File("/Users/maswoodahmad/Desktop"));
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fileChooser.setFileHidingEnabled(false);


                    int option = fileChooser.showOpenDialog(frame);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile().getAbsoluteFile();
                        storagepath= file.toPath();
                        System.out.println(storagepath);
                        System.out.println(file);
                        label.setText("Folder Selected: " + ((File) file).getName());
                    } else {
                        label.setText("Open command canceled");
                    }
                }
            });


            panel.add(button);
            panel.add(label);
            frame.add(panel, BorderLayout.CENTER);

        }
    }



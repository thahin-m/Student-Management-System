package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveStudents(ArrayList<Student> students) {

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(FILE_NAME, false));

            for (Student s : students) {
                bw.write(s.getId() + "," + s.getName() + "," + s.getMarks());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error while saving students.");

        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }

    // Load students from file
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double marks = Double.parseDouble(data[2]);

                Student s = new Student(id, name, marks);
                students.add(s);
            }

        } catch (IOException e) {
        	
            // File not found or empty – first run is fine

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }

        return students;
    }
}

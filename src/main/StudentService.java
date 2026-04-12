package main;

import java.util.ArrayList;

public class StudentService {

	 private ArrayList<Student> students;

	    public StudentService() {
	        students = FileHandler.loadStudents();
	    }

	    public void addStudent(Student student) {
	        students.add(student);
	        FileHandler.saveStudents(students);
	    }

	    public ArrayList<Student> getAllStudents() {
	        return students;
	    }

	    public Student findStudentById(int id) {
	        for (Student s : students) {
	            if (s.getId() == id) {
	                return s;
	            }
	        }
	        return null;
	    }
}

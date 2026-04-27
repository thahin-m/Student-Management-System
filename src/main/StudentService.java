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
	    
	    public void updateStudent(int id, String newName, double newMarks) {
	        for (Student s : students) {
	            if (s.getId() == id) {
	                s.setName(newName);
	                s.setMarks(newMarks);
	                break;
	            }
	        }
	        FileHandler.saveStudents(students);
	    }
	    
	    public boolean deleteStudent(int id) {
	        for (Student s : students) {
	            if (s.getId() == id) {
	                students.remove(s);
	                FileHandler.saveStudents(students);
	                return true;
	            }
	        }
	        return false;
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

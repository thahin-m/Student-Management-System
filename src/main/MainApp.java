package main;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StudentService service = new StudentService();
		
		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("-----STUDENT MANAGEMENT---- ");
			System.out.println("1. Add Student");
			System.out.println("2. View All Student");
			System.out.println("3. Search Student by ID");
			System.out.println("4. Exit");
			
			System.out.print("Choose an option : ");
			int choice = sc.nextInt();
			
			
			switch (choice) {
			case 1 :
				 System.out.print("Enter ID : ");
				 int id = sc.nextInt();

				 System.out.print("Enter Name : ");
				 String name = sc.next();
				 
				 System.out.print("Enter marks : ");
				 double marks = sc.nextDouble();
				 
				 Student st = new Student(id, name, marks);
				 service.addStudent(st);
				 System.out.println("Student Added Sucessefully");
				 break;
				 
			case 2 :
				 System.out.println("\nAll Students:");
                 for (Student s : service.getAllStudents()) {
                     System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Marks: " + s.getMarks());
                 }
                 break;
				
			case 3:
				System.out.print("Enter Student ID to Search: ");
				int searchId = sc.nextInt();
				Student found = service.findStudentById(searchId);
				if (found != null) {
					System.out.println("Student ID: "+found.getId() + ", Name: " + found.getName() + ", Marks: " + found.getMarks());
				}
				else {
					System.out.println("Student not found.");
				}
				break;
				
			case 4:
				exit = true;
				System.out.println("Exiting....");
				break;
				
			default:
				System.out.println("Invalid User! Try agin");
					
			}
		}
		
		sc.close();
		
	}
}

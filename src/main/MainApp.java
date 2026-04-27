package main;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StudentService service = new StudentService();
		
		boolean exit = false;
		
		while(!exit) {
			
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View All Student");
			System.out.println("5. Search Student by ID");
			System.out.println("6. Exit");
		
			
			System.out.print("Choose an option : ");
			int choice = sc.nextInt();
			
			
			switch (choice) {
			//add
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
				 
			// update
			case 2:
			    System.out.print("Enter Student ID to Update: ");
			    int updateId = sc.nextInt();

			    Student existing = service.findStudentById(updateId);

			    if (existing != null) {
			        System.out.print("Enter new name: ");
			        String newName = sc.next();

			        System.out.print("Enter new marks: ");
			        double newMarks = sc.nextDouble();

			        service.updateStudent(updateId, newName, newMarks);
			        System.out.println("Student updated successfully.");
			    } else {
			        System.out.println("Student not found.");
			    }
			    break;
			
			
			//delete
		  case 3:
		    System.out.print("Enter Student ID to Delete: ");
		    int deleteId = sc.nextInt();

		    boolean removed = service.deleteStudent(deleteId);

		    if (removed) {
		        System.out.println("Student deleted successfully.");
		    } else {
		        System.out.println("Student not found.");
		    }
		    break;
		    
		    //view
			case 4 :
				 System.out.println("\nAll Students:");
                 for (Student s : service.getAllStudents()) {
                     System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Marks: " + s.getMarks());
                 }
                 break;
			//search by ID
			case 5:
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
			
			//exist
			case 6:
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

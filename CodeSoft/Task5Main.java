package CodeSoft;

import java.util.Scanner;

public class Task5Main { 

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Student Management System");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.addStudent(scanner);
                    break;
                case 2:
                    manager.editStudent(scanner);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = manager.searchStudentByID(studentID);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    manager.displayAllStudents();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}

package CodeSoft;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class StudentManager {
    private ArrayList<Student> students;
    private final String filePath = "students.txt";

    public StudentManager() {
        students = loadStudents();
    }

    // Method to add a new student
    public void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student student = new Student(studentID, name, age, course);
        students.add(student);
        saveStudents();
        System.out.println("Student added successfully.");
    }

    // Method to edit a student's information
    public void editStudent(Scanner scanner) {
        System.out.print("Enter Student ID to edit: ");
        String studentID = scanner.nextLine();

        Student student = searchStudentByID(studentID);
        if (student != null) {
            System.out.print("Enter new name (leave empty to skip): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }

            System.out.print("Enter new age (leave empty to skip): ");
            String ageStr = scanner.nextLine();
            if (!ageStr.isEmpty()) {
                student.setAge(Integer.parseInt(ageStr));
            }

            System.out.print("Enter new course (leave empty to skip): ");
            String course = scanner.nextLine();
            if (!course.isEmpty()) {
                student.setCourse(course);
            }

            saveStudents();
            System.out.println("Student information updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to search for a student by ID
    public Student searchStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equalsIgnoreCase(studentID)) {
                return student;
            }
        }
        return null;
    }

    // Save students to file
    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load students from file
    private ArrayList<Student> loadStudents() {
        File file = new File(filePath);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                return (ArrayList<Student>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading students: " + e.getMessage());
            }
        }
        return new ArrayList<>();
    }
}

package Rsgiteration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseHelper courseDAO = new CourseHelper();
        StudentHelper studentDAO = new StudentHelper();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View all courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. View registered courses");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Course> courses = courseDAO.getAllCourses();
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    break;
                case 2:
                    System.out.println("Enter student ID:");
                    String studentID = scanner.nextLine();
                    System.out.println("Enter course code:");
                    String courseCode = scanner.nextLine();
                    boolean registered = courseDAO.registerStudent(courseCode, studentID);
                    if (registered) {
                        System.out.println("Successfully registered.");
                    } else {
                        System.out.println("Registration failed. Course may be full or not exist.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID:");
                    studentID = scanner.nextLine();
                    System.out.println("Enter course code:");
                    courseCode = scanner.nextLine();
                    boolean dropped = courseDAO.dropStudent(courseCode, studentID);
                    if (dropped) {
                        System.out.println("Successfully dropped.");
                    } else {
                        System.out.println("Dropping failed. Course may not be registered.");
                    }
                    break;
                case 4:
                    System.out.println("Enter student ID:");
                    studentID = scanner.nextLine();
                    List<Course> registeredCourses = studentDAO.getRegisteredCourses(studentID);
                    for (Course course : registeredCourses) {
                        System.out.println(course);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}

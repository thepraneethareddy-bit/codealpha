import java.util.ArrayList;
import java.util.Scanner;

/*
 * Student Grade Tracker
 * This program allows users to enter student names and grades,
 * then calculates average, highest, and lowest scores.
 */

// Student class to store name and grade
class Student {
    String name;
    double grade;
    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== Student Grade Tracker =====");

        // Input student data
        while (true) {
            System.out.print("\nEnter student name (or type 'done' to finish): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            sc.nextLine(); // clear buffer

            students.add(new Student(name, grade));
        }

        // Check if no data entered
        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }
        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
            }
        }

        double average = total / students.size();

        // Display summary report
        System.out.println("\n===== Summary Report =====");

        for (Student s : students) {
            System.out.println("Name: " + s.name + " | Grade: " + s.grade);
        }

        System.out.println("\nTotal Students : " + students.size());
        System.out.println("Average Grade  : " + average);
        System.out.println("Highest Grade  : " + highest);
        System.out.println("Lowest Grade   : " + lowest);

        sc.close();
    }
}
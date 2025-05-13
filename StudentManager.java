import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Roll No already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int[] marks = new int[3];
        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        Student student = new Student(rollNo, name, marks);
        students.add(student);
        System.out.println("Student added successfully!\n");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                s.displayStudent();
            }
        }
    }

    public void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();

        Student found = null;
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                found = s;
                break;
            }
        }

        if (found == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        found.setName(newName);

        int[] newMarks = new int[3];
        System.out.println("Enter new marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            newMarks[i] = scanner.nextInt();
        }
        found.setMarks(newMarks);

        System.out.println("Student updated successfully!");
    }

    public void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = scanner.nextInt();

        Student toRemove = null;
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

import java.io.*;
import java.util.*;

class Student {
    private String rollNo, name, grade;
    
    public Student(String rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }
    
    public String getRollNo() { 
        return rollNo; 
    }
    public String getName() {
        return name; 
    }
    public String getGrade() { 
        return grade; 
    }
    
    @Override
    public String toString() {
        return rollNo + "," + name + "," + grade;
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "students.txt";
    
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.loadFromFile();
        sms.run();
    }
    
    private void run() {
        while (true) {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All\n5. Save & Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1": addStudent(); break;
                case "2": removeStudent(); break;
                case "3": searchStudent(); break;
                case "4": displayAll(); break;
                case "5": saveToFile(); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    private void addStudent() {
        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();
        
        students.add(new Student(rollNo, name, grade));
        System.out.println("Student added successfully!");
    }
    
    private void removeStudent() {
        System.out.print("Enter Roll No to remove: ");
        String rollNo = sc.nextLine();
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo().equals(rollNo)) {
                students.remove(i);
                System.out.println("Student removed!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    private void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        String rollNo = sc.nextLine();
        
        for (Student s : students) {
            if (s.getRollNo().equals(rollNo)) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    private void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\nAll Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
    
    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(FILE_NAME)) {
            for (Student s : students) {
                pw.println(s);
            }
            System.out.println("Data saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    
    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    students.add(new Student(data[0], data[1], data[2]));
                }
            }
            System.out.println("Data loaded from file!");
        } catch (IOException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }
}

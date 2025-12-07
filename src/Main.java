import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        boolean running = true;

        System.out.println("=== Employee Management System Started ===");

        while (running) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        manager.addEmployee(id, name, dept, salary);
                        break;
                    case 2:
                        manager.viewAllEmployees();
                        break;
                    case 3:
                        System.out.print("Enter ID to search: ");
                        int searchId = scanner.nextInt();
                        manager.viewEmployee(searchId);
                        break;
                    case 4:
                        System.out.print("Enter ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Department: ");
                        String newDept = scanner.nextLine();
                        System.out.print("Enter New Salary: ");
                        double newSalary = scanner.nextDouble();
                        manager.updateEmployee(updateId, newName, newDept, newSalary);
                        break;
                    case 5:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = scanner.nextInt();
                        manager.deleteEmployee(deleteId);
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting... Data is saved.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear buffer
            }
        }
        scanner.close();
    }
}2
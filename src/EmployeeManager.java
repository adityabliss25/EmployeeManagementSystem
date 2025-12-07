import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    // HashMap: Key = ID (Integer), Value = Employee Object
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private final String FILE_NAME = "employees.txt";

    public EmployeeManager() {
        loadDataFromFile(); // Load data automatically when app starts
    }

    // --- CRUD OPERATIONS ---

    // 1. Create
    public void addEmployee(int id, String name, String dept, double salary) {
        if (employeeMap.containsKey(id)) {
            System.out.println("Error: Employee ID " + id + " already exists.");
        } else {
            Employee newEmp = new Employee(id, name, dept, salary);
            employeeMap.put(id, newEmp);
            System.out.println("Success: Employee added.");
            saveDataToFile(); // Auto-save after change
        }
    }

    // 2. Read (Single)
    public void viewEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            System.out.println(employeeMap.get(id));
        } else {
            System.out.println("Employee not found.");
        }
    }

    // 2. Read (All)
    public void viewAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\n--- All Employees ---");
            for (Employee emp : employeeMap.values()) {
                System.out.println(emp);
            }
        }
    }

    // 3. Update
    public void updateEmployee(int id, String newName, String newDept, double newSalary) {
        if (employeeMap.containsKey(id)) {
            Employee emp = employeeMap.get(id);
            emp.setName(newName);
            emp.setDepartment(newDept);
            emp.setSalary(newSalary);
            System.out.println("Success: Employee updated.");
            saveDataToFile(); // Auto-save
        } else {
            System.out.println("Error: Employee ID not found.");
        }
    }

    // 4. Delete
    public void deleteEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            System.out.println("Success: Employee deleted.");
            saveDataToFile(); // Auto-save
        } else {
            System.out.println("Error: Employee ID not found.");
        }
    }



    // Save HashMap data to a text file
    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employeeMap.values()) {
                writer.write(emp.toCSV()); // Write "101,Alice,HR,50000"
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from text file into HashMap
    private void loadDataFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String dept = parts[2];
                    double salary = Double.parseDouble(parts[3]);

                    Employee emp = new Employee(id, name, dept, salary);
                    employeeMap.put(id, emp);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
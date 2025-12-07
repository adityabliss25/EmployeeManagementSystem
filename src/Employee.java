import java.io.Serializable;

public class Employee implements Serializable {
    private final int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    // Setters (ID is final, so no setter for it)
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: $" + salary;
    }

    // Helper method to format data for saving to file (CSV style)
    public String toCSV() {
        return id + "," + name + "," + department + "," + salary;
    }
}
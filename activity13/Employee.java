public class Employee {
    private String name;
    private String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee [Name: " + name + ", ID: " + employeeId + "]";
    }
}
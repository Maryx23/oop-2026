package activity11;

public class HourlyEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public HourlyEmployee(String name, String employeeId, int hoursWorked, double hourlyRate) {
        super(name, employeeId, EmployeeType.HOURLY);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateEarnings() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hours Worked: " + hoursWorked + ", Hourly Rate: $" + hourlyRate;
    }
}
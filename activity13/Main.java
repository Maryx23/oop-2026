public class Main {
    public static void main(String[] args) {
        Repository<String> guestRepo = new Repository<>();
        guestRepo.add("Alice");
        guestRepo.add("Bob");
        guestRepo.add("Charlie");

        System.out.println("Total guests: " + guestRepo.size());
        System.out.println();

        Repository<Employee> employeeRepo = new Repository<>();
        employeeRepo.add(new Employee("John Doe", "EMP001"));
        employeeRepo.add(new Employee("Jane Smith", "EMP002"));

        Employee retrievedEmployee = employeeRepo.get(0);
        Result<Employee> result = new Result<>(retrievedEmployee, "Load Successful", true);

        result.display();
    }
}
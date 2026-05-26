package activity11;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n==== PAYROLL MENU ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Save Records");
            System.out.println("4. Load Records");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Type (1 = SALARIED, 2 = HOURLY): ");
                    int typeChoice = Integer.parseInt(scanner.nextLine());

                    if (typeChoice == 1) {
                        System.out.print("Base salary: ");
                        double salary = Double.parseDouble(scanner.nextLine());
                        System.out.print("Bonus: ");
                        double bonus = Double.parseDouble(scanner.nextLine());
                        employees.add(new SalariedEmployee(name, id, salary, bonus));
                    } else {
                        System.out.print("Hours worked: ");
                        int hours = Integer.parseInt(scanner.nextLine());
                        System.out.print("Hourly rate: ");
                        double rate = Double.parseDouble(scanner.nextLine());
                        employees.add(new HourlyEmployee(name, id, hours, rate));
                    }
                    System.out.println("Employee added.");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees on record.");
                    } else {
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 3:
                    FileHandler.save(employees);
                    break;

                case 4:
                    employees = FileHandler.load();
                    break;

                case 5:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
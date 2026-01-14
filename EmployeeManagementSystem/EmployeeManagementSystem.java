import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private HashMap<String, Employee> employeeMap = new HashMap<>();
    private static final String DATA_FILE = "employees.dat";
    private Scanner sc = new Scanner(System.in);

    public EmployeeManagementSystem() {
        loadFromFile();
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.menu();
    }

    void menu() {
        while (true) {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addEmployee(); break;
                case 2: viewAll(); break;
                case 3: searchById(); break;
                case 4: deleteEmployee(); break;
                case 5: saveToFile(); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    void addEmployee() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();
        System.out.print("Position: ");
        String pos = sc.nextLine();

        double sal;
        while (true) {
            try {
                System.out.print("Salary: ");
                sal = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter valid salary!");
            }
        }

        Employee e = new Employee(id, name, dept, pos, sal);
        employees.add(e);
        employeeMap.put(id, e);
        saveToFile();
        System.out.println("Employee added!");
    }

    void viewAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    void searchById() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        Employee e = employeeMap.get(id);
        if (e == null) System.out.println("Not found!");
        else System.out.println(e);
    }

    void deleteEmployee() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        Employee e = employeeMap.remove(id);
        if (e != null) {
            employees.remove(e);
            saveToFile();
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }
    }

    void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(employees);
        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    void loadFromFile() {
        File f = new File(DATA_FILE);
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            employees = (ArrayList<Employee>) ois.readObject();
            for (Employee e : employees) {
                employeeMap.put(e.getId(), e);
            }
        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}

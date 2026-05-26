package activity11;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.danilopianini.gson.RuntimeTypeAdapterFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_PATH = "employees.json";
    private final Gson gson;

    public FileHandler() {
        RuntimeTypeAdapterFactory<Employee> adapter = RuntimeTypeAdapterFactory
                .of(Employee.class, "type", true)
                .registerSubtype(SalariedEmployee.class, EmployeeType.SALARIED.name())
                .registerSubtype(HourlyEmployee.class, EmployeeType.HOURLY.name());

        this.gson = new GsonBuilder().registerTypeAdapterFactory(adapter).setPrettyPrinting().create();
    }

    public void save(ArrayList<Employee> employees) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public ArrayList<Employee> load() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Employee>>() {}.getType();
            ArrayList<Employee> result = gson.fromJson(reader, listType);
            return result != null ? result : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
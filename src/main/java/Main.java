import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        Map<String, Double> projectAverageDuration = employees.stream()
                .filter(e -> e.getAge() >= 30 && e.getAge() <= 50 && e.getSalary() > 60000)
                .flatMap(e -> e.getProjects().stream())
                .filter(p -> p.getDuration() > 6)
                .map(p -> new AbstractMap.SimpleEntry<>(p.getName().toUpperCase(), p.getDuration()))
                .distinct()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                ));

        List<Map.Entry<String, Double>> sortedProjects = projectAverageDuration.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());

        sortedProjects.forEach(entry -> {
            System.out.println("Проект: " + entry.getKey() + ", Средняя длительность: " + entry.getValue());
        });
    }

    private static List<Project> createProjects() {
        return Arrays.asList(
                new Project("Project A", 12),
                new Project("Project B", 8),
                new Project("Project C", 7),
                new Project("Project D", 10),
                new Project("Project E", 3),
                new Project("Project F", 6)
        );
    }

    private static List<Employee> createEmployees() {
        List<Project> projects = createProjects();
        return Arrays.asList(
                new Employee("Alice", 35, Arrays.asList(projects.get(0), projects.get(1)), 70000),
                new Employee("Bob", 45, Arrays.asList(projects.get(2), projects.get(0)), 65000),
                new Employee("Charlie", 28, Arrays.asList(projects.get(3), projects.get(4)), 55000),
                new Employee("David", 40, Arrays.asList(projects.get(3), projects.get(2)), 80000),
                new Employee("Eve", 50, Arrays.asList(projects.get(5), projects.get(2)), 60000)
        );
    }
}

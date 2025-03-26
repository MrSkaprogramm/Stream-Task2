import java.util.List;

public class Employee {
    String name;
    int age;
    List<Project> projects;
    double salary;

    public Employee(String name, int age, List<Project> projects, double salary) {
        this.name = name;
        this.age = age;
        this.projects = projects;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}

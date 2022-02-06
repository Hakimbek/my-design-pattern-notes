package prototype.design.pattern;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(
                1,
                "Hakim",
                "software engineer",
                5000.0,
                "R.Gaipov"
        );

        Prototype clonedEmployee = employee.getClone();

        System.out.println(employee);
        System.out.println(clonedEmployee);
    }
}

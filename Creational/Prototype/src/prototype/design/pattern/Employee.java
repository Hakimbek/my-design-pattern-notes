package prototype.design.pattern;

public class Employee implements Prototype {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String address;

    public Employee() {
    }

    public Employee(int id, String name, String designation, double salary, String address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public Prototype getClone() {
        return new Employee(this.id, this.name, this.designation, this.salary, this.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}

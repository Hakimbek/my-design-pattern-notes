# Prototype Design Pattern
Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.

This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.

## Example of Prototype Design Pattern

### Prototype.java
  
```java
interface Prototype {  
     public Prototype getClone();     
}
```

### Employee.java

```java
class Employee implements Prototype {  
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
```

### Main.java

```java
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
```

### Output:

```
Employee{id=1, name='Hakim', designation='software engineer', salary=5000.0, address='R.Gaipov'}
Employee{id=1, name='Hakim', designation='software engineer', salary=5000.0, address='R.Gaipov'}
```

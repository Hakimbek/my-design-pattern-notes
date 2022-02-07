# Composite Pattern
A Composite Pattern says that just "allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects".

## Example of Composite Pattern

## Step 1: Create Employee class having list of Employee objects.

### Employee.java

```java
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                '}';
    }
}
```

## Step 2: Use the Employee class to create and print employee hierarchy.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Employee CEO = new Employee("Hakim", "CEO", 30000);

        Employee headSales = new Employee("Arif","Head Sales", 20000);

        Employee headMarketing = new Employee("Hurshida","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(CEO);
    }
}
```

### Output:

```
Employee{name='Hakim', dept='CEO', salary=30000, subordinates=[
  Employee{name='Arif', dept='Head Sales', salary=20000, subordinates=[
    Employee{name='Richard', dept='Sales', salary=10000, subordinates=[]}, 
    Employee{name='Rob', dept='Sales', salary=10000, subordinates=[]}]}, 
  Employee{name='Hurshida', dept='Head Marketing', salary=20000, subordinates=[
    Employee{name='Laura', dept='Marketing', salary=10000, subordinates=[]}, 
    Employee{name='Bob', dept='Marketing', salary=10000, subordinates=[]}]}]}
```

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

### EmployeeRecord.java

```java
class EmployeeRecord implements Prototype {  
   private int id;  
   private String name;
   private String designation;  
   private double salary;  
   private String address;  
      
   public EmployeeRecord() {  
            System.out.println("   Employee Records of Oracle Corporation ");  
            System.out.println("---------------------------------------------");  
            System.out.println("Eid" + "\t" + "Ename" + "\t" + "Edesignation" + "\t" + "Esalary" + "\t\t" + "Eaddress");  
   }  
  
   public  EmployeeRecord(int id, String name, String designation, double salary, String address) {   
        this();  
        this.id = id;  
        this.name = name;  
        this.designation = designation;  
        this.salary = salary;  
        this.address = address;  
    }  
      
    public void showRecord(){        
        System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t" + address);  
    }  
  
    @Override  
    public Prototype getClone() {  
        return new EmployeeRecord(id, name, designation, salary, address);  
    }  
}
```

### PrototypeDemo.java

```java
class PrototypeDemo {  
     public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        System.out.print("Enter Employee Id: ");  
        int id = Integer.parseInt(br.readLine());  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Name: ");  
        String name = br.readLine();  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Designation: ");  
        String designation = br.readLine();  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Address: ");  
        String address = br.readLine();  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Salary: ");  
        double salary = Double.parseDouble(br.readLine());  
        System.out.print("\n");  
           
        EmployeeRecord employee = new EmployeeRecord(id, name, designation, salary, address);  
        employee.showRecord();  
        System.out.println("\n");  
        EmployeeRecord clonedEmployee = (EmployeeRecord) employee.getClone();  
        clonedEmployee.showRecord();  
    }     
}
```

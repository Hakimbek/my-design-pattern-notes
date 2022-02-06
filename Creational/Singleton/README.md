# Singleton design pattern in Java
Singleton Pattern says that just"define a class that has only one instance and provides a global point of access to it".

In other words, a class must ensure that only single instance should be created and single object can be used by all other classes.

## Example of Singleton Pattern

## Step 1: Create a Singleton Class.

### SingleObject.java

```java
public class SingletonObject {
    public static SingletonObject obj = new SingletonObject();

    private SingletonObject() {

    }

    public static SingletonObject getInstance() {
        return obj;
    }
}
```

## Step 2: Get the only object from the singleton class.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        SingletonObject firstSingletonObject = SingletonObject.getInstance();

        SingletonObject secondSingletonObject = SingletonObject.getInstance();

        System.out.println(firstSingletonObject.hashCode() == secondSingletonObject.hashCode());
    }
}
```

### Output:

```
true
```

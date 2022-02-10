# Facade Pattern
A Facade Pattern says that just "just provide a unified and simplified interface to a set of interfaces in a subsystem, therefore it hides the complexities of the subsystem from the client".

In other words, Facade Pattern describes a higher-level interface that makes the sub-system easier to use.

Practically, every Abstract Factory is a type of Facade.

## Example of Facade Pattern

## Step 1: Create an interface.

### Shape.java

```java
public interface Shape {
    void draw();
}
```

## Step 2: Create concrete classes implementing the same interface.

### Rectangle.java

```java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
```

### Circle.java

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
```

### Square.java

```java
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
```

## Step 3: Create a facade class.

### ShapeMaker.java

```java
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
```

## Step 4: Use the facade to draw various types of shapes.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
```

### Output:

```
Circle
Rectangle
Square
```

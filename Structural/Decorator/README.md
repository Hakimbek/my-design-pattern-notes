# Decorator Pattern
A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".

In other words, The Decorator Pattern uses composition instead of inheritance to extend the functionality of an object at runtime.

The Decorator Pattern is also known as **Wrapper**.

## Example of Decorator Pattern

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
        System.out.println("Shape: Rectangle");
    }
}
```

### Circle.java

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
```

## Step 3: Create abstract decorator class implementing the Shape interface.

### ShapeDecorator.java

```java
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    public void draw() {
        decoratorShape.draw();
    }
}
```

## Step 4: Create concrete decorator class extending the ShapeDecorator class.

### RedShapeDecorator.java

```java
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decoratorShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
```

## Step 5: Use the Main to decorate Shape objects.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
    }
}
```

### Output:

```
Shape: Circle
Shape: Circle
Border Color: Red
Shape: Rectangle
Border Color: Red
```

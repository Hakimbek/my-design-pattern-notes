# Flyweight Pattern
A Flyweight Pattern says that just "to reuse already existing similar kind of objects by storing them and create new object when no matching object is found".

## Example of Flyweight Pattern

## Step 1: Create an interface.

### Shape.java

```java
public interface Shape {
    void draw();
}
```

## Step 2: Create concrete class implementing the same interface.

### Circle.java

```java
public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: color - " + color + ", x - " + x + ", y - " + y + ", radius - " + radius);
    }
}
```

## Step 3: Create a factory to generate object of concrete class based on given information.

### ShapeFactory.java

```java
public class ShapeFactory {

    private static final HashMap circleMap = new HashMap();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating " + color + " circle");
        }
        return circle;
    }
}
```

## Step 4: Use the factory to get object of concrete class by passing an information such as color.

### Main.java

```java
public class Main {
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
```

### Output:

```
Creating Black circle
Circle: color - Black, x - 82, y - 57, radius - 100
Circle: color - Black, x - 15, y - 54, radius - 100
Circle: color - Black, x - 94, y - 0, radius - 100
Circle: color - Black, x - 42, y - 12, radius - 100
Creating Green circle
Circle: color - Green, x - 15, y - 33, radius - 100
Creating Blue circle
Circle: color - Blue, x - 39, y - 87, radius - 100
Circle: color - Green, x - 64, y - 34, radius - 100
Circle: color - Black, x - 52, y - 54, radius - 100
Circle: color - Blue, x - 49, y - 85, radius - 100
Circle: color - Green, x - 27, y - 29, radius - 100
Creating Red circle
Circle: color - Red, x - 56, y - 30, radius - 100
Circle: color - Blue, x - 50, y - 30, radius - 100
Circle: color - Black, x - 3, y - 6, radius - 100
Circle: color - Red, x - 93, y - 75, radius - 100
Creating White circle
Circle: color - White, x - 82, y - 40, radius - 100
Circle: color - Red, x - 51, y - 25, radius - 100
Circle: color - Black, x - 79, y - 70, radius - 100
Circle: color - Red, x - 31, y - 13, radius - 100
Circle: color - Blue, x - 72, y - 42, radius - 100
Circle: color - White, x - 71, y - 38, radius - 100
```

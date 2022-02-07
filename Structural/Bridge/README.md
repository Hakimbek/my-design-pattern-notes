# Bridge Pattern
A Bridge Pattern says that just "decouple the functional abstraction from the implementation so that the two can vary independently".

The Bridge Pattern is also known as **Handle** or **Body**.

## Example of Bridge Pattern

## Step 1: Create bridge implementer interface.

### DrawAPI.java

```java
public interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}
```

## Step 2: Create concrete bridge implementer classes implementing the DrawAPI interface.

### RedCircle.java

```java
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Red circle[radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}
```

### GreenCircle.java

```java
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Green circle[radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}
```

## Step 3: Create an abstract class Shape using the DrawAPI interface.

### Shape.java

```java
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
```

## Step 4: Create concrete class implementing the Shape interface.

### Circle.java

```java
public class Circle extends Shape {
    private int radius, x, y;

    public Circle(DrawAPI drawAPI, int radius, int x, int y) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
```

## Step 5: Use the Shape and DrawAPI classes to draw different colored circles.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Circle redCircle = new Circle(new RedCircle(), 10, 5, 6);
        Circle greenCircle = new Circle(new GreenCircle(), 10, 5, 6);

        redCircle.draw();
        greenCircle.draw();
    }
}
```

### Output:

```
Red circle[radius: 10, x: 5, y: 6]
Green circle[radius: 10, x: 5, y: 6]
```
